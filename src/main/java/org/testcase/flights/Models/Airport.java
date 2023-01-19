package org.testcase.flights.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private String location;
    private String code;
    private String zoneId;

    public Airport(int id, String name, String location, String code, String zoneId) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.code = code;
        this.zoneId = zoneId;
    }

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZone(String zoneId) {
        this.zoneId = zoneId;
    }
}
