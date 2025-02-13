package com.example.LdEx.Repository.Service;

import com.example.LdEx.Model.facility.DormRoom;

import java.util.List;

public interface RoomService {
    List<DormRoom> getAllRooms();
    List<DormRoom> searchByRoomNumber(String roomNumber);
    DormRoom getRoomById(Long id);
    void saveRoom(DormRoom room);
    void deleteRoom(Long id);
    List<DormRoom> getAvailableRooms();
    List<DormRoom> findAllSortedByArea();
}
