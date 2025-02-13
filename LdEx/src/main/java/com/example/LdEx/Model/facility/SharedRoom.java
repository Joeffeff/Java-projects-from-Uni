package com.example.LdEx.Model.facility;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("SHARED")
public class SharedRoom extends Room {
    protected String type;
    public SharedRoom(long id, String roomNumber, double area, int floor, String type){
        super(id,roomNumber,area,floor);
        this.type=type;
    }
}
