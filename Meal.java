import java.util.LinkedList;
import java.util.List;

public class Meal {
    String breakfast;
    String lunch;
    String dinner;
    String dessert;
    LinkedList<String> availableOptions;
    public Meal(String breakfast, String lunch, String dinner, String dessert, Flight f) {
    // checks the constrcted meal according to the flight class
        if (f.getFlightClass().equals("E")) {
            availableOptions = new LinkedList<>(List.of("oatmeal and assortment of fruits", "cereal and a smoothie",
                    "Soup and Salad", "Grilled Cheese and Fries", "Chilli", "Lasagna", "Stroopwaffle", "Jello"));
            if (!(availableOptions.contains(breakfast) || availableOptions.contains(lunch) || availableOptions.contains(dinner) ||
                    availableOptions.contains(dessert))) {
                throw new IllegalArgumentException("Sorry, this item is not available for this flight");
            }
        } else if (f.getFlightClass().equals("B")) {
            availableOptions = new LinkedList<>(List.of("pancakes and hash-browns", "eggs and French toast", "Spaghetti and Meatballs",
                    "Chicken and Quinoa", "Risotto", "Ramen", "Red velvet cupcakes", "Chocolate covered strawberries"));
            if (!(availableOptions.contains(breakfast) || availableOptions.contains(lunch) || availableOptions.contains(dinner) ||
                    availableOptions.contains(dessert))) {
                throw new IllegalArgumentException("Sorry, this item is not available for this flight");
            }
        } else {
            availableOptions = new LinkedList<>(List.of("devilled eggs and croissants", "Cinnamon Rolls and grapes", "BLT sandwich",
                    "Philly Cheese Steak sandwich", "Chicken Club sandwich", "Burger", "Black Bean Burger with Sweet Potato Fries",
                    "Falafel and Rice", "Smoked Salmon and Spiced Linguini", "Strawberry Cheesecake", "Chocolate Lava Cake"));
            if (!(availableOptions.contains(breakfast) || availableOptions.contains(lunch) || availableOptions.contains(dinner) ||
                    availableOptions.contains(dessert))) {
                throw new IllegalArgumentException("Sorry, this item is not available for this flight");
            }
        }
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.dessert = dessert;

    }
    public String getBreakfast() {
        // returns the decided breakfast option
        return breakfast;
    }
    public String getLunch() {
        // returns the decided lunch option
        return lunch;
    }
    public String getDinner() {
        // returns the decided dinner option
        return dinner;
    }
    public String getDessert() {
        // returns the decided dessert option
        return dessert;
    }
    public String toString() {
        return "\nBreakfast: " + breakfast + " \nLunch: " + lunch + " \nDinner: " + dinner + " \nDessert: " + dessert;
    }
}