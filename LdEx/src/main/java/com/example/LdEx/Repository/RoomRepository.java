package com.example.LdEx.Repository;

import com.example.LdEx.Model.facility.DormRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<DormRoom, Long> {
    List<DormRoom> findByRoomNumberContainingIgnoreCase(String roomNumber);
    List<DormRoom> findByAvailableTrue();
}
