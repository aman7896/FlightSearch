package org.testcase.flights.Models;

import org.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Airport implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "code", unique = true)
    private String code;

    public Airport(JSONObject obj) {
        this.id = obj.getInt("id");
        this.code = obj.getString("code");
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }

    public Airport(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public Airport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
