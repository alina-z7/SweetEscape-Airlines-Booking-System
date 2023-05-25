public class Entertainment {
    private int movies;
    private int games;
    private boolean shopping;
    private boolean wifi;
    private String entertainmentPackage;
    public Entertainment(Flight f) {
        // assigns number of movies and games, determines shopping and free wi-fi availability, according to flight class
        if (f.getFlightClass().equals("E")) {
            movies = 50;
            games = 20;
            shopping = false;
            wifi = false;
            entertainmentPackage = "Basic";
        } if (f.getFlightClass().equals("B")) {
            movies = 150;
            games = 75;
            shopping = false;
            wifi = true;
            entertainmentPackage = "Premium";
        } else {
            movies = 200;
            games = 100;
            shopping = true;
            wifi = true;
            entertainmentPackage = "Platinum";
        }
    }
    public boolean isShoppingIncluded() {
        return shopping;
    }
    public boolean isWifiFree() {
        return wifi;
    }
    public String toString() {
        // returns entertainment benefits in itinerary
        return "Entertainment Package: " + entertainmentPackage + " \n"
                + movies + " movies, " + games + " games, \n"
                + "Shopping included: " + shopping + " Free Wifi: " + wifi;
    }

}
