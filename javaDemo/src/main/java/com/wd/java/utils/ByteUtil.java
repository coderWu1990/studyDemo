package com.wd.java.utils;

import java.nio.ByteBuffer;

/**
 * 处理字节的工具类
 */
public class ByteUtil {

	/**
	 * 获取字节数组异或校验值
	 * 
	 * @param datas
	 * @return
	 */
	public static byte getXor(byte[] datas) {
		byte temp = datas[0];
		// 校验字节之前的所有字节的异或值
		int length = datas.length - 1;
		for (int i = 1; i < length; i++) {
			temp ^= datas[i];
		}
		return temp;
	}

	public static String bytesToHexString(byte[] bArr) {
		StringBuffer sb = new StringBuffer(bArr.length);
		String sTmp;
		for (int i = 0; i < bArr.length; i++) {
			sTmp = Integer.toHexString(0xFF & bArr[i]);
			if (sTmp.length() < 2) {
				sTmp = "0" + sTmp;
			}
			System.out.print(sTmp.toUpperCase() + " ");
			sb.append(sTmp.toUpperCase());
		}
		System.out.println("");
		return sb.toString();
	}

	public static String byteToHexString(byte b) {
		String sTmp = Integer.toHexString(0xFF & b);
		if (sTmp.length() == 1) {
			sTmp = "0" + sTmp;
		}
		return sTmp;
	}

	/**
	 * 把int转字节数组
	 * 
	 * @param in
	 * @return
	 */
	public static byte[] intToByte(int in) {
		byte[] b = new byte[4];
		b[3] = (byte) (in & 0xff);
		b[2] = (byte) (in >> 8 & 0xff);
		b[1] = (byte) (in >> 16 & 0xff);
		b[0] = (byte) (in >> 24 & 0xff);
		return b;
	}

	public static byte[] getDateTime(int y, int m, int d, int h, int mi, int s) {
		ByteBuffer buffer = ByteBuffer.allocate(6);
		buffer.put(intToBcdByte(y));
		buffer.put(intToBcdByte(m));
		buffer.put(intToBcdByte(d));
		buffer.put(intToBcdByte(h));
		buffer.put(intToBcdByte(mi));
		buffer.put(intToBcdByte(s));
		return buffer.array();
	}

	public static byte[] getDateTime(int y, int m, int d) {
		ByteBuffer buffer = ByteBuffer.allocate(6);
		buffer.put(intToBcdByte(y));
		buffer.put(intToBcdByte(m));
		buffer.put(intToBcdByte(d));
		buffer.put((byte) 0);
		buffer.put((byte) 0);
		buffer.put((byte) 0);
		return buffer.array();
	}

	public static byte intToBcdByte(int i) {
		if (i < 0 || i > 99) {
			return (byte) 0x99;
		}
		int i1 = (i % 10) & 0x0F;
		int i2 = (i / 10) << 4 & 0xF0;
		return (byte) (i1 | i2);
	}

	/**
	 * byte数组转int类型的对象
	 * 
	 * @param bytes
	 * @return
	 */
	public static int Byte2Int(byte[] bytes) {
		return (bytes[0] & 0xff) << 24 | (bytes[1] & 0xff) << 16
				| (bytes[2] & 0xff) << 8 | (bytes[3] & 0xff);
	}

	public static int Byte2Int(byte h, byte l) {
		return (h & 0xff) << 8 | (l & 0xff);
	}

	/**
	 * 接收到的字节数组转换16进制字符串
	 */
	public static String bytes2HexString(byte[] b, int size) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 判断字节某个位置是否是1
	 * 通过左移比较（从右到左）
	 * @param b
	 * @param index
	 *            （0-7）
	 * @return
	 */
	public static boolean isOneOnIndex(byte b, int index) {
		if (index < 0 || index > 7) {
			return false;
		}
		int i = 1 << index;
		return (i & b) == i;
	}
	
	/**
	 * 通过右移比较（从左到右）
	 * @param bs
	 * @param index 
	 * @return
	 */
	public static boolean isOneOnIndex(byte[] bs, int index) {
		if (index < 0 || index > 31) {
			return false;
		}
		int a = ByteUtil.Byte2Int(bs);
		int i = 0x80000000>>>index;//无符号位移
		printBit(i);
		return (i & a) == i;
	}

	/**
	 * 还原7e标识字段。帧的开始和结束，采用7EH 表示，如果校验码、命令类 型以及用户数据字段中出现7EH，则用7DH 和02H
	 * 表示，如果出现7DH，则用7DH 和01H 表示；
	 * 
	 * @param bs(以7E开头和以7E结尾的数据)
	 * @return 原数据（带7e的）
	 */
	public static byte[] parseFlagData(byte[] bs) {
		if(bs==null||bs.length<2){
			return new byte[]{};
		}
		int length = bs.length;
		int count = 0;
		byte[] temp = new byte[length];
		//从1开始，到length-1，去掉头尾
		for (int i = 1; i < length-1; i++) {
			if (bs[i] == 0x7D) {
				int j = ++i;
				if (bs[j] == 0x01) {
					temp[count++] = 0x7d;
				} else if (bs[j] == 0x02) {
					temp[count++] = 0x7e;
				}
			} else {
				temp[count++] = bs[i];
			}
		}
		// System.out.println(ByteUtil.bytes2HexString(temp, count));
		byte[] data = new byte[count];
		System.arraycopy(temp, 0, data, 0, count);
		return data;
	}

	/**
	 * 屏蔽7e标识字段。帧的开始和结束，采用7EH 表示，如果校验码、命令类 型以及用户数据字段中出现7EH，则用7DH 和02H
	 * 表示，如果出现7DH，则用7DH 和01H 表示；
	 * 
	 * @param bs(以7E开头和以7E结尾的数据)
	 * @return 处理过的数据（7e被转换了，除了头和尾）
	 */
	public static byte[] sendFlagData(byte[] bs) {
		int length=bs.length;
		byte[] temp = new byte[length * 2];
		int count = 0;
		temp[count++]=0x7e;
		for (int i = 1; i < length-1; i++) {
			if (bs[i] == 0x7e) {
				temp[count++] = 0x7D;
				temp[count++] = 0x02;
			} else if (bs[i] == 0x7D) {
				temp[count++] = 0x7D;
				temp[count++] = 0x01;
			} else {
				temp[count++] = bs[i];
			}
		}
		temp[count++] = 0x7e;
		//System.out.println(ByteUtil.bytes2HexString(temp, count));
		byte[] data = new byte[count];
		System.arraycopy(temp, 0, data, 0, count);
		return data;
	}
	
	public static void printBit(int a) {
		for (int i = 0; i < 32; i++) {
			int t = (a & (0x80000000 >>> i)) >>> (31 - i); // >>>表示无符号右移，&表示与运算
			System.out.print(t); // 循环打印输出
		}
		System.out.println();
	}

	/**
	 * 16进制数组转字节
	 * @param hex
	 * @return
	 */
	public static byte[] hexTobytes(String hex) {
		if (hex==null||hex.length() < 1) {
			return null;
		} else {
			hex=hex.replace(" ","");
			byte[] result = new byte[hex.length() / 2];
			int j = 0;
			for(int i = 0; i < hex.length(); i+=2) {
				result[j++] = (byte)Integer.parseInt(hex.substring(i,i+2), 16);
			}
			return result;
		}
	}
}
