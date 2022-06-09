package com.wd.demo.t9search;

import android.app.Activity;
import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.TextView;

import com.wd.demo.R;

import java.util.ArrayList;
import java.util.List;

public class T9Activity extends Activity {

    List<Contact> mContactsAll;
    ContactsAdapter mContactsAdapter;
    T9Filter mT9Filter;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t9);

        mContactsAdapter = new ContactsAdapter();
        mT9Filter = new T9Filter();

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(mContactsAdapter);

        ((EditText) findViewById(R.id.editText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mT9Filter.filter(s);
            }
        });

        final ProgressDialog progressDialog = mProgressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);

        new AsyncTask<Void, Void, List<Contact>>() {

            @Override
            protected void onPreExecute() {
                progressDialog.show();
            }

            @Override
            protected List<Contact> doInBackground(Void... params) {
                Cursor cursor = getContentResolver().query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        new String[]{
                                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                                ContactsContract.CommonDataKinds.Phone.NUMBER
                        }, null, null, ContactsContract.CommonDataKinds.Phone.SORT_KEY_PRIMARY);

                List<Contact> contacts = new ArrayList<Contact>();
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(0);
                        String number = cursor.getString(1).replaceAll("[ \\(\\)-]+", "");
                        String t9Key = T9SearchSupport.buildT9Key(name);
                        contacts.add(new Contact(name, number, t9Key));
                    }
                    cursor.close();
                }
                //自己测试构建一些联系人
                String name = "吴迪";
                String number = "1500205463";
                String t9Key = T9SearchSupport.buildT9Key(name);
                contacts.add(new Contact(name, number, t9Key));

                String name1 = "张冰";
                String number1 = "15018531992";
                String t9Key1 = T9SearchSupport.buildT9Key(name1);
                contacts.add(new Contact(name1, number1, t9Key1));

                String name2 = "孙悟空";
                String number2 = "15688889999";
                String t9Key2 = T9SearchSupport.buildT9Key(name2);
                contacts.add(new Contact(name2, number2, t9Key2));
                long t1 = System.currentTimeMillis();
//                String name3 = "字数很长广东省是电视看多双卡双待是的发生的翻翻翻是的说是加";
//                String number3 = "18966663333";
//                String t9Key3 = T9SearchSupport.buildT9Key(name3);
//                contacts.add(new Contact(name3, number3, t9Key3));
                long t2 = System.currentTimeMillis();
                Log.i("wd", "耗时=" + (t2 - t1));
                return contacts;
            }

            @Override
            protected void onPostExecute(List<Contact> contacts) {
                mContactsAll = contacts;
                mContactsAdapter.setContacts(contacts);
                if (progressDialog.isShowing())
                    progressDialog.dismiss();
            }
        }.execute();
    }

    public void onDestroy() {
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        super.onDestroy();
    }

    private static class ViewHolder {
        public TextView name;
        public TextView phoneNumber;

        ViewHolder(View itemView) {
            name = (TextView) itemView.findViewById(R.id.name);
            phoneNumber = (TextView) itemView.findViewById(R.id.phoneNumber);
        }
    }

    private class ContactsAdapter extends BaseAdapter {

        private final SpannableStringBuilder mHighLightBuffer = new SpannableStringBuilder();

        private List<Contact> mContacts = new ArrayList<Contact>();

        public void setContacts(List<Contact> contacts) {
            mContacts.clear();
            if (contacts != null)
                Log.i("wd", "setContacts=" + contacts);
            mContacts.addAll(contacts);

            notifyDataSetInvalidated();
        }

        @Override
        public int getCount() {
            return mContacts.size();
        }

        @Override
        public Contact getItem(int position) {
            return mContacts.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.contact_list_item,
                        parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Contact contact = mContacts.get(position);

            holder.name.setText(T9SearchSupport.highLight(mHighLightBuffer, contact.nameMatchInfo,
                    contact.name, 0xFFFF4081));
            holder.phoneNumber.setText(T9SearchSupport.highLight(mHighLightBuffer,
                    contact.phoneNumberMatchInfo, contact.phoneNumber, 0xAFFF4081));

            return convertView;
        }
    }

    private class T9Filter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Contact> list = TextUtils.isEmpty(constraint)
                    ? mContactsAll
                    : T9SearchSupport.filter(mContactsAll, constraint.toString());

            FilterResults results = new FilterResults();
            if (list != null) {
                results.count = list.size();
                results.values = list;
            } else {
                results.count = 0;
                results.values = null;
            }
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            mContactsAdapter.setContacts((List<Contact>) results.values);
        }

    }

}
