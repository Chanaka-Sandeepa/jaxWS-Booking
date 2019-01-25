package com.chanaka.soapBooking.api.hotel;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "OutHotel")
public class OutHotel {

    @XmlElement(name = "id", required = false)
    private int id;

    @XmlElement(name = "name", required = false)
    private String name;

    @XmlElement(name = "address", required = false)
    private String address;

    @XmlElement(name = "city", required = false)
    private String city;

    @XmlElement(name = "country", required = false)
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", address=" + address;
    }
}
