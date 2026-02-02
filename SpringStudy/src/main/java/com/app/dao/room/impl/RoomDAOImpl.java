package com.app.dao.room.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;


// DB 연동 -> DAO 
// 외부 API -> Repository


@Repository
public class RoomDAOImpl implements RoomDAO {

	@Override
	public List<Room> findRoomList() {
		
		// DB 에 연동 -> room 테이블 데이터조회 -> List
		
		return null;
	}

}
