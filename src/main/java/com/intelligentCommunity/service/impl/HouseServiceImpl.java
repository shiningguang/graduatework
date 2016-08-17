package com.intelligentCommunity.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intelligentCommunity.dao.HouseDao;
import com.intelligentCommunity.pojo.House;
import com.intelligentCommunity.service.HouseService;

@Service(value="HouseService")
@Transactional
public class HouseServiceImpl implements HouseService {

	@Inject
	private HouseDao houseDao;
	
	public List<House> findAllHouse() {
		return houseDao.findAllHouse();
	}

	public void saveOrUpdate(House house) {
		houseDao.saveOrUpdate(house);
	}

	public House findHouseById(int houseId) {
		return houseDao.findHouseById(houseId);
	}

	
	
}

