package com.example.LdEx.Model.facility;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("DORM")
public class DormRoom extends Room {
    protected int bedAmount;
    public DormRoom(){}
    private Boolean available;
    public DormRoom(long id, String roomNumber, double area, int floor, int bedNr, Boolean available){
        super(id,roomNumber,area,floor);
        this.available=available;
        this.bedAmount=bedNr;
    }
    public int getBeds(){return this.bedAmount;}
    public void setBeds(int beds){this.bedAmount = beds;}
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}
