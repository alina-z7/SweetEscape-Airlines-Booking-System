import java.time.LocalDate;
public class Payment {
    private String cardNumber;
    private String address;
    private String nameOnCard;
    private int CCV;
    private LocalDate expiryDate;
    private String flightClass;
    public Payment(String cardNum, String name, int CCV, LocalDate expiryOnCard) {
        // stores the credit card info and sees if name matches booker name in main
        LocalDate today = LocalDate.now();
        if (CCV > 999 || expiryOnCard.isEqual(today) || expiryOnCard.isBefore(today) || cardNum.length() != 16) {
            throw new IllegalArgumentException("Had trouble processing card information. Please try again.");
        }
        cardNumber = cardNum;
        nameOnCard = name;
        this.CCV = CCV;
        expiryDate = expiryOnCard;
        flightClass = "";
    }

    public void identifyPlan(Flight f) {
        flightClass.equals(f.getFlightClass());
    }

    public void setBillingAddress(String fullAddress) {
        address = fullAddress;
    }

    public String toString() {
        String fare = "Fare: ";
        if (flightClass.equals("E")) {
            return fare + "$233.75";
        } else if (flightClass.equals("B")) {
            return fare + "$577.93";
        } else {
            return fare + "$989.34";
        }
    }

}
