package com.wd.java.algorithm.subject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * create by Hewc at 2018-12-10 上午9:42:05 
 * The description is as follows
 * 代码优化的实例
 * 写代码的小技巧
 * 	优化的内容如果以损失可读性为代码的优化,请仔细斟酌
 * 对应我们的培训文档
 * 
 * 1.良好的风格
 * 2.尽量指定类、方法的 final 修饰符
 */
public final class Optimization {
	// longd定义后面接大写的L 不使用小写的l,因为l跟1太像了
	public long value = 1024L;
	public long valueTest = 1024l;
	
	Optimization o = new Optimization();
	
	/**
	 * 2.尽量指定类、方法的 final 修饰符
	 */
	private final void c2() {
		// do some thing
	}
	
	/**
	 * 3.尽可能使用局部变量
	 */
	private void C3() {
		//尽量使用局部变量  C3运行完成后o1会被回收  特别太注意是尽量
		Optimization o1 = new Optimization();
		
	}
	
	/**
	 * 4.及时关闭流
	 * 举例说明文件流
	 */
	private void C4() {
		InputStream inputStream = null;
		
		try {
			inputStream = new FileInputStream(new File("test"));
			//.......
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {// 一定要关闭
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 5.for循环遍历小技巧
	 */
	private void c5(List<String> list) {
		//性能不好，list.size() 会重复调用
		for (int i = 0; i < list.size(); i++) {
		   // ...
		}
		
		//建议替换为如下
		for (int i = 0, length = list.size(); i < length; i++) {
		//    ...
		}
		//如上写法在 list.size() 很大的时候，就减少了很多的消耗。
	}
	
	/**
	 * 6.尽量采用懒加载的策略，即在需要的时候才创建
	 * 这个原则其实就是节约，具体样例如下。
	 */
	private void c6(int i, List<String> list) {
		//不好的示范
		String str = "aaa";
		if (i == 1) {
			list.add(str);
		}

		//建议替换为如下
		if (i == 1) {
			String str1 = "aaa";
			list.add(str1);
		}
	}
	
	/**
	 * 9.如果能估计到待添加的内容长度，为底层以数组方式实现的集合、工具类指定初始长度
	 */
	private void c9() {
		// 知道大概会有50个对象，那么创建是指定有50的长度 或者稍微大于50的数
		List<String> name = new ArrayList<String>(50);
		for (int i = 0; i < 50; i++) {
			name.add(String.valueOf(i));
		}
		
		// 指定初始化长度
		StringBuilder sb = new StringBuilder(100);
	}
	
	/**
	 * 10.当复制大量数据时，使用 System.arraycopy() 命令
	 */
	private void c10(int[] src ) {
		// 使用arraycopy
		int[] dest = new int[10];
		System.arraycopy(src, 0, dest, 0, dest.length);
		
		// 而不是使用下面的方法来复制
		for (int i = 0, length = dest.length;i < length ;i++) {
			dest[i] = src[i];
		}
	}
	
	/**
	 * c11 乘法和除法使用移位操作
	 * 特别注意这个是合适正整数，负数并不适用。
	 * @param a
	 * @param b
	 */
	private void c11(int a, int b) {
		//不好的示范
		for (int val = 0; val < 100000; val += 5) {
			a = val * 8;
			b = val / 2;
		}

		//建议修改实现
		for (int val = 0; val < 100000; val += 5) {
			a = val << 3;
			b = val >> 1;
		}
	}
	
	/**
	 * 12.循环内不要不断创建对象引用
	 */
	private void c12() {
		int count = 50000;
		//不好的示范
		for (int i = 1; i <= count; i++) {
		    Object obj = new Object();    
		}
		
		//count 很大的话，就耗费内存了，建议为如下实现。
		Object obj = null;
		for (int i = 0; i <= count; i++) {
		    obj = new Object();
		}
	}
	
	/**
	 * 13.基于效率和类型检查的考虑，应该尽可能使用 array，无法确定数组大小时才使用 ArrayList。
	 */
	private void c13(int count) {
		// 已创建有且只有count个值的对象为例，而且不需要添加跟删除的情况下
		int[] a = new int[count];
		for (int i = 0; i < count; i++) {
			a[i] = count;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < count; i++) {
			list.add(i);
		}
		
		// 很明显list的add操作所执行的代码比a[i] = count要执行的代码多得多
		// 而且list所消耗的空间肯定是>=count的  有兴趣可以参考ArrayList的源码
	}
	
	// 15.不要将数组声明为 public static final, List也应该避免
	public static final int[] TEST_ARRAY = {1, 2, 3, 4}; 
	public static final List<String> TEST_LIST = new ArrayList<String>(); 
	private void c15() {
		// 还是可以任意修改
		TEST_ARRAY[0] = 10;
		TEST_ARRAY[2] = 100;
		
		TEST_LIST.add("a");
		TEST_LIST.add("b");
	}
	
	List<String> c18List = new ArrayList<String>();
	/**
	 * 18.使用同步代码块替代同步方法
	 */
	private synchronized void c18() {
		//.... dosomeThing
		
		for (String s : c18List) {
			System.out.println(s);
		}
		
		c18List.add("15");
		//.... dosomeThing
		
		// 此写法c18函数的所有的代码都在同步的代码块中， 而实际上可能只要对list的操作加锁就可以了
		// 而且如果要增加c18函数的代码时，新加入的代码都是在同步代码块中的 建议修改成c18Good的形式
	}
	
	private Object mC18Mutex = new Object();
	private void c18Good() {
		//.... dosomeThing
		synchronized (mC18Mutex) { // 只对list加锁
			for (String s : c18List) {
				System.out.println(s);
			}
			
			c18List.add("15");
		}
		//.... dosomeThing
	}
	
	/**
	 * 25.字符串变量和字符串常量 equals 的时候将字符串常量写在前面，这样可以避免空指针
	 */
	private void c25(String name) {
		//不好的写法, 可能会造成空指针
		if (name.equals("hewc")) {
			System.out.println("这是一个大好人呀");
		}
		
		// 应该修改为 可以有效的防止空指针
		if ("hewc".equals(name)) {
			System.out.println("这是一个大大好人呀");
		}
	}
	
	/**
	 * 30.把一个基本数据类型转为字符串，基本数据类型.toString() 
	 * 是最快的方式、String.valueOf(数据) 次之、数据+”” 最慢
	 */
	private void c30() {
		int i = 10;
		
		// 最快的
		String temp = ((Integer)i).toString();
		temp = Integer.toString(i);
		
		// 速度还看的过去
		temp = String.valueOf(i);
		
		// 慢如蜗牛
		temp = "" + i;
	}
	
	/**
	 * 使用最有效率的方式去遍历 Map
	 * @param map
	 */
	private void c31(Map<String, String> map) {
		// 推荐的写法
		Set<Entry<String, String>> entrySet = map.entrySet();
		for (Entry<String, String> e : entrySet) {
			System.out.println("key = " + e.getKey() + " value = " + e.getValue());
		}
		
		//其他写法
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println("key = " + key + " value = " + map.get(key));
		}
		
		// 具体使用哪一种还是结合实际项目进行斟酌
	}
	
	/**
	 * 32.对资源的 close() 建议分开操作
	 */
	private void c32() {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = new FileInputStream(new File("test"));
			outputStream = new FileOutputStream(new File("test1"));
			//.......
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 不好的写法
			try {
				inputStream.close();
				outputStream.close();
			} catch (Exception e) {// 如果inputStreamc关闭出现异常  那么会影响outputStream的关闭
				e.printStackTrace();
			}
			
			// 应该修改为下面的
			try {
				inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				outputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
	
	/**
	 * 37.循环体内不要使用 “+” 进行字符串拼接，而直接使用 StringBuilder 不断 append
	 */
	private void c37() {
		String temp = "";
		String BLANK = " ";
		
		// 不好的写好甚至是极不好的写法
		for (int i = 0; i < 100; i++) {
			temp += i + BLANK;
		}
		
		StringBuilder sb = new StringBuilder();
		// 应该修改为
		for (int i = 0; i < 100; i++) {
			sb.append(i);
			sb.append(BLANK);
		}
		sb.toString();
	}
	
	/**
	 * 39.使用位运算来判断是否是奇数
	 * @param i
	 */
	private void c39(int i) {
		if ((i & 1) == 1) { // 奇数
		} else {//偶数
		}
	}
	
	/**
	 * 40.只处理if条件return 默认值
	 * @param number
	 * @return
	 */
	private int c40(int number) {
		// 一般的写法 优化的写法见c40Good
		if (number == 1) {
			return 10;
		} else if (number == 2) {
			return 24;
		} else {
			return -1;
		}
	}
	
	/**
	 * 40.只处理if条件return 默认值
	 * @param number
	 * @return
	 */
	private int c40Good(int number) {
		if (number == 1) {
			return 10;
		} else if (number == 2) {
			return 24;
		}
		
		return -1;
	}
	
	//善用3目运算符
	//代码会变的简洁, 但是不建议条件进行判断
	//计算ab中最大的一个
	public int max(int a, int b) {
		// 一般写法
//		if (a > b) {
//			return a;
//		} else {
//			return b;
//		}
//		
	// 如果要比较 a b c 3个数的比较的话,虽然可以实现,但是不建议使用3目运算,主要是可读性大大的降低了
	//	int c = 10;
	//	return a > b ? (a > c ? a : c) : (b > c ? b : c);
		
		// 正确的优化写法
		return a > b  ? a : b;
	}
	
	//善用3目运算符
	// 实例2 设置UI的可见性
	public void showUI(boolean show) {/*
		// 一般的写法
		if (show) {
			view.setVisibility(View.VISIBLE);
		} else {
			view.setVisibility(View.GONE);
		}
			
		// 优化的写法
		 view.setVisibility(show ? View.VISIBLE : View.GONE);
	*/}
	
		// 判断某一个集合中是否存在某一个元素， 使用map,set集合会比list集合中快很多，特别是集合很大的时候
		// 在遇到判断某一个集合中是否存在某一个元素的需求时，建议使用set或者map来代替list，优先考虑set
		// 实例判断集合中是否存在张三500000
		public void c42() {
			Set<String> set = new HashSet<String>();
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < 1000000; i++) {
				set.add("张三" + i);
				list.add("张三" + i);
			}
			
			long time = System.currentTimeMillis();
			if (set.contains("张三500000")) {
				print("1 find take time " + (System.currentTimeMillis() - time));
			} else {
				print("1 not find take time " + (System.currentTimeMillis() - time));
			}
			
			time = System.currentTimeMillis();
			if (list.contains("张三500000")) {
				print("2 find take time " + (System.currentTimeMillis() - time));
			} else {
				print("2 not find take time " + (System.currentTimeMillis() - time));
			}
			
			time = System.currentTimeMillis();
			if (set.contains("张三1586445000")) {
				print("3 find take time " + (System.currentTimeMillis() - time));
			} else {
				print("3 not find take time " + (System.currentTimeMillis() - time));
			}
			
			time = System.currentTimeMillis();
			if (list.contains("张三1586445000")) {
				print("4 find take time " + (System.currentTimeMillis() - time));
			} else {
				print("4 not find take time " + (System.currentTimeMillis() - time));
			}
		}
		
		// 善于使用flag来代替boolean,使用标志位来进行二进制运算
		// 适用于很多状态的保存,例如需要知道当前是否是运行状态, 是否是开关状态,是否是使能状态,是否电池还有点的状态
		// 当存在很多状态的时候,可能每个状态都需要使用一个boolean来存储此状态,如果使用flag的话,一个变量可以表示很多很多状态
		// 下面给了几个常用的2进制运算,可以根据下面的运算进行扩展
		private static final int FLAG_RUNNING = 0x01;
		private static final int FLAG_OPEN = 0x01 << 1;
		private static final int FLAG_ENABLE = 0x01 << 2;
		private static final int FLAG_HAS_BATTERY = 0x01 << 3;
		private static final int FLAG_XXXXX = 0x01 << 4;
		
		public void testFlag() {
			int flag = 0; // 没有的状态都是false
			
			// 把运行状态置为true
			flag = enableFlag(flag, FLAG_RUNNING);
			print("flag = " + flag + " is Runing " + hasFlag(flag, FLAG_RUNNING));
		
			flag = enableFlag(flag, FLAG_ENABLE);
			flag = enableFlag(flag, FLAG_HAS_BATTERY);
			flag = enableFlag(flag, FLAG_XXXXX);
			flag = clearFlag(flag, FLAG_RUNNING);
			print("flag = " + flag + " is Runing " + hasFlag(flag, FLAG_RUNNING)
					+ " isOpen = " + hasFlag(flag, FLAG_OPEN) + " isEnable = " + hasFlag(flag, FLAG_ENABLE)
					+ " is has battery " + hasFlag(flag, FLAG_HAS_BATTERY) + " is xxxx " + hasFlag(flag, FLAG_XXXXX));
			
			// 把所有的状态都置为1就更加简单了
			flag = ~0;
			print("!!! flag = " + flag + " is Runing " + hasFlag(flag, FLAG_RUNNING)
					+ " isOpen = " + hasFlag(flag, FLAG_OPEN) + " isEnable = " + hasFlag(flag, FLAG_ENABLE)
					+ " is has battery " + hasFlag(flag, FLAG_HAS_BATTERY) + " is xxxx " + hasFlag(flag, FLAG_XXXXX));
		}
		
		/**
		 * 在flagBase中是否存在某个标识
		 * @param flagBase
		 * @param flag
		 * @return
		 */
		private boolean hasFlag(int flagBase, int flag) {
			return (flagBase & flag) > 0; // 也可以写成 !=0
		}
		
		/**
		 * 把某一位置为1
		 * @param flagBase
		 * @param flag
		 * @return
		 */
		private int enableFlag(int flagBase, int flag) {
			flagBase |= flag;
			return flagBase;
		}
		
		/**
		 * 把某一位置为0
		 * @param flagBase
		 * @param flag
		 * @return
		 */
		private int clearFlag(int flagBase, int flag) {
			flagBase &= ~flag;
			return flagBase;
		}
		
	
	//返回boolean的值函数 可以写成return判断语句 
	//代替if else
	//判断一个数是否是奇数
	public boolean isOddNumber(int number) {
		// 一般的写法
//		if (number % 2 == 1) {
//			return true;
//		} else {
//			return false;
//		}
		
		// 最简单写法
		//return number % 2 == 1;
		
		// 最NB的写法
		return (number & 1) == 1;
	}
	
	// 从一个列表中移除另外一个列表中存在的元素  使用迭代器可以大大的有优化代码
	// 如果不使用迭代器的话,代码会非常复杂, 起码每次使用都要仔细想了又想
	// 从一个列表中移除另外一个列表中存在的元素的实例
	public void listRemove() {
		List<String> list0 = new ArrayList<String>();
		list0.add("A");
		list0.add("B");
		list0.add("C");
		list0.add("D");
		list0.add("E");
		list0.add("F");
		
		List<String> list1 = new ArrayList<String>();
		list1.add("B");
		list1.add("D");
		list1.add("F");
		list1.add("G");
		
		Iterator<String> it = list0.iterator();
		while (it.hasNext()) {
			String value = it.next();
			if (list1.contains(value)) { // 还可以加根据复杂的判断
				it.remove();
			}
		}
		
		for (String s : list0) {
			print("list 0 ===> " + s);
		}
	}
	
	/**
	 * 45.善用boolean表达式跟boolean值
	 */
	private void c45(int i) {
		boolean temp;
		// 一般写法
		if (i == 0) {
			temp = true;
		} else {
			temp = false;
		}
		
		// 可以修改为
		temp = i == 0;
	}
	
	private boolean c46(int i) {
		// 一般写法
//		if (i == 0) {
//			return true;
//		} else {
//			return false;
//		}
		
		// 优化写法
		return i == 0;
	}
	
	/**
	 * 是否是完全平方数
	 * @param num
	 * @return  num是否是完全平方数
	 */
	public boolean isPerfectSquare(int num) {
		return Math.sqrt(num) == (int) Math.sqrt(num);
	}
	
	/**
	 * 反转一个数字
	 * @param num 要进行反转的数字
	 * @return
	 */
	public static int reversal(int num) {
		print("before reversal num = " + num);
		int result = 0;
		while (num != 0) {
			result = num % 10 + result * 10;
			num /= 10;
		}
		
		print("after reversal result = " + result);
		return result;
	}
	
	/**
	 * 反转字符串
	 * @param str
	 * @return
	 */
	public static String reversal(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		
		print("before reversal str = " + str);
		
		char[] val = str.toCharArray();
		int length = val.length;
		char temp;
		for (int i = 0; i < length/2; i++) {
			temp = val[i];
			val[i] = val[length - i - 1];
			val[length - i - 1] = temp;
		}
		
		
		print("before reversal str = " + new String(val));
		return new String(val);
	}
	
	
	
	/**
	 * 把startBit位的连续的len位都置为1
	 * @param len
	 */
	public int fooEnable(int len, int startBit) {
		int value = 0x34;
		
		int v0 = ((0x01 << len) - 1) << startBit; // 记得一定要把0x01 << len使用括号, 因为减号的优先级高于左移
		value |= v0;
		
		print("value = " + value);
		
		return value;
	}
	
	/**
	 * 把startBit位的连续的len位都置为0
	 * @param len
	 */
	public int fooClear(int len, int startBit) {
		int value = 0x34;
		
		int v0 = ~(((0x01 << len) - 1) << startBit); // 记得一定要把0x01 << len使用括号, 因为减号的优先级高于左移
		value &= v0;
		
		print("value = " + value);
		
		return value;
	}
	
	/**
	 * 字符串压缩
	 * aaaabbbbccccde ====>a4b4c3de
	 * @param str
	 */
	public void foo6(String str) {
		if (str != null && str.length() > 0) {
			StringBuilder sb = new StringBuilder();
			char[] value = str.toCharArray();
			
			int length = value.length;
			boolean isStart = false;
			char lastChar = value[0];
			int matchNum = 1;
			for (int i = 1; i < length; i++) {
				if (isStart) { // 找到了2个相同的
					if (lastChar == value[i]) {
						matchNum += 1;
						continue;
					} else {
						isStart = false;
						sb.append(lastChar);
						sb.append(matchNum);
						matchNum = 1;
					}
				} else {
					if (lastChar == value[i]) {
						isStart = true;
						matchNum += 1;
						continue;
					} else {
						sb.append(lastChar);
					}
				}
				
				lastChar = value[i];
			}
			
			if (isStart) {
				sb.append(lastChar);
				sb.append(matchNum);
			} else {
				sb.append(lastChar);
			}
			print("str " + str + " ====> " + sb.toString());
		}
	}
	
	private static void print(Object o) {
		System.out.println(o + "\n");
	}
	
	/**
	 * 字符串压缩 自己写的
	 * aaaabbbbccccde ====>a4b4c3de
	 * @param str
	 */
	public static void foo66(String str) {
		if (str != null && str.length() > 0) {
			char[] value = str.toCharArray();
			char last=value[0];
			int count=1;
			StringBuilder builder=new StringBuilder();
			builder.append(last);
			for (int i = 1; i < value.length; i++) {
				char temp=value[i];
				if(temp==last){
					count++;
				}else{
					if(count==1){
						builder.append(temp);
					}else{
						builder.append(count);
						builder.append(temp);
						count=1;
					}	
				}
				last=temp;
			}
			System.out.println("ss="+builder.toString());
		}
		
	}
}
