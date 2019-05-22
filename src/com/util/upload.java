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
 * 文件上传类
 * @author Administrator
 *
 */
public class upload extends ActionSupport
{
	private static final int BUFFER_SIZE = 16 * 1024;//文件上传大小
	private File fujian;//文件对象
	private String fujianFileName;//文件名称
	private String fujianContentType;//文件类型
	
	
	//文件上传
	public String upload()
	{
		//新的文件名称
		String newFujianName=new Date().getTime()+fujianFileName.substring(fujianFileName.indexOf("."));
		//服务器更目录
		String dstPath = ServletActionContext.getServletContext().getRealPath("upload")+ "\\" + newFujianName;
		//创建 File对象
		File dstFile = new File(dstPath);
		//复制文件到服务器更目录
		copy(this.getFujian(),dstFile);
		//将文件对象和数据 放入 request
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("newFujianName", newFujianName);
		request.put("oldFujianName", fujianFileName);
		request.put("fujianPath", "/upload"+ "/" + newFujianName);
		return ActionSupport.SUCCESS;
	}
	
	//复制文件
	private static void copy(File src, File dst) 
    {
		//创建InputStream outputStream对象
        InputStream in = null;
        OutputStream out = null;
        try 
        {
        	//创建InputStream outputStream对象
            in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst),BUFFER_SIZE);
            //定义缓存区
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = 0;
            while ((len = in.read(buffer)) > 0) //循环读取文件内容
            {
            	//将数据写入文件中
                out.write(buffer, 0, len);
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        } 
        finally
        {
            if (null != in) //inputstream对象不为空
            {
                try 
                {
                	//关闭inputstream
                    in.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
            if (null != out) //outputStream对象不为空
            {
                try 
                {
                    out.close();//关闭
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
