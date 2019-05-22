package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TCatelogDAO;
import com.dao.TUserDAO;
import com.model.TCatelog;
import com.model.TUser;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �û����� ������
 * @author Administrator
 *
 */
public class userAction extends ActionSupport
{
	private Integer id;//���
	private String loginname;//��¼����
	private String loginpw;//��¼����
	private String name;//����

	private String sex;//�Ա�
	private String age;//����
	private String address;//��ַ
	private String tel;//�绰

	private String email;//email����
	private String qq;//qq
	private String fujian;//
	
	private String message;//��ʾ��Ϣ
	private String path;//��ת·��
	
	private TUserDAO userDAO;//�û�Dao
	
	//ע��
	public String userReg()
	{
		//�û�����
		TUser user=new TUser();
		//���õ�¼��
		user.setLoginname(loginname);
		//��������
		user.setLoginpw(loginpw);
		//��������
		user.setName(name);
		//�����Ա�
		user.setSex(sex);
		//��������
		user.setAge(age);
		//���õ�ַ
		user.setAddress(address);
		//���õ绰
		user.setTel(tel);
		//����email
		user.setEmail(email);
		//����qq
		user.setQq(qq);
		//��������
		user.setType(1);
		if(fujian.equals(""))//�ж� ͷ���Ƿ�Ϊ��
		{
			//����Ĭ��ֵ
			user.setFujian("/img/user2.gif");
		}
		else
		{
			//����ͼ��ֵ
			user.setFujian(fujian);
		}
		//����del���� Ϊno
		user.setDel("no");
		//����û���Ϣ
		userDAO.save(user);
		//ע��ɹ�
		this.setMessage("ע��ɹ�,���½");
		this.setPath("/qiantai/default.jsp");//��ת·��
	    return "succeed";
	}
	
	//�û��༭
	public String userEdit()
	{
		//ͨ��id ��ѯuser����
		TUser user=userDAO.findById(id);
		
		//��������  ������һ��
		user.setLoginname(loginname);
		user.setLoginpw(loginpw);
		user.setName(name);
		user.setSex(sex);
		
		user.setAge(age);
		user.setAddress(address);
		user.setTel(tel);
		user.setEmail(email);
		
		user.setQq(qq);
		user.setType(1);
		user.setFujian(fujian);
		user.setDel("no");
		
		//�޸�
		userDAO.attachDirty(user);
		
		//��ȡrequest����
		Map request=(Map)ServletActionContext.getContext().get("request");
		//������ʾ��Ϣ
		request.put("msg", "�޸ĳɹ������µ�¼����Ч");
	    return "msg";//����ֵ
	}
	
	//��¼�˳�
	public String userLogout()
	{
		//��ȡrequest����
		HttpServletRequest request=ServletActionContext.getRequest();
		//�����û����� Ϊnull
		request.getSession().setAttribute("userType", null);
		//�����û����� Ϊnull
		request.getSession().setAttribute("user", null);
		//������Ϣ
		this.setMessage("��ȫ�˳�");
		//��ת·��
		this.setPath("/qiantai/default.jsp");
	    return "succeed";//����ֵ
	}
	
	//��ѯ �û���Ϣ
	public String userMana()
	{
		//Hql���  ��ѯ �û���Ϣ
		String sql="from TUser where del='no' and type=1";
		//Hibernate ��ѯ
		List userList=userDAO.getHibernateTemplate().find(sql);
		
		//��ȡrequest����
		Map request=(Map)ServletActionContext.getContext().get("request");
		//��userList���Ϸ���request��
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	//ɾ���û�
	public String userDel()
	{
		//ͨ��id ��ѯuser����
		TUser user=userDAO.findById(id);
		user.setDel("yes");//����delΪyes Ϊɾ��״̬
		userDAO.attachDirty(user);//ɾ������
		
		//���óɹ�
		this.setMessage("�����ɹ�");
		this.setPath("userMana.action");//������ת·��
	    return "succeed";//����ֵ 
	}
	
	
	
	//*********************get and set���� **********************
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getAge()
	{
		return age;
	}
	public void setAge(String age)
	{
		this.age = age;
	}
	public TUserDAO getUserDAO()
	{
		return userDAO;
	}

	public String getFujian()
	{
		return fujian;
	}

	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}

	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getLoginname()
	{
		return loginname;
	}
	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}
	public String getLoginpw()
	{
		return loginpw;
	}
	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public String getQq()
	{
		return qq;
	}
	public void setQq(String qq)
	{
		this.qq = qq;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
	public String getTel()
	{
		return tel;
	}
	public void setTel(String tel)
	{
		this.tel = tel;
	}
}
