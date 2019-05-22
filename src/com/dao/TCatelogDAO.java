package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TCatelog;

/**
 *�������ݿ������
 */

public class TCatelogDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TCatelogDAO.class);

	// property constants
	public static final String NAME = "name";//������


	public static final String DEL = "del";//����ֵ

	protected void initDao()
	{
		// do nothing
	}
	//��� ����
	public void save(TCatelog transientInstance)
	{
		log.debug("saving TCatelog instance");
		try
		{
			//��� ����
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}
	//ɾ�� ����
	public void delete(TCatelog persistentInstance)
	{
		log.debug("deleting TCatelog instance");
		try
		{
			//ɾ�� ����
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}
	//ͨ��Id�������Ͷ���
	public TCatelog findById(java.lang.Integer id)
	{
		log.debug("getting TCatelog instance with id: " + id);
		try
		{
			//ͨ��Id�������Ͷ���
			TCatelog instance = (TCatelog) getHibernateTemplate().get(
					"com.model.TCatelog", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}
	//ͨ��������Ϣ ���������б�
	public List findByExample(TCatelog instance)
	{
		log.debug("finding TCatelog instance by example");
		try
		{
			//ͨ��������Ϣ ���������б�
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

	//ͨ���������� �� ֵ �������� �б�
	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TCatelog instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			//ͨ���������� �� ֵ ���ҹ���Ա �б�
			String queryString = "from TCatelog as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//ͨ���û��� ��ѯ�û���Ϣ
	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}


	//ɾ������
	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}
	//��ѯ�������� ��Ϣ
	public List findAll()
	{
		log.debug("finding all TCatelog instances");
		try
		{//��ѯ�������� ��Ϣ
			String queryString = "from TCatelog";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}
	//�޸�������Ϣ
	public TCatelog merge(TCatelog detachedInstance)
	{
		log.debug("merging TCatelog instance");
		try
		{//�޸�������Ϣ
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

	//��� ���� �޸� ������Ϣ
	public void attachDirty(TCatelog instance)
	{
		log.debug("attaching dirty TCatelog instance");
		try
		{//��� ���� �޸� ������Ϣ
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	//��ס���Ͷ���
	public void attachClean(TCatelog instance)
	{
		log.debug("attaching clean TCatelog instance");
		try
		{
			//��ס���Ͷ���
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