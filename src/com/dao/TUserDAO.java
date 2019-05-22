package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TUser;

/**
 * 用户数据库操作类
 */

public class TUserDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TUserDAO.class);

	// 属性
	public static final String LOGINNAME = "loginname";

	public static final String LOGINPW = "loginpw";

	public static final String NAME = "name";

	public static final String SEX = "sex";

	public static final String AGE = "age";

	public static final String ADDRESS = "address";

	public static final String TEL = "tel";

	public static final String EMAIL = "email";

	public static final String QQ = "qq";

	public static final String TYPE = "type";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	//添加 用户信息
	public void save(TUser transientInstance)
	{
		log.debug("saving TUser instance");
		try
		{	//添加 用户信息
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}
	//删除 用户信息
	public void delete(TUser persistentInstance)
	{
		log.debug("deleting TUser instance");
		try
		{//删除 用户信息
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}
	//通过Id查找用户对象
	public TUser findById(java.lang.Integer id)
	{
		log.debug("getting TUser instance with id: " + id);
		try
		{//通过Id查找用户对象
			TUser instance = (TUser) getHibernateTemplate().get(
					"com.model.TUser", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}
	//通过用户信息 查找用户列表
	public List findByExample(TUser instance)
	{
		log.debug("finding TUser instance by example");
		try
		{//通过用户信息 查找用户列表
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}
	//通过属性名称 和 值 查找类型 列表
	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TUser instance with property: " + propertyName
				+ ", value: " + value);
		try
		{//通过属性名称 和 值 查找类型 列表
			String queryString = "from TUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//通过登录名 查询用户信息
	public List findByLoginname(Object loginname)
	{
		return findByProperty(LOGINNAME, loginname);
	}
	//通过密码 查询用户信息
	public List findByLoginpw(Object loginpw)
	{
		return findByProperty(LOGINPW, loginpw);
	}
	//通过名字 查询用户信息
	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}
	//通过性别 查询用户信息
	public List findBySex(Object sex)
	{
		return findByProperty(SEX, sex);
	}
	//通过年龄 查询用户信息
	public List findByAge(Object age)
	{
		return findByProperty(AGE, age);
	}
	//通过地址 查询用户信息
	public List findByAddress(Object address)
	{
		return findByProperty(ADDRESS, address);
	}
	//通过电话 查询用户信息
	public List findByTel(Object tel)
	{
		return findByProperty(TEL, tel);
	}
	//通过email查询用户信息
	public List findByEmail(Object email)
	{
		return findByProperty(EMAIL, email);
	}
	//通过qq 查询用户信息
	public List findByQq(Object qq)
	{
		return findByProperty(QQ, qq);
	}
	//通过类型 查询用户信息
	public List findByType(Object type)
	{
		return findByProperty(TYPE, type);
	}
	//通过del 查询用户信息
	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}
	//查询所有用户信息
	public List findAll()
	{
		log.debug("finding all TUser instances");
		try
		{//查询所有用户信息
			String queryString = "from TUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}
	//修改用户信息
	public TUser merge(TUser detachedInstance)
	{
		log.debug("merging TUser instance");
		try
		{//修改用户信息
			TUser result = (TUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}
	//添加 或者 修改用户信息
	public void attachDirty(TUser instance)
	{
		log.debug("attaching dirty TUser instance");
		try
		{//添加 或者 修改用户信息
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}
	//锁住用户对象
	public void attachClean(TUser instance)
	{
		log.debug("attaching clean TUser instance");
		try
		{//锁住用户对象
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TUserDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TUserDAO) ctx.getBean("TUserDAO");
	}
}