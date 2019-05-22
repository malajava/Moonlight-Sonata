package com.util;

import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ������
 * @author Administrator
 *
 */
public class Util {
	/**
	 * ͨ���ַ��� ����ʱ����Ϣ
	 * @param s
	 * @return
	 * @throws ParseException
	 */
	public static Date newDate(String s) throws ParseException {
		//����SimpleDateFormat����
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		//����Date����
		Date date = new Date();
		date = sdf.parse(s);//����string ���date����
		return date;
	}

	/**
	 * ͨ���ַ��������µ�ʱ��
	 * @param s
	 * @return
	 * @throws ParseException
	 */
	public static Date newDate1(String s) throws ParseException {
		//����SimpleDateFormat����
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		//����Date����
		Date date = new Date();
		date = sdf.parse(s);//����string ���date����
		return date;
	}

	/**
	 * ��ȡ����ȫ����Ϣ
	 * @param s
	 * @return
	 * @throws ParseException
	 */
	public static Date FormatFullDate(String s) throws ParseException {
		//����SimpleDateFormat����
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		//����Date����
		Date date = new Date();
		date = sdf.parse(s);//����string ���date����
		return date;

	}

	/**
	 * ��ʽ��������Ϣ �õ��ַ���
	 * @param d
	 * @return
	 */
	public static String splitDate(Date d) {
		//��ʽ��������Ϣ �õ��ַ���
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		return sdf.format(d);
	}

	/**
	 * ��ʽ��������Ϣ �õ��ַ���
	 * @param d
	 * @return
	 */
	public static String splitDate1(Date d) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
				"yyyy��MM��dd��");
		return sdf.format(d);
	}

	/**
	 * ���ַ����ض̣�ȡǰn���ַ���Ӣ�������ַ���
	 * 
	 * @param orignalString
	 *            ԭ�ַ���
	 * @param length
	 *            ����
	 * @param chopedString
	 *            �������ֵı�ʾ�ַ���
	 * @return ��ȡ���ַ���
	 */
	public static String chop(String orignalString, double length,
			String chopedString) {
		if (orignalString == null || orignalString.length() == 0) {//�ж��ַ����Ƿ�Ϊ��
			return orignalString;
		}
		//�滻Ϊ�յ��ַ�
		orignalString = orignalString.replaceAll(" ", " ");
		if (orignalString.length() < length) {
			return orignalString;
		}
		//����StringBuffer����
		StringBuffer buffer = new StringBuffer((int) length);
		length = length * 2;
		int count = 0;
		int stringLength = orignalString.length();
		int i = 0;
		//���ַ����ض̣�ȡǰn���ַ���Ӣ�������ַ���
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
