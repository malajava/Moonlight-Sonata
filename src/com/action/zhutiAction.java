package com.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.dao.THuifuDAO;
import com.dao.TUserDAO;
import com.dao.TZhutiDAO;
import com.model.THuifu;
import com.model.TUser;
import com.model.TZhuti;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ������Ϣ ���� ������
 * @author Administrator
 *
 */
public class zhutiAction extends ActionSupport
{
	private int id;//���
	private String title;//����
	private String content;//����
	private String fujian;//ͼ��

	private String fujianYuanshiming;
	private String shijian;//ʱ��
	private Integer userId;//�û����
	private Integer catelogId;//���ͱ��
	
	private String shifouding;//�Ƿ�
	
	private String message;//��Ϣ��ʾ
	private String path;//·��
	
	private TZhutiDAO zhutiDAO;//����Dao
	private THuifuDAO huifuDAO;//�ظ�Dao
	private TUserDAO userDAO;//�û�Dao
	
	//�������
	public String zhutiAdd()
	{
		//�������
		TZhuti zhuti=new TZhuti();
		//���ñ���
		zhuti.setTitle(title);
		//����
		zhuti.setContent(content);
		//ͼ��
		zhuti.setFujian(fujian);
		zhuti.setFujianYuanshiming(fujianYuanshiming);
		
		//ʱ��
		zhuti.setShijian(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) );
		//�û����
		zhuti.setUserId(userId);
		zhuti.setCatelogId(catelogId);//���ͱ��
		zhuti.setShifouding("��");
		zhuti.setShifoujing("��");
		
		//�������
		zhutiDAO.save(zhuti);
		//�ɹ���Ϣ��ʾ
		this.setMessage("�����ɹ�");
		this.setPath("/qiantai/default.jsp");//·����ת
	    return "succeed";//����ֵ
	}
	
	//�����б�չʾ
	public String zhutiAll()
	{
		//ͨ�����ͱ�� �� shifouding='��' �ֶ� ��ѯ�����б�
		String s2="from TZhuti where catelogId="+catelogId+ "and shifouding='��'";
		List zhuti_list_all=zhutiDAO.getHibernateTemplate().find(s2);
		
		//ͨ�����ͱ�� �� shifouding='��' �ֶ� ��ѯ�����б�
		String s3="from TZhuti where catelogId="+catelogId+"and shifouding='��' order by shijian desc";
		List zhuti_list_fouzhiding=zhutiDAO.getHibernateTemplate().find(s3);
		
		//ѭ��  ��zhuti_list_fouzhiding��zhuti_list_all �ϲ���һ��������
		for(int i=0;i<zhuti_list_fouzhiding.size();i++)
		{
			TZhuti zhuti=(TZhuti)zhuti_list_fouzhiding.get(i);
			zhuti_list_all.add(zhuti);
		}
		
		//ѭ��
		for(int j=0;j<zhuti_list_all.size();j++)
		{
			//�������
			TZhuti zhuti=(TZhuti)zhuti_list_all.get(j);
			//ͨ��userid��ѯuser����  ���õ����������
			zhuti.setUser(userDAO.findById(zhuti.getUserId()));
			//ͨ�������Ų�ѯ �ظ��б�
			zhuti.setHuifushu(huifuDAO.getHibernateTemplate().find("from THuifu where zhutiId="+zhuti.getId()).size());
		}
		//����request����
		HttpServletRequest req=ServletActionContext.getRequest();
		//��zhuti_list_all��ŵ�request��
		req.setAttribute("zhuti_list_all", zhuti_list_all);
		return ActionSupport.SUCCESS;//����ֵ
	}
	
	//ͨ�������ѯ�����б�
	public String zhutiRes()
	{
		//ͨ�������ѯ�����б�
		String s2="from TZhuti where title like '%"+title.trim()+"%'";
		List zhuti_list_all=zhutiDAO.getHibernateTemplate().find(s2);
		
		//ѭ��
		for(int j=0;j<zhuti_list_all.size();j++)
		{
			//����
			TZhuti zhuti=(TZhuti)zhuti_list_all.get(j);
			//ͨ��userid ��ѯuser����
			zhuti.setUser(userDAO.findById(zhuti.getUserId()));
			//֪ͨ������ ��ѯ�ظ��б�
			zhuti.setHuifushu(huifuDAO.getHibernateTemplate().find("from THuifu where zhutiId="+zhuti.getId()).size());
		}
		//����request����
		HttpServletRequest req=ServletActionContext.getRequest();
		//��zhuti_list_all��ŵ�request��
		req.setAttribute("zhuti_list_all", zhuti_list_all);
		return ActionSupport.SUCCESS;//����ֵ
	}
	
	//ͨ��shifouding��ѯ�����б�
	public String zhutiMana()
	{
		//ͨ�����ͱ�� �� shifouding='��' �ֶ� ��ѯ�����б�
		String s2="from TZhuti where shifouding='��'";
		List zhuti_list_all=zhutiDAO.getHibernateTemplate().find(s2);
		
		//ͨ�����ͱ�� �� shifouding='��' �ֶ� ��ѯ�����б�
		String s3="from TZhuti where shifouding='��' order by shijian desc";
		List zhuti_list_fouzhiding=zhutiDAO.getHibernateTemplate().find(s3);
		
		//ѭ��  ��zhuti_list_fouzhiding��zhuti_list_all �ϲ���һ��������
		for(int i=0;i<zhuti_list_fouzhiding.size();i++)
		{
			TZhuti zhuti=(TZhuti)zhuti_list_fouzhiding.get(i);
			zhuti_list_all.add(zhuti);
		}
		//ѭ��
		for(int j=0;j<zhuti_list_all.size();j++)
		{
			//�������
			TZhuti zhuti=(TZhuti)zhuti_list_all.get(j);
			//ͨ��userid ��ѯuser����
			zhuti.setUser(userDAO.findById(zhuti.getUserId()));
			//֪ͨ������ ��ѯ�ظ��б�
			zhuti.setHuifushu(huifuDAO.getHibernateTemplate().find("from THuifu where zhutiId="+zhuti.getId()).size());
		}
		//����request����
		HttpServletRequest req=ServletActionContext.getRequest();
		//��zhuti_list_all��ŵ�request��
		req.setAttribute("zhuti_list_all", zhuti_list_all);
		return ActionSupport.SUCCESS;//����ֵ
	}
	
	//ɾ������
	public String zhutiDel()
	{
		//��ȡ�������
		TZhuti zhuti=zhutiDAO.findById(id);
		//ɾ������
		zhutiDAO.delete(zhuti);
		
		//ɾ���ظ�
		String sql="delete from THuifu where zhutiId="+zhuti.getId();
		huifuDAO.getHibernateTemplate().bulkUpdate(sql);
		
		//��ʾɾ���ɹ�
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "�ɹ�ɾ��");
		return "msg";//����ֵ
	}
	
	
	//��������  �ö�
	public String zhuti_zhiding_shezhi()
	{
		//ͨ����� ��ѯ�������
		TZhuti zhuti=zhutiDAO.findById(id);
		//��������  �ö�
		zhuti.setShifouding("��");
		//����
		zhutiDAO.getHibernateTemplate().update(zhuti);
		//��ʾ�ɹ�
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "�����ö��ɹ�");
		return "msg";
	}
	//����  ȡ���ö�
	public String zhuti_zhiding_quxiao()
	{
		//ͨ����� ��ѯ�������
		TZhuti zhuti=zhutiDAO.findById(id);
		//��������  ���ö�
		zhuti.setShifouding("��");
		//����
		zhutiDAO.getHibernateTemplate().update(zhuti);
		//��ʾ�ɹ�
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "ȡ���ö��ɹ�");
		return "msg";
	}
	
	
	//���� �������� 
	public String zhuti_jinghua_shezhi()
	{
		//ͨ����� ��ѯ�������
		TZhuti zhuti=zhutiDAO.findById(id);
		//���� ��������
		zhuti.setShifoujing("��");
		//����
		zhutiDAO.getHibernateTemplate().update(zhuti);
		//��ʾ�ɹ�
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "���þ����ɹ�");
		return "msg";
	}
	//���� ȡ���������� 
	public String zhuti_jinghua_quxiao()
	{
		//ͨ����� ��ѯ�������
		TZhuti zhuti=zhutiDAO.findById(id);
		//���� ��������Ϊ��
		zhuti.setShifoujing("��");
		//����
		zhutiDAO.getHibernateTemplate().update(zhuti);
		//��ʾ�ɹ�
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "ȡ�������ɹ�");
		return "msg";
	}
	
	
	//��ѯ�Լ�����������
	public String zhutiMe()
	{
		//��ȡ�û���¼��Ϣ
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		TUser user=(TUser)session.getAttribute("user");
		
		//ͨ���û���ź�shifouding='��'  ��ѯ �����б�
		String s2="from TZhuti where userId="+user.getId()+ " and shifouding='��'";
		List zhuti_list_all=zhutiDAO.getHibernateTemplate().find(s2);
		//ͨ���û���ź�shifouding='��'  ��ѯ �����б�
		String s3="from TZhuti where userId="+user.getId()+" and shifouding='��' order by shijian desc";
		List zhuti_list_fouzhiding=zhutiDAO.getHibernateTemplate().find(s3);
		
		//�� �������� ����һ��
		for(int i=0;i<zhuti_list_fouzhiding.size();i++)
		{
			TZhuti zhuti=(TZhuti)zhuti_list_fouzhiding.get(i);
			zhuti_list_all.add(zhuti);
		}
		//ѭ��
		for(int j=0;j<zhuti_list_all.size();j++)
		{
			//�������
			TZhuti zhuti=(TZhuti)zhuti_list_all.get(j);
			//ͨ��userid ��ѯuser����
			zhuti.setUser(userDAO.findById(zhuti.getUserId()));
			//֪ͨ������ ��ѯ�ظ��б�
			zhuti.setHuifushu(huifuDAO.getHibernateTemplate().find("from THuifu where zhutiId="+zhuti.getId()).size());
		}
		//��zhuti_list_all��ŵ�request��
		req.setAttribute("zhuti_list_all", zhuti_list_all);
		return ActionSupport.SUCCESS;
	}

	public Integer getCatelogId()
	{
		return catelogId;
	}

	public void setCatelogId(Integer catelogId)
	{
		this.catelogId = catelogId;
	}

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
	public String getShifouding()
	{
		return shifouding;
	}

	public void setShifouding(String shifouding)
	{
		this.shifouding = shifouding;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public TUserDAO getUserDAO()
	{
		return userDAO;
	}

	public void setUserDAO(TUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	public String getFujian()
	{
		return fujian;
	}

	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}

	public String getFujianYuanshiming()
	{
		return fujianYuanshiming;
	}

	public void setFujianYuanshiming(String fujianYuanshiming)
	{
		this.fujianYuanshiming = fujianYuanshiming;
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

	public TZhutiDAO getZhutiDAO()
	{
		return zhutiDAO;
	}

	public void setZhutiDAO(TZhutiDAO zhutiDAO)
	{
		this.zhutiDAO = zhutiDAO;
	}
	
}
