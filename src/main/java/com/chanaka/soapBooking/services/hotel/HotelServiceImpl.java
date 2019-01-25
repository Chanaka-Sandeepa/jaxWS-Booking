package com.chanaka.soapBooking.services.hotel;

import java.util.List;
import java.util.ArrayList;

import com.chanaka.soapBooking.api.hotel.InHotel;
import com.chanaka.soapBooking.api.hotel.OutHotel;
import com.chanaka.soapBooking.dao.hotel.HotelDAO;
import com.chanaka.soapBooking.services.BusinessException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chanaka.soapBooking.model.Hotel;


@Service("HotelService")
public class HotelServiceImpl implements HotelService {

    private static final Log logger = LogFactory.getLog(HotelServiceImpl.class);
    @Autowired
    private HotelDAO hotelDAO;

    private String nomService="HotelService";
    private BusinessException e;


    public boolean addHotel(InHotel hotel) throws BusinessException {
        String nomMethode ="addHotel";
        if(!IsEmpty(hotel)){
            if(hotelDAO.addHotel(getHotelFromInOut(hotel))){
                return true;
            }
            e = creerBusinessException("01", nomService+"."+nomMethode+ " : Hotel save failled");
        } else {
            e = creerBusinessException("02", nomService+"."+nomMethode+ " : Hotel cannot be empty or price must be higher than 0.0");
        }
        throw e;
    }

    public boolean deleteHotel(InHotel hotel) throws BusinessException {
        String nomMethode ="deleteHotel";
        BusinessException e;
        if(!IsEmpty(hotel)){
            if(hotelDAO.deleteHotel(getHotelFromInOut(hotel))){
                return true;
            }
            e = creerBusinessException("01", nomService+"."+nomMethode+ " : Hotel delete failled");
        } else {
            e = creerBusinessException("02", nomService+"."+nomMethode+ " : Hotel cannot be empty or price must be higher than 0.0");
        }
        throw e;
    }

    public boolean updateHotel(InHotel hotel) throws BusinessException {
        String nomMethode ="updateHotel";
        BusinessException e;
        if(!IsEmpty(hotel)){
            if(hotelDAO.updateHotel(getHotelFromInOut(hotel))){
                return true;
            }
            e = creerBusinessException("01", nomService+"."+nomMethode+ " : Hotel update failled");
        } else {
            e = creerBusinessException("02", nomService+"."+nomMethode+ " : Hotel cannot be empty or price must be higher than 0.0");
        }
        throw e;
    }

    public List<OutHotel> searchHotel(String hotelName) throws BusinessException {
        String nomMethode ="searchHotel";
        BusinessException e;
        if(!"".equals(hotelName)){
            return getOutlist(hotelDAO.searchHotel(hotelName));
        } else {
            e = creerBusinessException("02", nomService+"."+nomMethode+ " : Hotel name cannot be empty");
        }
        throw e;
    }

    public OutHotel getHotelById(int id) throws BusinessException {
        String nomMethode ="getHotelById";
        BusinessException e;
        if( id > 0){
            return getOutFromHotel(hotelDAO.getHotelById(id));
        } else {
            e = creerBusinessException("02", nomService+"."+nomMethode+ " : Hotel id cannot be empty or id must be higher than 0");
        }
        throw e;
    }

//    public List<OutHotel> getAllHotelByPrice(double price) throws BusinessException {
//        String nomMethode ="getAllHotelByPrice";
//        BusinessException e;
//        if( price > 0.0 ){
//            return getOutlist(hotelDAO.getAllHotelByPrice(price));
//        } else {
//            e = creerBusinessException("02", nomService+"."+nomMethode+ " : Hotel price cannot be empty or price must be higher than 0.0");
//        }
//        throw e;
//    }


    private boolean IsEmpty(InHotel h){
        if(h != null) {
            if(!"".equals(h.getName())) {
                return false;
            }
        }
        return true;
    }
    private BusinessException creerBusinessException(String code, String message) {
        BusinessException e = new BusinessException();
        e.setCode(code);
        e.setMessage(message);
        return e;
    }

    private List<OutHotel> getOutlist(List<Hotel> hotelList){
        List<OutHotel> outList = new ArrayList<OutHotel>();
        for(Hotel h: hotelList){
            outList.add(getOutFromHotel(h));
        }
        return outList;
    }

    private Hotel getHotelFromInOut(InHotel inout){
        Hotel h = new Hotel();
        h.setId(inout.getId());
        h.setName(inout.getName());
        h.setAddress(inout.getAddress());
        h.setCity(inout.getCity());
        logger.info("Hotel : getHotelFromInOut " + h.toString());
        return h;

    }

    private OutHotel getOutFromHotel(Hotel hotel){
        OutHotel h = new OutHotel();
        h.setId(hotel.getId());
        h.setName(hotel.getName());
        h.setAddress(hotel.getAddress());
        h.setCity(hotel.getCity());
        logger.info("Hotel : getOutFromHotel " + h.toString());
        return h;

    }

}
