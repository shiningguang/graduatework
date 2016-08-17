package com.intelligentCommunity.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intelligentCommunity.dao.NoticeDao;
import com.intelligentCommunity.pojo.Notice;

@Repository(value="NoticeDao")
@Transactional
public class NoticeDaoImpl extends BaseDaoImpl<Notice> implements NoticeDao{

	
	
}

