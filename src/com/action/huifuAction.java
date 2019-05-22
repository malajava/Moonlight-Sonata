package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TCatelogDAO;
import com.dao.THuifuDAO;
import com.dao.TUserDAO;
import com.dao.TZhutiDAO;
import com.model.TCatelog;
import com.model.THuifu;
import com.model.TZhuti;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �ظ����� ������
 * @author Administrator
 *
 */
public class huifuAction extends ActionSupport
{
	private int id;//�ظ����
	private String title;//����
	private String content;//����
	
	private String shijian;//ʱ��
	private Integer userId;//�û����
	private Integer zhutiId;//������
	
	private String message;//��ʾ��Ϣ
	private String path;//��ת·��
	
	private THuifuDAO huifuDAO;//�ظ�Dao
	private TZhutiDAO zhutiDAO;//����Dao
	private TUserDAO userDAO;//�û�Dao
	
	//��ѯ���лظ���Ϣ
	public String huifuAll()
	{
		//ͨ��������  ��ѯ ������� 
		TZhuti zhuti=zhutiDAO.findById(zhutiId);
		//ͨ������userId��ѯ user���� ��user�����������������
		zhuti.setUser(userDAO.findById(zhuti.getUserId()));
		
		//HQL���  ͨ�������� ��ѯ�ظ���Ϣ
		String sql="from THuifu where zhutiId=?";
		//������
		Object[] c={zhuti.getId()};
		// ͨ�� ������ ��ѯ �ظ���Ϣ
		List huifuList=huifuDAO.getHibernateTemplate().find(sql,c);
		for(int i=0;i<huifuList.size();i++)//ѭ���ظ���Ϣ
		{
			//�ظ�����
			THuifu huifu=(THuifu)huifuList.get(i);
			//ͨ��userid ��ȡuser���� ��user���� ���õ� �ظ�������
			huifu.setUser(userDAO.findById(huifu.getUserId()));
		}
		
		//�� �ظ����� ��ֵ���������� huifuList������  ����ҳ���������
		zhuti.setHuifuList(huifuList);
		
		//����request����
		HttpServletRequest req=ServletActionContext.getRequest();
		//��������� ���� request��
		req.setAttribute("zhuti", zhuti);
		//�� �ظ��б� ���� request��
		req.setAttribute("huifuList", huifuList);
		return ActionSupport.SUCCESS;//����ֵ
	}
	
	//��ӻظ���Ϣ
	public String huifuAdd()
	{
		//�ظ�����
		THuifu huifu=new THuifu();
		//���� ����
		huifu.setTitle(title);
		//��������
		huifu.setContent(content);
		//ʱ��
		huifu.setShijian(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) );
		//�û����
		huifu.setUserId(userId);
		//������
		huifu.setZhutiId(zhutiId);
		//��ӻظ�
		huifuDAO.save(huifu);
		//���� ��ʾ��Ϣ
		this.setMessage("�ظ��ɹ�");
		//������ת·��
		this.setPath("/qiantai/default.jsp");
	    return "succeed";//����ֵ
		
	}
	
	//ͨ�������� ��ѯ�ظ���Ϣ
	public String huifuMana()
	{
		//ͨ��������  ��ȡ �������
		TZhuti zhuti=zhutiDAO.findById(zhutiId);
		//ͨ��������userid��ȡ user���� 
		zhuti.setUser(userDAO.findById(zhuti.getUserId()));
		//ͨ�������� ��ȡ�ظ� ����
		String sql="from THuifu where zhutiId=?";
		Object[] c={zhuti.getId()};//���
		//ͨ�������� ��ѯ�ظ���Ϣ�б�
		List huifuList=huifuDAO.getHibernateTemplate().find(sql,c);
		for(int i=0;i<huifuList.size();i++)//ѭ��
		{
			//�ظ�����
			THuifu huifu=(THuifu)huifuList.get(i);
			//���ûظ�user����
			huifu.setUser(userDAO.findById(huifu.getUserId()));
		}
		//������ ���� �ظ������б�
		zhuti.setHuifuList(huifuList);
		
		//��ȡ request
		HttpServletRequest req=ServletActionContext.getRequest();
		//��������� ����request����
		req.setAttribute("zhuti", zhuti);
		//���ظ��б� ����request����
		req.setAttribute("huifuList", huifuList);
		return ActionSupport.SUCCESS;//����ֵ
	}
	
	//ɾ���ظ�
	public String huifuDel()
	{
		
		//ͨ��id��ȡ �ظ�����
		THuifu huifu=huifuDAO.findById(id);
		huifuDAO.delete(huifu);//ɾ���ظ�����
		//��ȡrequest
		HttpServletRequest req=ServletActionContext.getRequest();
		//������Ϣ Ϊ�ɹ�
		req.setAttribute("msg", "�ɹ�ɾ��");
		return "msg";//����ֵ
	}
	//*********************get and set���� **********************
	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public THuifuDAO getHuifuDAO()
	{
		return huifuDAO;
	}

	public void setHuifuDAO(THuifuDAO huifuDAO)
	{
		this.huifuDAO = huifuDAO;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public TZhutiDAO getZhutiDAO()
	{
		return zhutiDAO;
	}

	public void setZhutiDAO(TZhutiDAO zhutiDAO)
	{
		this.zhutiDAO = zhutiDAO;
	}

	public TUserDAO getUserDAO()
	{
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getShijian()
	{
		return shijian;
	}

	public void setShijian(String shijian)
	{
		this.shijian = shijian;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Integer getUserId()
	{
		return userId;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public Integer getZhutiId()
	{
		return zhutiId;
	}

	public void setZhutiId(Integer zhutiId)
	{
		this.zhutiId = zhutiId;
	}
	
}
