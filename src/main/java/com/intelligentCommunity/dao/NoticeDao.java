package com.intelligentCommunity.dao;

import java.util.List;

import com.intelligentCommunity.pojo.Notice;

public interface NoticeDao {

	List<Notice> findAll();

	void save(Notice notice);

}

