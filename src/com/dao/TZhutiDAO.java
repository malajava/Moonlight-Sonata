package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TZhuti;

/**
 *主题数据库操作类
 */

public class TZhutiDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TZhutiDAO.class);

	//属性
	public static final String TITLE = "title";

	public static final String CONTENT = "content";

	public static final String FUJIAN = "fujian";

	public static final String FUJIAN_YUANSHIMING = "fujianYuanshiming";

	public static final String SHIJIAN = "shijian";

	public static final String USER_ID = "userId";

	public static final String CATELOG_ID = "catelogId";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}
	//添加 主题信息
	public void save(TZhuti transientInstance)
	{
		log.debug("saving TZhuti instance");
		try
		{//添加 主题信息
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}
	//删除 主题信息
	public void delete(TZhuti persistentInstance)
	{
		log.debug("deleting TZhuti instance");
		try
		{	//删除 主题信息
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}
	//通过Id查找主题对象
	public TZhuti findById(java.lang.Integer id)
	{
		log.debug("getting TZhuti instance with id: " + id);
		try
		{
			//通过Id查找主题对象
			TZhuti instance = (TZhuti) getHibernateTemplate().get(
					"com.model.TZhuti", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}
	//通过主题信息 查找主题列表
	public List findByExample(TZhuti instance)
	{
		log.debug("finding TZhuti instance by example");
		try
		{//通过主题信息 查找主题列表
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
		log.debug("finding TZhuti instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			//通过属性名称 和 值 查找类型 列表
			String queryString = "from TZhuti as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//通过标题 查询主题信息
	public List findByTitle(Object title)
	{
		return findByProperty(TITLE, title);
	}
	//通过内容 查询主题信息
	public List findByContent(Object content)
	{
		return findByProperty(CONTENT, content);
	}
	//通过图像 查询主题信息
	public List findByFujian(Object fujian)
	{
		return findByProperty(FUJIAN, fujian);
	}
	// 查询主题信息
	public List findByFujianYuanshiming(Object fujianYuanshiming)
	{
		return findByProperty(FUJIAN_YUANSHIMING, fujianYuanshiming);
	}
	//通过时间 查询主题信息
	public List findByShijian(Object shijian)
	{
		return findByProperty(SHIJIAN, shijian);
	}
	//通过用户编号 查询主题信息
	public List findByUserId(Object userId)
	{
		return findByProperty(USER_ID, userId);
	}
	//通过类型编号 查询主题信息
	public List findByCatelogId(Object catelogId)
	{
		return findByProperty(CATELOG_ID, catelogId);
	}
	//通过del标记 查询主题信息
	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}
	//查询所有主题信息
	public List findAll()
	{
		log.debug("finding all TZhuti instances");
		try
		{//查询所有主题信息
			String queryString = "from TZhuti";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}
	//修改主题信息
	public TZhuti merge(TZhuti detachedInstance)
	{
		log.debug("merging TZhuti instance");
		try
		{	//修改主题信息
			TZhuti result = (TZhuti) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}
	//添加 或者 修改主题信息
	public void attachDirty(TZhuti instance)
	{
		log.debug("attaching dirty TZhuti instance");
		try
		{//添加 或者 修改主题信息
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}
	//锁住主题对象
	public void attachClean(TZhuti instance)
	{
		log.debug("attaching clean TZhuti instance");
		try
		{//锁住主题对象
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TZhutiDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TZhutiDAO) ctx.getBean("TZhutiDAO");
	}
}