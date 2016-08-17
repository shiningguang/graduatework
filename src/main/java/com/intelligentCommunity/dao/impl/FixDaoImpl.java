package com.intelligentCommunity.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intelligentCommunity.dao.FixDao;
import com.intelligentCommunity.pojo.Account;
import com.intelligentCommunity.pojo.Fix;
import com.intelligentCommunity.pojo.Role;

@SuppressWarnings("unchecked")
@Repository(value="FixDao")
@Transactional
public class FixDaoImpl extends BaseDaoImpl<Fix> implements FixDao{

	
	public List<Fix> findByAccount(Account account) {
		String sql = "select id from fix where f_a_id = ? order by createtime desc ";
		SQLQuery query = getSession().createSQLQuery(sql);
		if (account != null && account.getId()>0 ) {
			query.setParameter(0, account.getId());
			return query.list();
		}
		return null;
	}

	
	public List<Fix> findByAccountAndStatus(Account account, boolean status) {
		int s = status ? 1:0;
		StringBuffer hql = new StringBuffer();
		hql.append("select id,name,isOk,advice,reply,status,f_a_id,createtime from fix where");
		if (account != null && account.getId()>0 ) {
			hql.append(" f_a_id = ? ");
			hql.append(" and status = ? ");
		}else {
			hql.append(" status = ? ");
		}
		hql.append(" order by createtime desc ");
		SQLQuery query = getSession().createSQLQuery(hql.toString());
		if (account != null && account.getId()>0 ) {
			query.setParameter(0, account.getId());
			query.setParameter(1, s);
		}else {
			query.setParameter(0, s);
		}
		
		return query.list();
	}


	public Fix findById(int fixId) {
		return findObjectByProperty("id", fixId);
	}


	public List<Fix> findByStatus(Account account, boolean status) {
		int s = status ? 1:0;
		StringBuffer hql = new StringBuffer();
		hql.append("select id,name,isOk,advice,reply,status,f_a_id,createtime from fix where status = ? ");
		SQLQuery query = getSession().createSQLQuery(hql.toString());
		query.setParameter(0, s);
		return query.list();
	}

}

