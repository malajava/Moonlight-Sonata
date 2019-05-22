package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * �ļ��ϴ���
 * @author Administrator
 *
 */
public class upload extends ActionSupport
{
	private static final int BUFFER_SIZE = 16 * 1024;//�ļ��ϴ���С
	private File fujian;//�ļ�����
	private String fujianFileName;//�ļ�����
	private String fujianContentType;//�ļ�����
	
	
	//�ļ��ϴ�
	public String upload()
	{
		//�µ��ļ�����
		String newFujianName=new Date().getTime()+fujianFileName.substring(fujianFileName.indexOf("."));
		//��������Ŀ¼
		String dstPath = ServletActionContext.getServletContext().getRealPath("upload")+ "\\" + newFujianName;
		//���� File����
		File dstFile = new File(dstPath);
		//�����ļ�����������Ŀ¼
		copy(this.getFujian(),dstFile);
		//���ļ���������� ���� request
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("newFujianName", newFujianName);
		request.put("oldFujianName", fujianFileName);
		request.put("fujianPath", "/upload"+ "/" + newFujianName);
		return ActionSupport.SUCCESS;
	}
	
	//�����ļ�
	private static void copy(File src, File dst) 
    {
		//����InputStream outputStream����
        InputStream in = null;
        OutputStream out = null;
        try 
        {
        	//����InputStream outputStream����
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst),BUFFER_SIZE);
            //���建����
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) //ѭ����ȡ�ļ�����
            {
            	//������д���ļ���
                out.write(buffer, 0, len);
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        } 
        finally
        {
            if (null != in) //inputstream����Ϊ��
            {
                try 
                {
                	//�ر�inputstream
                    in.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
            if (null != out) //outputStream����Ϊ��
            {
                try 
                {
                    out.close();//�ر�
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }


	public File getFujian()
	{
		return fujian;
	}


	public void setFujian(File fujian)
	{
		this.fujian = fujian;
	}


	public String getFujianContentType()
	{
		return fujianContentType;
	}


	public void setFujianContentType(String fujianContentType)
	{
		this.fujianContentType = fujianContentType;
	}


	public String getFujianFileName()
	{
		return fujianFileName;
	}


	public void setFujianFileName(String fujianFileName)
	{
		this.fujianFileName = fujianFileName;
	}

}
