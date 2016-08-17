package com.intelligentCommunity.dao;

import java.util.List;

import com.intelligentCommunity.pojo.House;



public interface HouseDao {

	List<House> findAllHouse();

	void saveOrUpdate(House house);

	House findHouseById(int houseId);

}

