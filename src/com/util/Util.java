package com.util;

import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 工具类
 * @author Administrator
 *
 */
public class Util {
	/**
	 * 通过字符串 创建时间信息
	 * @param s
	 * @return
	 * @throws ParseException
	 */
	public static Date newDate(String s) throws ParseException {
		//创建SimpleDateFormat对象
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		//创建Date对象
		Date date = new Date();
		date = sdf.parse(s);//解析string 变成date对象
		return date;
	}

	/**
	 * 通过字符串创建新的时间
	 * @param s
	 * @return
	 * @throws ParseException
	 */
	public static Date newDate1(String s) throws ParseException {
		//创建SimpleDateFormat对象
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		//创建Date对象
		Date date = new Date();
		date = sdf.parse(s);//解析string 变成date对象
		return date;
	}

	/**
	 * 获取日期全部信息
	 * @param s
	 * @return
	 * @throws ParseException
	 */
	public static Date FormatFullDate(String s) throws ParseException {
		//创建SimpleDateFormat对象
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		//创建Date对象
		Date date = new Date();
		date = sdf.parse(s);//解析string 变成date对象
		return date;

	}

	/**
	 * 格式化日期信息 得到字符串
	 * @param d
	 * @return
	 */
	public static String splitDate(Date d) {
		//格式化日期信息 得到字符串
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		return sdf.format(d);
	}

	/**
	 * 格式化日期信息 得到字符串
	 * @param d
	 * @return
	 */
	public static String splitDate1(Date d) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy年MM月dd日");
		return sdf.format(d);
	}

	/**
	 * 将字符串截短，取前n个字符，英文算半个字符。
	 * 
	 * @param orignalString
	 *            原字符串
	 * @param length
	 *            长度
	 * @param chopedString
	 *            超过部分的表示字符串
	 * @return 截取的字符串
	 */
	public static String chop(String orignalString, double length,
			String chopedString) {
		if (orignalString == null || orignalString.length() == 0) {//判断字符串是否为空
			return orignalString;
		}
		//替换为空的字符
		orignalString = orignalString.replaceAll(" ", " ");
		if (orignalString.length() < length) {
			return orignalString;
		}
		//创建StringBuffer对象
		StringBuffer buffer = new StringBuffer((int) length);
		length = length * 2;
		int count = 0;
		int stringLength = orignalString.length();
		int i = 0;
		//将字符串截短，取前n个字符，英文算半个字符。
		for (; count < length && i < stringLength; i++) {
			char c = orignalString.charAt(i);
			if (c < '\u00ff') {
				count++;
			} else {
				count += 2;
			}
			buffer.append(c);
		}
		if (i < stringLength) {
			buffer.append(chopedString);
		}
		return buffer.toString();
	}

	public static long getPrimeKey() {
		GregorianCalendar calendar = new GregorianCalendar();
		return calendar.getTimeInMillis();
	}

	public static long stringToLong(String source) {
		return Long.parseLong(source);
	}
	/*
	 * public static void main(String[] args){ for(int i=0;i<10;i++){
	 * System.out.println(Util.getPrimeKey()); } }
	 */
}
