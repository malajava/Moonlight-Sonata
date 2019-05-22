package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TCatelogDAO;
import com.model.TCatelog;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ʹ��� ��������
 * @author Administrator
 *
 */
public class catelogAction extends ActionSupport
{
	private int id;//�������
	private String name;//����
	
	private String message;//��ʾ��Ϣ
	private String path;//��ת·��
	
	private TCatelogDAO catelogDAO;//����Dao
	
	//�������
	public String catelogAdd()
	{
		//����TCatelog���Ͷ���
		TCatelog catelog=new TCatelog();
		catelog.setName(name);//��������
		catelog.setDel("no");//���� no��ʶ��
		catelogDAO.save(catelog); //�������
		this.setMessage("�����ɹ�");//���óɹ����
		this.setPath("catelogMana.action");//������ת·��
		return "succeed";//����ֵ
	}
	
	//��ѯdel�ֶ� Ϊno����������
	public String catelogMana()
	{
		//Hql��� ��ѯdel�ֶ� Ϊno����������
		String sql="from TCatelog where del='no'";
		//hibernate �����ѯ
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		//��ȡrequest����
		Map request=(Map)ServletActionContext.getContext().get("request");
		//���������ݷ��� request
		request.put("cateLogList", cateLogList);
		return ActionSupport.SUCCESS;
	}
	
	//ɾ�����Ͳ���
	public String catelogDel()
	{
		//ͨ�� id��ȡ���Ͷ���
		TCatelog catelog=catelogDAO.findById(id);
		catelog.setDel("yes");//����del �ֶ�Ϊyes
		catelogDAO.attachDirty(catelog);//���� ��ӷ���
		
		this.setMessage("�����ɹ�");//������Ϣ Ϊ�ɹ�
		this.setPath("catelogMana.action");//��ת·��
	    return "succeed";//����ֵ
	}
	
	//*********************get and set���� **********************
	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}
	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
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
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
}
