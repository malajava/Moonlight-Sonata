package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TCatelog;

/**
 *类型数据库操作类
 */

public class TCatelogDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TCatelogDAO.class);

	// property constants
	public static final String NAME = "name";//属性名


	public static final String DEL = "del";//参数值

	protected void initDao()
	{
		// do nothing
	}
	//添加 类型
	public void save(TCatelog transientInstance)
	{
		log.debug("saving TCatelog instance");
		try
		{
			//添加 类型
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}
	//删除 类型
	public void delete(TCatelog persistentInstance)
	{
		log.debug("deleting TCatelog instance");
		try
		{
			//删除 类型
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}
	//通过Id查找类型对象
	public TCatelog findById(java.lang.Integer id)
	{
		log.debug("getting TCatelog instance with id: " + id);
		try
		{
			//通过Id查找类型对象
			TCatelog instance = (TCatelog) getHibernateTemplate().get(
					"com.model.TCatelog", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}
	//通过类型信息 查找类型列表
	public List findByExample(TCatelog instance)
	{
		log.debug("finding TCatelog instance by example");
		try
		{
			//通过类型信息 查找类型列表
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
		log.debug("finding TCatelog instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			//通过属性名称 和 值 查找管理员 列表
			String queryString = "from TCatelog as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//通过用户名 查询用户信息
	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}


	//删除类型
	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}
	//查询所有类型 信息
	public List findAll()
	{
		log.debug("finding all TCatelog instances");
		try
		{//查询所有类型 信息
			String queryString = "from TCatelog";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}
	//修改类型信息
	public TCatelog merge(TCatelog detachedInstance)
	{
		log.debug("merging TCatelog instance");
		try
		{//修改类型信息
			TCatelog result = (TCatelog) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	//添加 或者 修改 类型信息
	public void attachDirty(TCatelog instance)
	{
		log.debug("attaching dirty TCatelog instance");
		try
		{//添加 或者 修改 类型信息
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	//锁住类型对象
	public void attachClean(TCatelog instance)
	{
		log.debug("attaching clean TCatelog instance");
		try
		{
			//锁住类型对象
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TCatelogDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TCatelogDAO) ctx.getBean("TCatelogDAO");
	}
}