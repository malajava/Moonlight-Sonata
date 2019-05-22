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
 * ��¼������
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
	//��¼
	public String login(String userName,String userPw,int userType)
	{
		System.out.println("userType"+userType);
		try
		{
			//˯�� 700����
			Thread.sleep(700);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		//����������
		String result="no";
		
		if(userType==0)//�û����� Ϊ0
		{
			//��ѯ���ݿ�
			String sql="from TAdmin where userName=? and userPw=?";
			Object[] con={userName.trim(),userPw.trim()};
			List adminList=adminDAO.getHibernateTemplate().find(sql,con);
			
			//���ݿ��Ƿ���ڸ��û�
			if(adminList.size()==0)
			{
				 result="no";//���ؽ��
			}
			else
			{
				//��ȡWebContext �����Ķ���
				 WebContext ctx = WebContextFactory.get(); 
				 //��ȡsession����
				 HttpSession session=ctx.getSession(); 
				 //��ȡ����Ա����
				 TAdmin admin=(TAdmin)adminList.get(0);
				 //���������session
				 session.setAttribute("userType", 0);
	             session.setAttribute("admin", admin);
	             result="yes";//���ؽ��
			}
		}
		if(userType==1)//�û����� Ϊ0
		{//��ѯ���ݿ�
			String sql="from TUser where loginname=? and loginpw=? and type=1 and del='no'";
			Object[] con={userName.trim(),userPw.trim()};
			List userist=userDAO.getHibernateTemplate().find(sql,con);
			//���ݿ��Ƿ���ڸ��û�
			if(userist.size()==0)
			{
				 result="no";//���ؽ��
			}
			else
			{
				//��ȡWebContext �����Ķ���
				 WebContext ctx = WebContextFactory.get(); 
				//��ȡsession����
				 HttpSession session=ctx.getSession(); 
				//��ȡuser����
				 TUser user=(TUser)userist.get(0);
				//���������session
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

	//�޸�����
    public String adminPwEdit(String userPwNew)
    {
    	try 
		{
    		//˯�� 700����
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ȡWebContext �����Ķ���
		WebContext ctx = WebContextFactory.get(); 
		//��ȡsession����
		HttpSession session=ctx.getSession(); 
		 //��ȡsession ��admin����
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		//����������
		admin.setUserPw(userPwNew);
		//����
		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);
		
		return "yes";
    }
    
    //��ѯ����
    public List catelogSelect()
    {
    	//��ѯ����
    	String sql="from TCatelog where del='no'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		return cateLogList;
    }
}
