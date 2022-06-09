package com.wd.demo.util.id3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Mp3Info {

    private final String TAG = "TAG"; // 文件头1-3   3

    private String songName; // 歌曲名4-33  30

    private String artist; // 歌手名34-63 30

    private String album;// 专辑名64-93 30

    private String year;// 年         94-97  4

    private String comment; // 备注98-125  28

    private byte r1, r2, r3; // 三个保留位126，127，128  3

    private boolean valid;// 是否Mp3文件

    public String fileName; // 歌曲对应的文件名

    public byte[] mp3Data;

    public Mp3Info(String file) {
        // 装载文件
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File(file), "r");
            // 定位随机访问文件对象读取数据指针的位置,定位到MP3文件最后倒数第128字节的地方
            raf.seek(raf.length() - 128);
            // 定义一个字节数组，长度为128，用于保存MP3信息数据
            mp3Data = new byte[128];
            // 将信息读到mp3Data里边
            raf.read(mp3Data);
            // 读出128个字节的前三个字节，判断是否是MP3文件
            String Tag = new String(mp3Data, 0, 3);
            String code = "GBK";
            System.out.println("tag=" + Tag + " data=" + new String(mp3Data, code));

            if (Tag.equalsIgnoreCase("TAG")) {
                // 是MP3文件
                valid = true;
                // 对MP3信息对象的各个字段进行置值
                songName = new String(mp3Data, 3, 30, code);
                artist = new String(mp3Data, 33, 30, code);
                album = new String(mp3Data, 63, 30, code);
                year = new String(mp3Data, 93, 4, code);
                comment = new String(mp3Data, 97, 28, code);
                // 三个字节的保留位
                r1 = mp3Data[125];
                r2 = mp3Data[126];
                r3 = mp3Data[127];
            } else {
                throw new IsNotMp3FileException();
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (IsNotMp3FileException e) {

            e.printStackTrace();
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public byte getR1() {
        return r1;
    }

    public void setR1(byte r1) {
        this.r1 = r1;
    }

    public byte getR2() {
        return r2;
    }

    public void setR2(byte r2) {
        this.r2 = r2;
    }

    public byte getR3() {
        return r3;
    }

    public void setR3(byte r3) {
        this.r3 = r3;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTAG() {
        return TAG;
    }

    public byte[] getMp3Data() {
        return mp3Data;
    }

    public void setMp3Data(byte[] mp3Data) {
        this.mp3Data = mp3Data;
    }

    public class IsNotMp3FileException extends Exception {

        /**
         *      * 非法mp3异常类     
         */
        private static final long serialVersionUID = 1L;

        public IsNotMp3FileException() {

            System.out.println("非MP3文件异常！请传入正常的MP3格式的文件");

        }
    }

}