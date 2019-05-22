package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.model.TAdmin;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 管理员处理 控制器类
 * @author Administrator
 *
 */
public class adminAction extends ActionSupport
{
	private int userId;//定义用户编号
	private String userName;//用户名
	private String userPw;//密码
	 
	private String message;//消息
	private String path;//跳转路径
	
	private int index=1;

	private TAdminDAO adminDAO;//管理员数据库访问类
	
	
	//添加管理员
	public String adminAdd()
	{
		TAdmin admin=new TAdmin(); //实例化admin
		admin.setUserName(userName);//对username进行赋值
		admin.setUserPw(userPw);
		adminDAO.save(admin);//调用dao的方法保存到到数据库
		this.setMessage("操作成功");//返回信息操作成功,将该action中的message设置为"添加成功"
		this.setPath("adminManage.action");//设置跳转路径
		return "succeed";//返回值
	}
	
	
	//显示管理员列表
	public String adminManage()
	{
		List adminList=adminDAO.findAll();//查出所有的adminlist
		//获取内置对象 request
		Map request=(Map)ServletActionContext.getContext().get("request");
		//将adminList管理员列表数据 放入request对象中
		request.put("adminList", adminList);
		return ActionSupport.SUCCESS;//返回值
	}
	
	//管理员删除
	public String adminDel()
	{
		//管理员删除
		adminDAO.delete(adminDAO.findById(userId));
		this.setMessage("删除成功");//设置消息为 成功
		this.setPath("adminManage.action");//设置跳转路径
		return "succeed";//返回值
	}
	
	
//*********************get and set方法 **********************
	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}

	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}

	public String getMessage()
	{
		return message;
	}

	public int getIndex()
	{
		return index;
	}



	public void setIndex(int index)
	{
		this.index = index;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserPw()
	{
		return userPw;
	}

	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}
	 
}
