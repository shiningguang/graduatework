package com.intelligentCommunity.service;

import java.util.List;

import com.intelligentCommunity.pojo.Notice;

public interface NoticeService {

	List<Notice> findAllNotice();

	void save(Notice notice);

}

