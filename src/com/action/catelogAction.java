package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TCatelogDAO;
import com.model.TCatelog;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 类型处理 控制器类
 * @author Administrator
 *
 */
public class catelogAction extends ActionSupport
{
	private int id;//主键编号
	private String name;//姓名
	
	private String message;//提示消息
	private String path;//跳转路径
	
	private TCatelogDAO catelogDAO;//类型Dao
	
	//添加类型
	public String catelogAdd()
	{
		//创建TCatelog类型对象
		TCatelog catelog=new TCatelog();
		catelog.setName(name);//设置名称
		catelog.setDel("no");//设置 no标识符
		catelogDAO.save(catelog); //添加数据
		this.setMessage("操作成功");//设置成功标记
		this.setPath("catelogMana.action");//设置跳转路径
		return "succeed";//返回值
	}
	
	//查询del字段 为no的所有数据
	public String catelogMana()
	{
		//Hql语句 查询del字段 为no的所有数据
		String sql="from TCatelog where del='no'";
		//hibernate 发起查询
		List cateLogList=catelogDAO.getHibernateTemplate().find(sql);
		//获取request对象
		Map request=(Map)ServletActionContext.getContext().get("request");
		//将集合数据放入 request
		request.put("cateLogList", cateLogList);
		return ActionSupport.SUCCESS;
	}
	
	//删除类型操作
	public String catelogDel()
	{
		//通过 id获取类型对象
		TCatelog catelog=catelogDAO.findById(id);
		catelog.setDel("yes");//设置del 字段为yes
		catelogDAO.attachDirty(catelog);//调用 添加方法
		
		this.setMessage("操作成功");//设置消息 为成功
		this.setPath("catelogMana.action");//跳转路径
	    return "succeed";//返回值
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
