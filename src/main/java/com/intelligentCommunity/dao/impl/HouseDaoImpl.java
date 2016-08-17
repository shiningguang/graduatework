package com.intelligentCommunity.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intelligentCommunity.dao.HouseDao;
import com.intelligentCommunity.pojo.House;


@Repository(value="HouseDao")
@Transactional
public class HouseDaoImpl extends BaseDaoImpl<House> implements HouseDao {

	public List<House> findAllHouse() {
		return findAll();
	}

	public void saveOrUpdate(House house) {
		save(house);
	}

	public House findHouseById(int houseId) {
		return findById(houseId);
	}

}

