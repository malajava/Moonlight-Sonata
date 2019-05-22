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
 * 用户操作 控制器
 * @author Administrator
 *
 */
public class userAction extends ActionSupport
{
	private Integer id;//编号
	private String loginname;//登录名称
	private String loginpw;//登录密码
	private String name;//姓名

	private String sex;//性别
	private String age;//年龄
	private String address;//地址
	private String tel;//电话

	private String email;//email邮箱
	private String qq;//qq
	private String fujian;//
	
	private String message;//提示消息
	private String path;//跳转路径
	
	private TUserDAO userDAO;//用户Dao
	
	//注册
	public String userReg()
	{
		//用户对象
		TUser user=new TUser();
		//设置登录名
		user.setLoginname(loginname);
		//设置密码
		user.setLoginpw(loginpw);
		//设置姓名
		user.setName(name);
		//设置性别
		user.setSex(sex);
		//设置年龄
		user.setAge(age);
		//设置地址
		user.setAddress(address);
		//设置电话
		user.setTel(tel);
		//设置email
		user.setEmail(email);
		//设置qq
		user.setQq(qq);
		//设置类型
		user.setType(1);
		if(fujian.equals(""))//判断 头像是否为空
		{
			//设置默认值
			user.setFujian("/img/user2.gif");
		}
		else
		{
			//设置图像值
			user.setFujian(fujian);
		}
		//设置del类型 为no
		user.setDel("no");
		//添加用户信息
		userDAO.save(user);
		//注册成功
		this.setMessage("注册成功,请登陆");
		this.setPath("/qiantai/default.jsp");//跳转路径
	    return "succeed";
	}
	
	//用户编辑
	public String userEdit()
	{
		//通过id 查询user对象
		TUser user=userDAO.findById(id);
		
		//设置属性  与上面一样
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
		
		//修改
		userDAO.attachDirty(user);
		
		//获取request对象
		Map request=(Map)ServletActionContext.getContext().get("request");
		//设置提示消息
		request.put("msg", "修改成功，重新登录后生效");
	    return "msg";//返回值
	}
	
	//登录退出
	public String userLogout()
	{
		//获取request对象
		HttpServletRequest request=ServletActionContext.getRequest();
		//设置用户类型 为null
		request.getSession().setAttribute("userType", null);
		//设置用户对象 为null
		request.getSession().setAttribute("user", null);
		//设置消息
		this.setMessage("安全退出");
		//跳转路径
		this.setPath("/qiantai/default.jsp");
	    return "succeed";//返回值
	}
	
	//查询 用户信息
	public String userMana()
	{
		//Hql语句  查询 用户信息
		String sql="from TUser where del='no' and type=1";
		//Hibernate 查询
		List userList=userDAO.getHibernateTemplate().find(sql);
		
		//获取request对象
		Map request=(Map)ServletActionContext.getContext().get("request");
		//将userList集合放入request中
		request.put("userList", userList);
		return ActionSupport.SUCCESS;
	}
	
	//删除用户
	public String userDel()
	{
		//通过id 查询user对象
		TUser user=userDAO.findById(id);
		user.setDel("yes");//设置del为yes 为删除状态
		userDAO.attachDirty(user);//删除操作
		
		//设置成功
		this.setMessage("操作成功");
		this.setPath("userMana.action");//设置跳转路径
	    return "succeed";//返回值 
	}
	
	
	
	//*********************get and set方法 **********************
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
