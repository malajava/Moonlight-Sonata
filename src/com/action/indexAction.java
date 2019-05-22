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
 * 首页
 * @author Administrator
 *
 */
public class indexAction extends ActionSupport
{
	private TCatelogDAO catelogDAO;//类型Dao
	private TZhutiDAO zhutiDAO;//主题Dao
	private THuifuDAO huifuDAO;//回复Dao
	private TUserDAO userDAO;//用户Dao
	
	//首页  展示
	public String index()
	{
		//获取request
		Map request=(Map)ServletActionContext.getContext().get("request");
		//获取session
		Map session=ActionContext.getContext().getSession();
		//查询 del字段 为no 类型信息列表
		String sql="from TCatelog where del='no'";
		//Hibernate查询
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		//将值放入session中
		session.put("cateLogList", cateLogList);
		
		//通过shifouding字段 查询主题信息
		String s2="from TZhuti where shifouding='是'";
		//hibenate查询列表
		List zhuti_list_all=zhutiDAO.getHibernateTemplate().find(s2);
		////通过shifouding字段 查询主题信息  并按照时间排序
		String s3="from TZhuti where shifouding='否' order by shijian desc";
		//hibenate查询列表
		List zhuti_list_fouzhiding=zhutiDAO.getHibernateTemplate().find(s3);
		
		for(int i=0;i<zhuti_list_fouzhiding.size();i++)//循环
		{
			//主题对象
			TZhuti zhuti=(TZhuti)zhuti_list_fouzhiding.get(i);
			//将字段为shifouding='否'  主题集合 与 shifouding='是'查询出来放到一个集合中
			zhuti_list_all.add(zhuti);
		}
		//循环集合
		for(int j=0;j<zhuti_list_all.size();j++)
		{
			//主题对象
			TZhuti zhuti=(TZhuti)zhuti_list_all.get(j);
			//通过userid查询 user对象
			zhuti.setUser(userDAO.findById(zhuti.getUserId()));
			//通过主题编号 查询回复列表
			zhuti.setHuifushu(huifuDAO.getHibernateTemplate().find("from THuifu where zhutiId="+zhuti.getId()).size());
		}
		//将数据放入request对象中
		request.put("zhuti_list_all", zhuti_list_all);
		return ActionSupport.SUCCESS;//返回值
	}

	//*********************get and set方法 **********************
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
