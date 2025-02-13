package com.example.LdEx.Repository.Service;


import com.example.LdEx.Model.facility.DormRoom;
import com.example.LdEx.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired private RoomRepository roomRepository;

    @Override public List<DormRoom> getAllRooms(){
        return roomRepository.findAll();
    }

    @Override public DormRoom getRoomById(Long id){
        return roomRepository.findById(id).orElse(null);
    }

    @Override public void saveRoom(DormRoom room)
    {
        roomRepository.save(room);
    }

    @Override public void deleteRoom(Long id)
    {
        roomRepository.deleteById(id);
    }

    @Override
    public List<DormRoom> searchByRoomNumber(String roomNumber) {
        return roomRepository.findByRoomNumberContainingIgnoreCase(roomNumber); // Delegate to the repository
    }

    @Override
    public List<DormRoom> getAvailableRooms() {
        return roomRepository.findByAvailableTrue(); // Custom query to find available rooms
    }

    @Override
    public List<DormRoom> findAllSortedByArea() {
        return roomRepository.findAll(Sort.by(Sort.Order.asc("area")));
    }
}

