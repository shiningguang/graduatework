package com.intelligentCommunity.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.intelligentCommunity.dao.BaseDao;

@SuppressWarnings("unchecked")
@Transactional
public class BaseDaoImpl<T> implements BaseDao<T>{

	@Inject
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	private Class<?> clazz;
	
	public BaseDaoImpl() {
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<?>) parameterizedType.getActualTypeArguments()[0];
	}
	

	public void save(T entity) {
		getSession().saveOrUpdate(entity);
	}


	public T findById(Integer id) {
		return (T)getSession().get(clazz, id);
	}
	
	public T findById(Long id) {
		return (T)getSession().get(clazz, id);
	}
	
	public void del(Integer id) {
		getSession().delete(findById(id));
	}
	
	public List<T> findAll() {
		Criteria c = getSession().createCriteria(clazz);
		c.addOrder(Order.desc("id"));
		return c.list();
	}
	
	/**
	 * 根据属性名称查询单一对象
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public T findObjectByProperty(String propertyName,Object value) {
		Criteria c = getSession().createCriteria(clazz);
		c.add(Restrictions.eq(propertyName, value));
		return (T) c.uniqueResult();
	}
	/**
	 * 根据属性名称查询对象集合
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<T> findListLikeByProperty(String propertyName,Object value) {
		Criteria c = getSession().createCriteria(clazz);
		c.add(Restrictions.like(propertyName, value.toString(),MatchMode.ANYWHERE));
		return c.list();
	}
	
	/**
	 * 根据属性名称查询集合对象
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<T> findListByProperty(String propertyName,Object value) {
		Criteria c = getSession().createCriteria(clazz);
		c.add(Restrictions.eq(propertyName, value));
		return c.list();
	}
	
	
}

