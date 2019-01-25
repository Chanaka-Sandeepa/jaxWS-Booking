package com.chanaka.soapBooking.services.hotel;

import com.chanaka.soapBooking.api.hotel.InHotel;
import com.chanaka.soapBooking.api.hotel.OutHotel;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.chanaka.soapBooking.services.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@WebService(serviceName="HotelService", targetNamespace="http://www.chanaka.hotel/service")
public class HotelServiceEndpoint implements HotelService {

    @Autowired
    private HotelServiceImpl service;

    @WebMethod
    public boolean addHotel(InHotel hotel) throws BusinessException {
        return service.addHotel(hotel);
    }

    @WebMethod
    public boolean deleteHotel(InHotel hotel) throws BusinessException {
        return service.deleteHotel(hotel);
    }

    @WebMethod
    public boolean updateHotel(InHotel hotel) throws BusinessException {
        return service.updateHotel(hotel);
    }

    @WebMethod
    public List<OutHotel> searchHotel(String hotelName) throws BusinessException {
        return service.searchHotel(hotelName);
    }

    @WebMethod
    public OutHotel getHotelById(int id) throws BusinessException {
        return service.getHotelById(id);
    }

//    @WebMethod
//    public List<OutHotel> getAllHotelByPrice(double price) throws BusinessException {
//        return service.getAllHotelByPrice(price);
//    }

}
