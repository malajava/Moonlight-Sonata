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
 * 回复操作 控制器
 * @author Administrator
 *
 */
public class huifuAction extends ActionSupport
{
	private int id;//回复编号
	private String title;//标题
	private String content;//内容
	
	private String shijian;//时间
	private Integer userId;//用户编号
	private Integer zhutiId;//主题编号
	
	private String message;//提示消息
	private String path;//跳转路径
	
	private THuifuDAO huifuDAO;//回复Dao
	private TZhutiDAO zhutiDAO;//主题Dao
	private TUserDAO userDAO;//用户Dao
	
	//查询所有回复信息
	public String huifuAll()
	{
		//通过主题编号  查询 主题对象 
		TZhuti zhuti=zhutiDAO.findById(zhutiId);
		//通过主题userId查询 user对象 将user对象设置主题对象中
		zhuti.setUser(userDAO.findById(zhuti.getUserId()));
		
		//HQL语句  通过主题编号 查询回复信息
		String sql="from THuifu where zhutiId=?";
		//主题编号
		Object[] c={zhuti.getId()};
		// 通过 主题编号 查询 回复信息
		List huifuList=huifuDAO.getHibernateTemplate().find(sql,c);
		for(int i=0;i<huifuList.size();i++)//循环回复信息
		{
			//回复对象
			THuifu huifu=(THuifu)huifuList.get(i);
			//通过userid 获取user对象 将user对象 设置到 回复对象中
			huifu.setUser(userDAO.findById(huifu.getUserId()));
		}
		
		//将 回复集合 赋值给主题对象的 huifuList属性中  方便页面操作数据
		zhuti.setHuifuList(huifuList);
		
		//创建request对象
		HttpServletRequest req=ServletActionContext.getRequest();
		//将主题对象 放入 request中
		req.setAttribute("zhuti", zhuti);
		//将 回复列表 放入 request中
		req.setAttribute("huifuList", huifuList);
		return ActionSupport.SUCCESS;//返回值
	}
	
	//添加回复信息
	public String huifuAdd()
	{
		//回复对象
		THuifu huifu=new THuifu();
		//设置 标题
		huifu.setTitle(title);
		//设置内容
		huifu.setContent(content);
		//时间
		huifu.setShijian(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) );
		//用户编号
		huifu.setUserId(userId);
		//主题编号
		huifu.setZhutiId(zhutiId);
		//添加回复
		huifuDAO.save(huifu);
		//设置 提示消息
		this.setMessage("回复成功");
		//设置跳转路径
		this.setPath("/qiantai/default.jsp");
	    return "succeed";//返回值
		
	}
	
	//通过主题编号 查询回复信息
	public String huifuMana()
	{
		//通过主题编号  获取 主题对象
		TZhuti zhuti=zhutiDAO.findById(zhutiId);
		//通过主题下userid获取 user对象 
		zhuti.setUser(userDAO.findById(zhuti.getUserId()));
		//通过主题编号 获取回复 对象
		String sql="from THuifu where zhutiId=?";
		Object[] c={zhuti.getId()};//编号
		//通过主题编号 查询回复信息列表
		List huifuList=huifuDAO.getHibernateTemplate().find(sql,c);
		for(int i=0;i<huifuList.size();i++)//循环
		{
			//回复对象
			THuifu huifu=(THuifu)huifuList.get(i);
			//设置回复user对象
			huifu.setUser(userDAO.findById(huifu.getUserId()));
		}
		//主题下 设置 回复集合列表
		zhuti.setHuifuList(huifuList);
		
		//获取 request
		HttpServletRequest req=ServletActionContext.getRequest();
		//将主题对象 放入request对象
		req.setAttribute("zhuti", zhuti);
		//将回复列表 放入request对象
		req.setAttribute("huifuList", huifuList);
		return ActionSupport.SUCCESS;//返回值
	}
	
	//删除回复
	public String huifuDel()
	{
		
		//通过id获取 回复对象
		THuifu huifu=huifuDAO.findById(id);
		huifuDAO.delete(huifu);//删除回复对象
		//获取request
		HttpServletRequest req=ServletActionContext.getRequest();
		//设置消息 为成功
		req.setAttribute("msg", "成功删除");
		return "msg";//返回值
	}
	//*********************get and set方法 **********************
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
