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
 * 主题信息 处理 控制器
 * @author Administrator
 *
 */
public class zhutiAction extends ActionSupport
{
	private int id;//编号
	private String title;//标题
	private String content;//内容
	private String fujian;//图像

	private String fujianYuanshiming;
	private String shijian;//时间
	private Integer userId;//用户编号
	private Integer catelogId;//类型编号
	
	private String shifouding;//是否定
	
	private String message;//消息提示
	private String path;//路径
	
	private TZhutiDAO zhutiDAO;//主题Dao
	private THuifuDAO huifuDAO;//回复Dao
	private TUserDAO userDAO;//用户Dao
	
	//添加主题
	public String zhutiAdd()
	{
		//主题对象
		TZhuti zhuti=new TZhuti();
		//设置标题
		zhuti.setTitle(title);
		//内容
		zhuti.setContent(content);
		//图像
		zhuti.setFujian(fujian);
		zhuti.setFujianYuanshiming(fujianYuanshiming);
		
		//时间
		zhuti.setShijian(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) );
		//用户编号
		zhuti.setUserId(userId);
		zhuti.setCatelogId(catelogId);//类型编号
		zhuti.setShifouding("否");
		zhuti.setShifoujing("否");
		
		//添加主题
		zhutiDAO.save(zhuti);
		//成功消息提示
		this.setMessage("发帖成功");
		this.setPath("/qiantai/default.jsp");//路径跳转
	    return "succeed";//返回值
	}
	
	//主题列表展示
	public String zhutiAll()
	{
		//通过类型编号 和 shifouding='是' 字段 查询主题列表
		String s2="from TZhuti where catelogId="+catelogId+ "and shifouding='是'";
		List zhuti_list_all=zhutiDAO.getHibernateTemplate().find(s2);
		
		//通过类型编号 和 shifouding='否' 字段 查询主题列表
		String s3="from TZhuti where catelogId="+catelogId+"and shifouding='否' order by shijian desc";
		List zhuti_list_fouzhiding=zhutiDAO.getHibernateTemplate().find(s3);
		
		//循环  将zhuti_list_fouzhiding与zhuti_list_all 合并在一个集合中
		for(int i=0;i<zhuti_list_fouzhiding.size();i++)
		{
			TZhuti zhuti=(TZhuti)zhuti_list_fouzhiding.get(i);
			zhuti_list_all.add(zhuti);
		}
		
		//循环
		for(int j=0;j<zhuti_list_all.size();j++)
		{
			//主题对象
			TZhuti zhuti=(TZhuti)zhuti_list_all.get(j);
			//通过userid查询user对象  设置到主题对象中
			zhuti.setUser(userDAO.findById(zhuti.getUserId()));
			//通过主题编号查询 回复列表
			zhuti.setHuifushu(huifuDAO.getHibernateTemplate().find("from THuifu where zhutiId="+zhuti.getId()).size());
		}
		//创建request对象
		HttpServletRequest req=ServletActionContext.getRequest();
		//将zhuti_list_all存放到request中
		req.setAttribute("zhuti_list_all", zhuti_list_all);
		return ActionSupport.SUCCESS;//返回值
	}
	
	//通过标题查询主题列表
	public String zhutiRes()
	{
		//通过标题查询主题列表
		String s2="from TZhuti where title like '%"+title.trim()+"%'";
		List zhuti_list_all=zhutiDAO.getHibernateTemplate().find(s2);
		
		//循环
		for(int j=0;j<zhuti_list_all.size();j++)
		{
			//主题
			TZhuti zhuti=(TZhuti)zhuti_list_all.get(j);
			//通过userid 查询user对象
			zhuti.setUser(userDAO.findById(zhuti.getUserId()));
			//通知主题编号 查询回复列表
			zhuti.setHuifushu(huifuDAO.getHibernateTemplate().find("from THuifu where zhutiId="+zhuti.getId()).size());
		}
		//创建request对象
		HttpServletRequest req=ServletActionContext.getRequest();
		//将zhuti_list_all存放到request中
		req.setAttribute("zhuti_list_all", zhuti_list_all);
		return ActionSupport.SUCCESS;//返回值
	}
	
	//通过shifouding查询主题列表
	public String zhutiMana()
	{
		//通过类型编号 和 shifouding='是' 字段 查询主题列表
		String s2="from TZhuti where shifouding='是'";
		List zhuti_list_all=zhutiDAO.getHibernateTemplate().find(s2);
		
		//通过类型编号 和 shifouding='否' 字段 查询主题列表
		String s3="from TZhuti where shifouding='否' order by shijian desc";
		List zhuti_list_fouzhiding=zhutiDAO.getHibernateTemplate().find(s3);
		
		//循环  将zhuti_list_fouzhiding与zhuti_list_all 合并在一个集合中
		for(int i=0;i<zhuti_list_fouzhiding.size();i++)
		{
			TZhuti zhuti=(TZhuti)zhuti_list_fouzhiding.get(i);
			zhuti_list_all.add(zhuti);
		}
		//循环
		for(int j=0;j<zhuti_list_all.size();j++)
		{
			//主题对象
			TZhuti zhuti=(TZhuti)zhuti_list_all.get(j);
			//通过userid 查询user对象
			zhuti.setUser(userDAO.findById(zhuti.getUserId()));
			//通知主题编号 查询回复列表
			zhuti.setHuifushu(huifuDAO.getHibernateTemplate().find("from THuifu where zhutiId="+zhuti.getId()).size());
		}
		//创建request对象
		HttpServletRequest req=ServletActionContext.getRequest();
		//将zhuti_list_all存放到request中
		req.setAttribute("zhuti_list_all", zhuti_list_all);
		return ActionSupport.SUCCESS;//返回值
	}
	
	//删除主题
	public String zhutiDel()
	{
		//获取主题对象
		TZhuti zhuti=zhutiDAO.findById(id);
		//删除主题
		zhutiDAO.delete(zhuti);
		
		//删除回复
		String sql="delete from THuifu where zhutiId="+zhuti.getId();
		huifuDAO.getHibernateTemplate().bulkUpdate(sql);
		
		//提示删除成功
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "成功删除");
		return "msg";//返回值
	}
	
	
	//设置主题  置顶
	public String zhuti_zhiding_shezhi()
	{
		//通过编号 查询主题对象
		TZhuti zhuti=zhutiDAO.findById(id);
		//设置主题  置顶
		zhuti.setShifouding("是");
		//更新
		zhutiDAO.getHibernateTemplate().update(zhuti);
		//提示成功
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "设置置顶成功");
		return "msg";
	}
	//设置  取消置顶
	public String zhuti_zhiding_quxiao()
	{
		//通过编号 查询主题对象
		TZhuti zhuti=zhutiDAO.findById(id);
		//设置主题  不置顶
		zhuti.setShifouding("否");
		//更新
		zhutiDAO.getHibernateTemplate().update(zhuti);
		//提示成功
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "取消置顶成功");
		return "msg";
	}
	
	
	//设置 精华帖子 
	public String zhuti_jinghua_shezhi()
	{
		//通过编号 查询主题对象
		TZhuti zhuti=zhutiDAO.findById(id);
		//设置 精华帖子
		zhuti.setShifoujing("是");
		//更新
		zhutiDAO.getHibernateTemplate().update(zhuti);
		//提示成功
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "设置精华成功");
		return "msg";
	}
	//设置 取消精华帖子 
	public String zhuti_jinghua_quxiao()
	{
		//通过编号 查询主题对象
		TZhuti zhuti=zhutiDAO.findById(id);
		//设置 精华帖子为否
		zhuti.setShifoujing("否");
		//更新
		zhutiDAO.getHibernateTemplate().update(zhuti);
		//提示成功
		HttpServletRequest req=ServletActionContext.getRequest();
		req.setAttribute("msg", "取消精华成功");
		return "msg";
	}
	
	
	//查询自己发布的主题
	public String zhutiMe()
	{
		//获取用户登录信息
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		TUser user=(TUser)session.getAttribute("user");
		
		//通过用户编号和shifouding='是'  查询 主题列表
		String s2="from TZhuti where userId="+user.getId()+ " and shifouding='是'";
		List zhuti_list_all=zhutiDAO.getHibernateTemplate().find(s2);
		//通过用户编号和shifouding='否'  查询 主题列表
		String s3="from TZhuti where userId="+user.getId()+" and shifouding='否' order by shijian desc";
		List zhuti_list_fouzhiding=zhutiDAO.getHibernateTemplate().find(s3);
		
		//将 两个集合 合在一起
		for(int i=0;i<zhuti_list_fouzhiding.size();i++)
		{
			TZhuti zhuti=(TZhuti)zhuti_list_fouzhiding.get(i);
			zhuti_list_all.add(zhuti);
		}
		//循环
		for(int j=0;j<zhuti_list_all.size();j++)
		{
			//主题对象
			TZhuti zhuti=(TZhuti)zhuti_list_all.get(j);
			//通过userid 查询user对象
			zhuti.setUser(userDAO.findById(zhuti.getUserId()));
			//通知主题编号 查询回复列表
			zhuti.setHuifushu(huifuDAO.getHibernateTemplate().find("from THuifu where zhutiId="+zhuti.getId()).size());
		}
		//将zhuti_list_all存放到request中
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
