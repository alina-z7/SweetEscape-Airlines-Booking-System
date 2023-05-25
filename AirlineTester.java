import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AirlineTester {

    public static Flight[] flights;
    public static Flight bookedFlight;
    public static Meal bookedMeal;
    public static Seat bookedSeat;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        flights = addFlights();
        System.out.println("\t\t\t\t~*~|Welcome to SweetEscape Airlines|~*~\n" +
                "\t\t\t~~We hope wherever you go, you remain safe and comfortable.");
        System.out.println();
        System.out.println("\t~~ To start your travel planning, please insert your personal information below:");
        System.out.print("\tFull Name: ");
        String name = console.nextLine();
        System.out.print("\tAge: ");
        int age = console.nextInt();
        System.out.print("\tGender: ");
        String gender = console.next();
        System.out.print("\tDate of Birth: \n");
        System.out.print("\t\t-Year: ");
        int birthYear = console.nextInt();
        System.out.print("\t\t-Month: ");
        int birthMonth = console.nextInt();
        System.out.print("\t\t-Day: ");
        int birthDay = console.nextInt();
        Passenger booker = new Passenger(name, age, LocalDate.of(birthYear, birthMonth, birthDay), gender);
        passengerContactInfo(console, booker);
        membershipCheck(console, booker);
        passportDetails(console, booker);
        flightBooking(console, booker);
        mealBooking(console, booker);
        seatBooking(console);
        printItinerary(console, booker);
    }

    public static void passengerContactInfo(Scanner console, Passenger booker) {
        System.out.print("\tPrimary Phone Number: ");
        String phoneNumber = console.next();
        System.out.print("\tPersonal Email: ");
        String email = console.next();
        System.out.println();
        booker.setContactInfo(email, phoneNumber);
    }

    public static void membershipCheck(Scanner console, Passenger booker) {
        MemberList mL = new MemberList(booker);
        if(mL.getMembershipStatus()) {
            System.out.print("\tOur records indicate you are already a member. Please enter the membership code.");
            long memberCode = console.nextLong();
            mL.checkMemberCode(memberCode);
        } else {
            System.out.print("\tYou have successfully signed up as a member. Here is your member code: " + booker.getCode() + "\n" +
                    "Below is a file that gives you new member information.");
            System.out.println(booker.getNewMemberInfo());
            System.out.println();
        }
    }
    public static void passportDetails(Scanner console, Passenger booker) {
        System.out.println("\t~~ Now, please confirm you are valid to travel. Provide passport details below:");
        System.out.print("\tPassport Number: ");
        long passportNum = console.nextLong();
        System.out.print("\tPassport Expiry Date: \n");
        System.out.print("\t\t-Year: ");
        int expYear = console.nextInt();
        System.out.print("\t\t-Month: ");
        int expMonth = console.nextInt();
        System.out.print("\t\t-Day: ");
        int expDay = console.nextInt();
        System.out.println();
        if (booker.checkPassport(passportNum, LocalDate.of(expYear, expMonth, expDay))) {
            throw new IllegalArgumentException("Sorry, you are ineligible to fly at this time. Please renew your passport at the embassy.");
        }

    }

    public static void flightBooking(Scanner console, Passenger booker) {
        System.out.println("\t~~ Time to search for SweetEscape Flight Schedule. Insert airport details below:");
        System.out.print("Here is a file of airport codes and their location (city, state): \n");
        System.out.println();
        System.out.println(booker.getAirportCodes());
        System.out.print("\tAirport origin: ");
        String origin = console.next();
        System.out.print("\tAirport destination: ");
        String dest = console.next();
        System.out.println();
        System.out.print("Please choose a flight by number (ex. 0-10): \n");
        System.out.println(findFlights(new Airport(origin), new Airport(dest)) + "\n");
        System.out.print("\tFlight number: ");
        int number = console.nextInt();
        for (int i = 0; i < flights.length; i++) {
            if (number == i) {
                bookedFlight = flights[i];
            }
        }
        System.out.print("\tEnter number of bags on the flight: ");
        int bagCount = console.nextInt();
        bookedFlight.setBaggageAllowance(bagCount);
        System.out.println();
    }

    public static void mealBooking(Scanner console, Passenger booker) {
        System.out.println("\t~~ Please choose a meal. Here is the flight menu: \n");
        System.out.print(booker.getMenu());
        System.out.println();
        System.out.print("\tBreakfast: ");
        String breakfast = console.next();
        System.out.print("\tLunch: ");
        String lunch = console.next();
        System.out.print("\tDinner: ");
        String dinner = console.next();
        System.out.print("\tDessert: ");
        String dessert = console.next();
        bookedMeal = new Meal(breakfast, lunch, dinner, dessert, bookedFlight);
        System.out.println();
    }

    public static void seatBooking(Scanner console) {
        System.out.println("\t~~ Now for seat preferences. Please select a seat option: \n");
        System.out.print("\tWindow Side A, \n\tWindow Side B, \n\tAisle \n\n");
        System.out.print("Seat Type: ");
        String seatType = console.next();
        bookedSeat = new Seat(bookedFlight, seatType);
        System.out.println();
    }

    public static void printItinerary(Scanner console, Passenger booker) {
        System.out.println("\t~~ Please provide your payment information below:");
        System.out.print("\tCard number: ");
        String cardNum = console.next();
        System.out.print("\tExpiry Date: \n");
        System.out.print("\t\t-Year: ");
        int expYear = console.nextInt();
        System.out.print("\t\t-Month: ");
        int expMonth = console.nextInt();
        System.out.print("\t\t-Day: ");
        int expDay = console.nextInt();
        System.out.print("\tCCV: ");
        int ccvNum = console.nextInt();
        Payment info = new Payment(cardNum, booker.getName(), ccvNum, LocalDate.of(expYear, expMonth, expDay));
        System.out.print("\tBilling Address: ");
        String bA = console.nextLine();
        info.setBillingAddress(bA);
        info.identifyPlan(bookedFlight);
        System.out.println();
        System.out.println("""
                Thank you for booking with SweetEscape Airlines. Below is your boarding pass.\s
                Please keep this in a safe place. We hope you have a safe and sweet journey!
                """);
        Itinerary ticket = new Itinerary(bookedFlight, bookedSeat, bookedMeal, booker, info);
        ticket.assignSeat(booker, bookedSeat);
        if (ticket.makeReservation()) {
            System.out.println(ticket);
        } else {
            throw new IllegalArgumentException("Sorry, we were unable to book your flight with the details provided. Please try again.");
        }
    }

    public static List<Flight> findFlights(Airport origin, Airport dest) {
        LinkedList<Flight> listOfFlights = new LinkedList<>();
        for (Flight f : flights) {
            if (f.toString().contains(origin.getAirportCode()) && f.toString().contains(dest.getAirportCode())) {
                listOfFlights.add(f);
            }
        }
        return listOfFlights;
    }

    private static Flight[] addFlights() throws FileNotFoundException {
        Scanner console = new Scanner(new File("/Users/alizac/IdeaProjects/Data Structures I/src/" +
                "Final SweetEscape Airlines Flight Schedule"));
        Flight[] f = new Flight[456];
        int count = 0;
        while (console.hasNextLine()) {
            String origin = console.next();
            String dest = console.next();
            String flightClass = console.next();
            int dYear = console.nextInt();
            int dMonth = console.nextInt();
            int dDay = console.nextInt();
            int dHour = console.nextInt();
            int dMin = console.nextInt();
            int aYear = console.nextInt();
            int aMonth = console.nextInt();
            int aDay = console.nextInt();
            int aHour = console.nextInt();
            int aMin = console.nextInt();
            int flH = console.nextInt();
            int flM = console.nextInt();
            int gate = console.nextInt();
            f[count] = new Flight(new Airport(origin), new Airport(dest), flightClass,
                    LocalDateTime.of(dYear, dMonth, dDay, dHour, dMin), LocalDateTime.
                    of(aYear, aMonth, aDay, aHour, aMin), LocalTime.of(flH, flM), gate);
            count++;
        }
        return f;
    }


}
