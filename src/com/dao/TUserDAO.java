package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TUser;

/**
 * �û����ݿ������
 */

public class TUserDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TUserDAO.class);

	// ����
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

	//��� �û���Ϣ
	public void save(TUser transientInstance)
	{
		log.debug("saving TUser instance");
		try
		{	//��� �û���Ϣ
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}
	//ɾ�� �û���Ϣ
	public void delete(TUser persistentInstance)
	{
		log.debug("deleting TUser instance");
		try
		{//ɾ�� �û���Ϣ
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}
	//ͨ��Id�����û�����
	public TUser findById(java.lang.Integer id)
	{
		log.debug("getting TUser instance with id: " + id);
		try
		{//ͨ��Id�����û�����
			TUser instance = (TUser) getHibernateTemplate().get(
					"com.model.TUser", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}
	//ͨ���û���Ϣ �����û��б�
	public List findByExample(TUser instance)
	{
		log.debug("finding TUser instance by example");
		try
		{//ͨ���û���Ϣ �����û��б�
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
		log.debug("finding TUser instance with property: " + propertyName
				+ ", value: " + value);
		try
		{//ͨ���������� �� ֵ �������� �б�
			String queryString = "from TUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}
	//ͨ����¼�� ��ѯ�û���Ϣ
	public List findByLoginname(Object loginname)
	{
		return findByProperty(LOGINNAME, loginname);
	}
	//ͨ������ ��ѯ�û���Ϣ
	public List findByLoginpw(Object loginpw)
	{
		return findByProperty(LOGINPW, loginpw);
	}
	//ͨ������ ��ѯ�û���Ϣ
	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}
	//ͨ���Ա� ��ѯ�û���Ϣ
	public List findBySex(Object sex)
	{
		return findByProperty(SEX, sex);
	}
	//ͨ������ ��ѯ�û���Ϣ
	public List findByAge(Object age)
	{
		return findByProperty(AGE, age);
	}
	//ͨ����ַ ��ѯ�û���Ϣ
	public List findByAddress(Object address)
	{
		return findByProperty(ADDRESS, address);
	}
	//ͨ���绰 ��ѯ�û���Ϣ
	public List findByTel(Object tel)
	{
		return findByProperty(TEL, tel);
	}
	//ͨ��email��ѯ�û���Ϣ
	public List findByEmail(Object email)
	{
		return findByProperty(EMAIL, email);
	}
	//ͨ��qq ��ѯ�û���Ϣ
	public List findByQq(Object qq)
	{
		return findByProperty(QQ, qq);
	}
	//ͨ������ ��ѯ�û���Ϣ
	public List findByType(Object type)
	{
		return findByProperty(TYPE, type);
	}
	//ͨ��del ��ѯ�û���Ϣ
	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}
	//��ѯ�����û���Ϣ
	public List findAll()
	{
		log.debug("finding all TUser instances");
		try
		{//��ѯ�����û���Ϣ
			String queryString = "from TUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}
	//�޸��û���Ϣ
	public TUser merge(TUser detachedInstance)
	{
		log.debug("merging TUser instance");
		try
		{//�޸��û���Ϣ
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
	//��� ���� �޸��û���Ϣ
	public void attachDirty(TUser instance)
	{
		log.debug("attaching dirty TUser instance");
		try
		{//��� ���� �޸��û���Ϣ
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}
	//��ס�û�����
	public void attachClean(TUser instance)
	{
		log.debug("attaching clean TUser instance");
		try
		{//��ס�û�����
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