/**
 * Class Name : Flight
 * @author Madhushi
 * Purpose : To maintain information about a flight. The maintained information are
 *           the flight number, departure date,departure airport,
 *           destination airport, departure time, arrival time and the flight sections.
 */

package Classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Flight {
    public String flightNumber;
    public FlightDateTime flightDateTime;
    public FlightAirports flightAirports;

    // Constructor 01
    public Flight() {
        this.flightDateTime = new FlightDateTime();
        this.flightAirports = new FlightAirports();
    }

    public Flight(String flightNumber, FlightDateTime flightDateTime, FlightAirports flightAirports) {
        this.flightNumber = flightNumber;
        this.flightDateTime = flightDateTime;
        this.flightAirports = flightAirports;
    }

    public void setFlightNumber(String airlineID, String number) {
        if (airlineID.matches("[a-zA-Z]+$") && airlineID.length() == 2 && number.matches("[0-9 ]+$")) {
            this.flightNumber = airlineID + number;
        } else {
            System.out.println("Invalid Flight Number");
        }
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setDepartureDate(int day, int month, int year) {
        flightDateTime.setDepartureDate(day, month, year);
    }

    public String getDepartureDate() {
        return flightDateTime.getDepartureDate();
    }

    public void setDepartureAirport(String departureAirport) {
        flightAirports.setDepartureAirport(departureAirport);
    }

    public String getDepartureAirport() {
        return flightAirports.getDepartureAirport();
    }

    public void setDestinationAirport(String destinationAirport) {
        flightAirports.setDestinationAirport(destinationAirport);
    }

    public String getDestinationAirport() {
        return flightAirports.getDestinationAirport();
    }

    public void setDepartureTime(String departureTime) {
        flightDateTime.setTime(false, departureTime);
    }

    public String getDepartureTime() {
        return flightDateTime.getDepartureTime();
    }

    public void setArrivalTime(String arrivalTime) {
        flightDateTime.setTime(true, arrivalTime);
    }

    public String getArrivalTime() {
        return flightDateTime.getArrivalTime();
    }

    @Override
    public String toString() {
        return flightNumber + "," + flightDateTime.getDepartureDate() + "," + flightAirports.getDepartureAirport() + "," +
                flightAirports.getDestinationAirport() + "," + flightDateTime.getDepartureTime() + "," + flightDateTime.getArrivalTime();
    }

    // Inner class for FlightDateTime
    public class FlightDateTime {
        public String departureDate;
        public String departureTime;
        public String arrivalTime;

        public void setDepartureDate(int day, int month, int year) {
            SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");
            Calendar calendar1 = new GregorianCalendar(year, month - 1, day);
            this.departureDate = sdf.format(calendar1.getTime());
        }

        public void setTime(boolean isArrivalTime, String time) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm ");
            Calendar calendar1 = new GregorianCalendar(2016, 12, 5, Integer.parseInt(time.substring(0, 2)), Integer.parseInt(time.substring(3)));
            if (isArrivalTime)
                this.arrivalTime = sdf.format(calendar1.getTime());
            else
                this.departureTime = sdf.format(calendar1.getTime());
        }

        public String getDepartureDate() {
            return departureDate;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public String getArrivalTime() {
            return arrivalTime;
        }
    }

    // Inner class for FlightAirports
    public class FlightAirports {
        public String departureAirport;
        public String destinationAirport;

        public void setDepartureAirport(String departureAirport) {
            if (departureAirport.matches("[a-zA-Z]+$") && departureAirport.length() == 3) {
                this.departureAirport = departureAirport.toUpperCase();
            } else {
                System.out.println("Invalid Airport ID");
            }
        }

        public void setDestinationAirport(String destinationAirport) {
            if (destinationAirport.matches("[a-zA-Z]+$") && destinationAirport.length() == 3) {
                this.destinationAirport = destinationAirport.toUpperCase();
            } else {
                System.out.println("Invalid Airport ID");
            }
        }

        public String getDepartureAirport() {
            return departureAirport;
        }

        public String getDestinationAirport() {
            return destinationAirport;
        }
    }
}