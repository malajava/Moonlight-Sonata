package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TCatelogDAO;
import com.dao.THuifuDAO;
import com.dao.TUserDAO;
import com.dao.TZhutiDAO;
import com.model.TZhuti;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ҳ
 * @author Administrator
 *
 */
public class indexAction extends ActionSupport
{
	private TCatelogDAO catelogDAO;//����Dao
	private TZhutiDAO zhutiDAO;//����Dao
	private THuifuDAO huifuDAO;//�ظ�Dao
	private TUserDAO userDAO;//�û�Dao
	
	//��ҳ  չʾ
	public String index()
	{
		//��ȡrequest
		Map request=(Map)ServletActionContext.getContext().get("request");
		//��ȡsession
		Map session=ActionContext.getContext().getSession();
		//��ѯ del�ֶ� Ϊno ������Ϣ�б�
		String sql="from TCatelog where del='no'";
		//Hibernate��ѯ
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		//��ֵ����session��
		session.put("cateLogList", cateLogList);
		
		//ͨ��shifouding�ֶ� ��ѯ������Ϣ
		String s2="from TZhuti where shifouding='��'";
		//hibenate��ѯ�б�
		List zhuti_list_all=zhutiDAO.getHibernateTemplate().find(s2);
		////ͨ��shifouding�ֶ� ��ѯ������Ϣ  ������ʱ������
		String s3="from TZhuti where shifouding='��' order by shijian desc";
		//hibenate��ѯ�б�
		List zhuti_list_fouzhiding=zhutiDAO.getHibernateTemplate().find(s3);
		
		for(int i=0;i<zhuti_list_fouzhiding.size();i++)//ѭ��
		{
			//�������
			TZhuti zhuti=(TZhuti)zhuti_list_fouzhiding.get(i);
			//���ֶ�Ϊshifouding='��'  ���⼯�� �� shifouding='��'��ѯ�����ŵ�һ��������
			zhuti_list_all.add(zhuti);
		}
		//ѭ������
		for(int j=0;j<zhuti_list_all.size();j++)
		{
			//�������
			TZhuti zhuti=(TZhuti)zhuti_list_all.get(j);
			//ͨ��userid��ѯ user����
			zhuti.setUser(userDAO.findById(zhuti.getUserId()));
			//ͨ�������� ��ѯ�ظ��б�
			zhuti.setHuifushu(huifuDAO.getHibernateTemplate().find("from THuifu where zhutiId="+zhuti.getId()).size());
		}
		//�����ݷ���request������
		request.put("zhuti_list_all", zhuti_list_all);
		return ActionSupport.SUCCESS;//����ֵ
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


	public TZhutiDAO getZhutiDAO()
	{
		return zhutiDAO;
	}


	public TUserDAO getUserDAO()
	{
		return userDAO;
	}


	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}


	public void setZhutiDAO(TZhutiDAO zhutiDAO)
	{
		this.zhutiDAO = zhutiDAO;
	}


	public THuifuDAO getHuifuDAO()
	{
		return huifuDAO;
	}


	public void setHuifuDAO(THuifuDAO huifuDAO)
	{
		this.huifuDAO = huifuDAO;
	}

}
