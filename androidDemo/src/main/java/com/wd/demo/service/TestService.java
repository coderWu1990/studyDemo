package com.wd.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import java.io.FileDescriptor;

public class TestService extends Service {
    private static final String TAG = "TestService";

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "服务onBind了");
        return binder;
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "服务onCreate了");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "服务onDestroy了");
        super.onDestroy();
    }

    private IBinder binder = new IBinder() {

        @Override
        public boolean unlinkToDeath(DeathRecipient recipient, int flags) {
            Log.i(TAG, "unlinkToDeath");
            return false;
        }

        @Override
        public boolean transact(int code, Parcel data, Parcel reply, int flags)
                throws RemoteException {
            Log.i(TAG, "transact");
            return false;
        }

        @Override
        public IInterface queryLocalInterface(String descriptor) {
            Log.i(TAG, "queryLocalInterface");
            return null;
        }

        @Override
        public boolean pingBinder() {
            Log.i(TAG, "pingBinder");
            return false;
        }

        @Override
        public void linkToDeath(DeathRecipient recipient, int flags)
                throws RemoteException {
            Log.i(TAG, "linkToDeath");

        }

        @Override
        public boolean isBinderAlive() {
            Log.i(TAG, "isBinderAlive");
            return false;
        }

        @Override
        public String getInterfaceDescriptor() throws RemoteException {
            Log.i(TAG, "getInterfaceDescriptor");
            return null;
        }

        @Override
        public void dumpAsync(FileDescriptor fd, String[] args)
                throws RemoteException {
            Log.i(TAG, "dumpAsync");

        }

        @Override
        public void dump(FileDescriptor fd, String[] args) throws RemoteException {
            Log.i(TAG, "dump");

        }
    };
}
