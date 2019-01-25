package com.chanaka.soapBooking.services.hotel;

import com.chanaka.soapBooking.api.hotel.InHotel;
import com.chanaka.soapBooking.api.hotel.OutHotel;
import com.chanaka.soapBooking.services.BusinessException;

import java.util.List;
import javax.jws.WebParam;



public interface HotelService {


    public boolean addHotel(@WebParam(name="hotel") InHotel hotel) throws BusinessException;

    public boolean deleteHotel(@WebParam(name="hotel") InHotel hotel) throws BusinessException;

    public boolean updateHotel(@WebParam(name="hotel") InHotel hotel) throws BusinessException;

    public List<OutHotel> searchHotel(@WebParam(name="hotelName") String hotelName) throws BusinessException;

    public OutHotel getHotelById(@WebParam(name="id") int id) throws BusinessException;

//    public List<OutHotel> getAllHotelByPrice(@WebParam(name="price") double price) throws BusinessException;
}
