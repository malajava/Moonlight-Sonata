package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.THuifu;

/**
 * 回复数据库操作栏
 */

public class THuifuDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(THuifuDAO.class);

	// property constants
	public static final String TITLE = "title";//标题

	public static final String CONTENT = "content";//内容

	public static final String SHIJIAN = "shijian";//时间

	public static final String USER_ID = "userId";//用户编号

	public static final String ZHUTI_ID = "zhutiId";//主题编号

	public static final String DEL = "del";//删除标记

	protected void initDao()
	{
		// do nothing
	}
	//添加 回复
	public void save(THuifu transientInstance)
	{
		log.debug("saving THuifu instance");
		try
		{//添加 回复
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}
	//删除 回复
	public void delete(THuifu persistentInstance)
	{
		log.debug("deleting THuifu instance");
		try
		{//删除 回复
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}
	//通过Id查找回复对象
	public THuifu findById(java.lang.Integer id)
	{
		log.debug("getting THuifu instance with id: " + id);
		try
		{
			//通过Id查找回复对象
			THuifu instance = (THuifu) getHibernateTemplate().get(
					"com.model.THuifu", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	//通过回复信息 查找回复列表
	public List findByExample(THuifu instance)
	{
		log.debug("finding THuifu instance by example");
		try
		{
			//通过回复信息 查找回复列表
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
		log.debug("finding THuifu instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			//通过属性名称 和 值 查找类型 列表
			String queryString = "from THuifu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//通过用户名 查询用户信息
	public List findByTitle(Object title)
	{
		return findByProperty(TITLE, title);
	}
	//通过内容 查询信息
	public List findByContent(Object content)
	{
		return findByProperty(CONTENT, content);
	}
	//通过时间 查询信息
	public List findByShijian(Object shijian)
	{
		return findByProperty(SHIJIAN, shijian);
	}
	//通过编号 查询信息
	public List findByUserId(Object userId)
	{
		return findByProperty(USER_ID, userId);
	}
	//通过主题编号 查询信息
	public List findByZhutiId(Object zhutiId)
	{
		return findByProperty(ZHUTI_ID, zhutiId);
	}

	//查找删除属性列表
	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}
	//查询所有回复信息
	public List findAll()
	{
		log.debug("finding all THuifu instances");
		try
		{//查询所有回复信息
			String queryString = "from THuifu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}
	//修改回复信息
	public THuifu merge(THuifu detachedInstance)
	{
		log.debug("merging THuifu instance");
		try
		{	//修改回复信息
			THuifu result = (THuifu) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}
	//添加 或者 修改回复信息
	public void attachDirty(THuifu instance)
	{
		log.debug("attaching dirty THuifu instance");
		try
		{//添加 或者 修改 回复信息
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}
	//锁住回复对象
	public void attachClean(THuifu instance)
	{
		log.debug("attaching clean THuifu instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static THuifuDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (THuifuDAO) ctx.getBean("THuifuDAO");
	}
}