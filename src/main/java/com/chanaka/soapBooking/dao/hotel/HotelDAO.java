package com.chanaka.soapBooking.dao.hotel;

import com.chanaka.soapBooking.model.Hotel;

import java.util.List;

public interface HotelDAO {

    public boolean addHotel(Hotel hotel);

    public boolean deleteHotel(Hotel hotel);

    public boolean updateHotel(Hotel hotel);

    public List<Hotel> searchHotel(String hotelName);

    public Hotel getHotelById(int id);

//    public List<Hotel> getAllHotelByPrice(double price);
}