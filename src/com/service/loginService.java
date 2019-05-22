package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.dao.TCatelogDAO;
import com.dao.TUserDAO;
import com.model.TAdmin;
import com.model.TUser;

/**
 * 登录服务类
 * @author Administrator
 *
 */
public class loginService
{
	private TAdminDAO adminDAO;
	private TUserDAO userDAO;
	private TCatelogDAO catelogDAO;
	
	public TAdminDAO getAdminDAO()
	{
		return adminDAO;
	}
	public void setAdminDAO(TAdminDAO adminDAO)
	{
		this.adminDAO = adminDAO;
	}
	public TUserDAO getUserDAO()
	{
		return userDAO;
	}
	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	
	
	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}
	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
	}
	//登录
	public String login(String userName,String userPw,int userType)
	{
		System.out.println("userType"+userType);
		try
		{
			//睡眠 700毫秒
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		//定义结果变量
		String result="no";
		
		if(userType==0)//用户类型 为0
		{
			//查询数据库
			String sql="from TAdmin where userName=? and userPw=?";
			Object[] con={userName.trim(),userPw.trim()};
			List adminList=adminDAO.getHibernateTemplate().find(sql,con);
			
			//数据库是否存在该用户
			if(adminList.size()==0)
			{
				 result="no";//返回结果
			}
			else
			{
				//获取WebContext 上下文对象
				 WebContext ctx = WebContextFactory.get(); 
				 //获取session对象
				 HttpSession session=ctx.getSession(); 
				 //获取管理员对象
				 TAdmin admin=(TAdmin)adminList.get(0);
				 //将对象放入session
				 session.setAttribute("userType", 0);
	             session.setAttribute("admin", admin);
	             result="yes";//返回结果
			}
		}
		if(userType==1)//用户类型 为0
		{//查询数据库
			String sql="from TUser where loginname=? and loginpw=? and type=1 and del='no'";
			Object[] con={userName.trim(),userPw.trim()};
			List userist=userDAO.getHibernateTemplate().find(sql,con);
			//数据库是否存在该用户
			if(userist.size()==0)
			{
				 result="no";//返回结果
			}
			else
			{
				//获取WebContext 上下文对象
				 WebContext ctx = WebContextFactory.get(); 
				//获取session对象
				 HttpSession session=ctx.getSession(); 
				//获取user对象
				 TUser user=(TUser)userist.get(0);
				//将对象放入session
				 session.setAttribute("userType", 1);
	             session.setAttribute("user", user);
	             result="yes";
			}
		}
		if(userType==100)
		{
			
		}
		return result;
	}

	//修改密码
    public String adminPwEdit(String userPwNew)
    {
    	try 
		{
    		//睡眠 700毫秒
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取WebContext 上下文对象
		WebContext ctx = WebContextFactory.get(); 
		//获取session对象
		HttpSession session=ctx.getSession(); 
		 //获取session 中admin对象
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		//设置新密码
		admin.setUserPw(userPwNew);
		//更新
		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);
		
		return "yes";
    }
    
    //查询类型
    public List catelogSelect()
    {
    	//查询类型
    	String sql="from TCatelog where del='no'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		return cateLogList;
    }
}
