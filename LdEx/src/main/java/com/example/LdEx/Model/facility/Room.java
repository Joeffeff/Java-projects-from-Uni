package com.example.LdEx.Model.facility;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  // or JOINED, TABLE_PER_CLASS depending on your design
@DiscriminatorColumn(name = "room_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected double area;
    protected int floor;
    protected String roomNumber;
    public Room(){}
    public Room(long id,String roomNr, double area, int floor){ this.id = id; this.roomNumber=roomNr; this.area = area; this.floor=floor;}
    public long getId(){return this.id;}
    public void setId(long id){this.id=id;}
    public String getRoomNumber(){return this.roomNumber;}
    public void setRoomNumber(String roomNr){this.roomNumber = roomNr;}

    public double getArea() {
        return this.area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return this.floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
