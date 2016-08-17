package com.intelligentCommunity.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intelligentCommunity.dao.NoticeDao;
import com.intelligentCommunity.pojo.Notice;
import com.intelligentCommunity.service.NoticeService;

@Service(value="NoticeService")
@Transactional
public class NoticeServiceImpl implements NoticeService {

	@Inject
	private NoticeDao noticeDao;
	
	public List<Notice> findAllNotice() {
		return noticeDao.findAll();
	}

	public void save(Notice notice) {
		noticeDao.save(notice);
	}

}

