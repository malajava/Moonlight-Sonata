package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TAdmin;

/**
 * 管理员数据操作了
 * 
 */

public class TAdminDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TAdminDAO.class);//日志对象

	
	public static final String USER_NAME = "userName";//用户名

	public static final String USER_PW = "userPw";//密码

	protected void initDao() {
		// do nothing
	}

	//添加 管理员
	public void save(TAdmin transientInstance) {
		log.debug("saving TAdmin instance");
		try {
			//添加操作
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	//删除管理员
	public void delete(TAdmin persistentInstance) {
		log.debug("deleting TAdmin instance");
		try {
			//删除管理员操作
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	//通过Id查找管理员对象
	public TAdmin findById(java.lang.Integer id) {
		log.debug("getting TAdmin instance with id: " + id);
		try {
			//通过Id查找管理员对象
			TAdmin instance = (TAdmin) getHibernateTemplate().get(
					"com.model.TAdmin", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	//通过管理员信息 查找管理员列表
	public List findByExample(TAdmin instance) {
		log.debug("finding TAdmin instance by example");
		try {
			//通过管理员信息 查找管理员列表
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	//通过属性名称 和 值 查找管理员 列表
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TAdmin instance with property: " + propertyName
				+ ", value: " + value);
		try {
			//通过属性名称 和 值 查找管理员 列表
			String queryString = "from TAdmin as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	//通过用户名 查询用户信息
	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}
	//通过密码 查询用户信息
	public List findByUserPw(Object userPw) {
		return findByProperty(USER_PW, userPw);
	}

	//查询所有管理员 信息
	public List findAll() {
		log.debug("finding all TAdmin instances");
		try {
			//查询所有管理员 信息
			String queryString = "from TAdmin";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	//修改管理员信息
	public TAdmin merge(TAdmin detachedInstance) {
		log.debug("merging TAdmin instance");
		try {
			//修改管理员信息
			TAdmin result = (TAdmin) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
//添加 或者 修改 管理员信息
	public void attachDirty(TAdmin instance) {
		log.debug("attaching dirty TAdmin instance");
		try {
			//添加 或者 修改 管理员信息
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	//锁住管理员对象
	public void attachClean(TAdmin instance) {
		log.debug("attaching clean TAdmin instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TAdminDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TAdminDAO) ctx.getBean("TAdminDAO");
	}
}