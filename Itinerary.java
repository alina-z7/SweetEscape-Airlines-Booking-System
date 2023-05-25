import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Itinerary {
    private Flight bookedFlight;
    private Seat assignedSeat;
    private Meal chosenMeal;
    private Entertainment entPackage;
    private LocalDateTime today;
    private Map<Passenger, Seat> seatMap;
    private int reservationNumber;
    private Payment price;
    private Passenger booker;
    private int terminal;

    public Itinerary(Flight f, Seat s, Meal m, Passenger p, Payment price) {
        // stores the chosen trip information and determines terminal upon flight class
        Random reservationNumberGenerator = new Random();
        reservationNumber = reservationNumberGenerator.nextInt(10000, 99999);
        Random terminalGenerator = new Random();
        seatMap = new HashMap<>();
        today = LocalDateTime.now();
        entPackage = new Entertainment(f);
        terminal = terminalGenerator.nextInt(1, 5);
        bookedFlight = f;
        this.price = price;
        assignedSeat = s;
        chosenMeal = m;
        booker = p;
    }
    public void assignSeat(Passenger p, Seat s) {
        // assigns the passenger to a seat in the seatMap
        seatMap.put(p, s);
    }
    public boolean makeReservation() {
        //this checks whether the user has been assigned a seat and meal in the flight
        return chosenMeal.getBreakfast() != null || chosenMeal.getLunch()  != null|| chosenMeal.getDinner() != null || chosenMeal.getDessert() != null || seatMap.get(booker) != null;
    }

    public String toString() {
        //this is where the boarding pass will be printed with all the flight details, reservationNumber, created date,
        // passenger contact info, meal, and airline info
        String ticket = "";
        for (int i = 0; i < 30; i++) {
            ticket += "-";
        }
        return ticket + "\n" +
                bookedFlight.toString() + "\t" + booker.getName() + " \t" + today.toLocalDate() + "\n"
                + entPackage.toString() + " " + assignedSeat.toString() +  "  " + price.toString() + " " + chosenMeal.toString() + " \n"
                + " Terminal: " + terminal;
    }
}
