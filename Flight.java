import java.time.LocalDateTime;
import java.time.LocalTime;

public class Flight {
    private LocalDateTime arrival;
    private LocalDateTime departure;
    private LocalTime flightLength;
    private int gateNumber;
    private Airport start;
    private Airport finish;
    private String flightClass;

    public Flight(Airport origin, Airport dest) {
        // stores the airport origin and airport destination of the flight
        start = origin;
        finish = dest;
    }

    public Flight(Airport origin, Airport dest, String flightCabin, LocalDateTime departureDate, LocalDateTime arrivalDate, LocalTime flightSpan, int gateNum) {
        // allows to construct new SweetEscape Flight Schedule in the system privately in the system; stores new flight information
        start = origin;
        finish = dest;
        arrival = arrivalDate;
        departure = departureDate;
        flightClass = flightCabin;
        flightLength = flightSpan;
        gateNumber = gateNum;
    }
    public Airport getOrigin() {
        // returns an airport origin code for AirlineConnection to check available flight routes
        return start;
    }
    public Airport getDestination() {
        // returns an airport origin code for AirlineConnection to check available flight routes
        return finish;
    }
    public void setBaggageAllowance(int baggage) {
        //sets the baggage allowance according to flightClass
        if (flightClass.equals("E") && baggage > 2) {
            throw new IllegalArgumentException("Sorry, you are only allowed 2 handbags in the Economy class.");
        } else if (flightClass.equals("B") && baggage > 4) {
            throw new IllegalArgumentException("Sorry, you are only allowed 2 bags & 2 handbags in the Business class.");
        } else if (flightClass.equals("F") && baggage > 6){
            throw new IllegalArgumentException("Sorry, you are only allowed 5 bags & 1 handbag in the First-Class class.");
        }

    }
    public String getFlightClass() {
        // returns the flight class so that meal, seat, and entertainment, can be determined
        return flightClass;
    }

    public String toString() {
        // returns flight information (origin, dest, arrival and departure time, etc.) on the console when the list of SweetEscape Flight Schedule is printed
      return start.getAirportCode() + " to " + finish.getAirportCode() + "\tCabin: " + flightClass
              + " \nDeparture: " + departure.toString() + " Arrival: " + arrival.toString()
              + " \nFlight Length: " + flightLength + " Gate: " + gateNumber + "\n";

    }
}