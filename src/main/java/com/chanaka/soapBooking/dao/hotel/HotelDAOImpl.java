package com.chanaka.soapBooking.dao.hotel;

import com.chanaka.soapBooking.model.Hotel;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.logging.Log;

import java.util.List;

@Repository
public class HotelDAOImpl implements HotelDAO {

    //private static final Logger logger = LoggerFactory.getLogger(HotelDAOImpl.class);
    private static final Log logger = LogFactory.getLog(HotelDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public boolean addHotel(Hotel hotel){
        Session session = this.sessionFactory.getCurrentSession();
        try {
            session.save(hotel);
            logger.info("Hotel saved successfully, Hotel Details=" + hotel);
        } catch(Exception e){
            logger.error("addHotel Exception: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Transactional
    public boolean deleteHotel(Hotel hotel){
        Session session = this.sessionFactory.getCurrentSession();
        Hotel p = (Hotel) session.load(Hotel.class, new Integer(hotel.getId()));
        if( p != null ){
            try{
                session.delete(hotel);
                logger.info("Hotel deleted successfully, Hotel Details=" + hotel);
            }catch(Exception e){
                logger.error("deleteHotel Exception: " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    @Transactional
    public boolean updateHotel(Hotel hotel){
        Session session = this.sessionFactory.getCurrentSession();
        try{
            session.update(hotel);
            logger.info("Hotel updated successfully, Hotel Details=" + hotel);
        }catch(Exception e){
            logger.error("updateHotel Exception: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Transactional
    public List<Hotel> searchHotel(String hotelName){
        List<Hotel> hotelList = null;
        Session session = this.sessionFactory.getCurrentSession();
        try {
            hotelList = session.createQuery("FROM Hotel h WHERE h.name = '" + hotelName + "'").list();
            for (Hotel h : hotelList) {
                logger.info("Hotel List searchHotel ::Hotel founded successfully, Hotel Details=" + h);
            }
        } catch (Exception e){
            logger.error("searchHotel Exception: " + e.getMessage());
        }
        return hotelList;
    }

    @Transactional
    public Hotel getHotelById(int id){
        Hotel p = null;
        Session session = this.sessionFactory.getCurrentSession();
        try {
            p = (Hotel) session.load(Hotel.class, new Integer(id));
            logger.info("Hotel loaded successfully, Hotel Details=" + p);
        } catch(Exception e){
            logger.error("getHotelById Exception: " + e.getMessage());
        }
        return p;
    }

    @Transactional
    public List<Hotel> getAllHotelByPrice(double price){
        List<Hotel> hotelList = null;
        Session session = this.sessionFactory.getCurrentSession();
        try {
            hotelList = session.createQuery("FROM Hotel P WHERE P.price =" + price).list();
            for (Hotel p : hotelList) {
                logger.info("Hotel List getAllHotelByPrice :Hotel founded successfully, Hotel Details=" + p);
            }
        }catch (Exception e){
            logger.error("getAllHotelByPrice Exception: " + e.getMessage());
        }
        return hotelList;
    }

}
