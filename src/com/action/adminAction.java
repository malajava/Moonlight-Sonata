package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.model.TAdmin;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ����Ա���� ��������
 * @author Administrator
 *
 */
public class adminAction extends ActionSupport
{
	private int userId;//�����û����
	private String userName;//�û���
	private String userPw;//����
	 
	private String message;//��Ϣ
	private String path;//��ת·��
	
	private int index=1;

	private TAdminDAO adminDAO;//����Ա���ݿ������
	
	
	//��ӹ���Ա
	public String adminAdd()
	{
		TAdmin admin=new TAdmin(); //ʵ����admin
		admin.setUserName(userName);//��username���и�ֵ
		admin.setUserPw(userPw);
		adminDAO.save(admin);//����dao�ķ������浽�����ݿ�
		this.setMessage("�����ɹ�");//������Ϣ�����ɹ�,����action�е�message����Ϊ"��ӳɹ�"
		this.setPath("adminManage.action");//������ת·��
		return "succeed";//����ֵ
	}
	
	
	//��ʾ����Ա�б�
	public String adminManage()
	{
		List adminList=adminDAO.findAll();//������е�adminlist
		//��ȡ���ö��� request
		Map request=(Map)ServletActionContext.getContext().get("request");
		//��adminList����Ա�б����� ����request������
		request.put("adminList", adminList);
		return ActionSupport.SUCCESS;//����ֵ
	}
	
	//����Աɾ��
	public String adminDel()
	{
		//����Աɾ��
		adminDAO.delete(adminDAO.findById(userId));
		this.setMessage("ɾ���ɹ�");//������ϢΪ �ɹ�
		this.setPath("adminManage.action");//������ת·��
		return "succeed";//����ֵ
	}
	
	
//*********************get and set���� **********************
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
