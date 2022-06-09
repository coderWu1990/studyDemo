package com.wd.demo.util;

import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;

public class Utils {

    public static void showId3() {
        String TAG = "wd";
        long t1 = System.currentTimeMillis();
        String path = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + File.separator + "lsaq.mp3";

        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(path);
        // Log.d(TAG,
        // "parseMp3File名称: "
        // + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
        // Log.d(TAG,
        // "parseMp3File专辑: "
        // + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM));
        // Log.d(TAG,
        // "parseMp3File歌手: "
        // + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST));
        // Log.d(TAG,
        // "parseMp3File码率: "
        // + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_BITRATE));
        Log.d(TAG,
                "parseMp3File时长: "
                        + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
        // Log.d(TAG,
        // "parseMp3File类型: "
        // + mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_MIMETYPE));
        long t2 = System.currentTimeMillis();
        Log.d(TAG, "时长：" + (t2 - t1));
    }

    public void getListOfConnectedDevice() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader br = null;
                boolean isFirstLine = true;
                try {
                    // /proc/net/arp
                    br = new BufferedReader(new FileReader(
                            "/data/misc/dhcp/dnsmasq.leases"));
                    String line;

                    while ((line = br.readLine()) != null) {
                        if (isFirstLine) {
                            isFirstLine = false;
                            continue;
                        }
                        Log.i("wd", "line:" + line);
                        String[] splitted = line.split(" +");

                        if (splitted != null && splitted.length >= 4) {

                            String ipAddress = splitted[0];
                            String macAddress = splitted[3];

                            boolean isReachable = InetAddress.getByName(
                                    splitted[0]).isReachable(500); // this is
                            // network
                            // call so
                            // we cant
                            // do that
                            // on UI
                            // thread,
                            // so i take
                            // background
                            // thread.
                            if (isReachable) {
                                Log.d("wd", ipAddress + " : " + macAddress);

                            } else {
                                Log.d("wd", ipAddress + " : " + macAddress);

                            }

                        }

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

}
