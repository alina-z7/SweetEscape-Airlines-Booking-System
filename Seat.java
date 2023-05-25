import java.util.Random;

public class Seat {
    int seatNumber;
    String typeOfSeat;
    public Seat(Flight f, String typeOfSeat) {
        // according to flight class, seat will be assigned by preference or availability
        Random seatNumberGenerator = new Random();
        this.typeOfSeat = typeOfSeat;
        if (f.getFlightClass().equals("E")) {
            seatNumber = seatNumberGenerator.nextInt(1, 250);
        } else if (f.getFlightClass().equals("B")) {
            seatNumber = seatNumberGenerator.nextInt(1, 25);
        } else {
            seatNumber = seatNumberGenerator.nextInt(1, 15);
        }
    }


    public String toString() {
        // returns the seatNumber for itinerary
        return "Seat: " + seatNumber + typeOfSeat;
    }
}