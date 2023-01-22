package org.testcase.flights.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "flight")

public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", origin=" + origin +
                ", destination=" + destination +
                ", duration=" + duration +
                '}';
    }

    public Flight(String flightNumber, Airport origin, Airport destination, long duration) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
    }

    @Column(name = "flightnumber")
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "origin_code", referencedColumnName = "code")
    private Airport origin;

    @ManyToOne
    @JoinColumn(name = "destination_code", referencedColumnName = "code")
    private Airport destination;
    private long duration;

    public Flight() {
    }

    public Flight(int id, String flightNumber, Airport origin, Airport destination, long duration) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
