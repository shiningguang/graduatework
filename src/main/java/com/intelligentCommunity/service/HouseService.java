package com.intelligentCommunity.service;

import java.util.List;

import com.intelligentCommunity.pojo.House;


public interface HouseService {

	List<House> findAllHouse();

	void saveOrUpdate(House house);

	House findHouseById(int houseId);

}

