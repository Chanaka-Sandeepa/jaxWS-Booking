package com.chanaka.soapBooking.model;

import javax.persistence.*;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author chanakaw
 *
 */
@Entity
@Table(name="CW_ROOM")
public class Room {

    @EmbeddedId
    private RoomID roomID;

    @ManyToOne
    @JoinColumn(name="CONTRACT_ID")
    @MapsId("contractID")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name="ROOM_TYPE_ID")
    @MapsId("roomTypeID")
    private RoomType roomType;

    @Column(name="NO_OF_ROOMS")
    private int noOfRooms;

    @Column(name="PRICE")
    private double price;

    public RoomID getRoomID() {
        return roomID;
    }

    public void setRoomID(RoomID roomID) {
        this.roomID = roomID;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



}
