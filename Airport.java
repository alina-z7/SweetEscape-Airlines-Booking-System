import java.util.LinkedList;
import java.util.List;

public class Airport {
    private final LinkedList<String> airportList;
    private final String airportCode;
    public Airport(String code) {
        // initializes a list of possible airport codes in LinkedList airCodeList from the airport codes list
        // if airCodeList does not contain @param - code, show error message for no SweetEscape Flight Schedule available
        airportList = new LinkedList<>(List.of("BHM", "MGM", "ANC", "JNU", "FLG", "TUS", "FSM", "TXK", "LAX", "SFO", "SAN", "COS", "DEN",
                "BDL", "HVN", "IGL", "MCO", "TLH", "ATL", "SAV", "HNL", "LIH", "BOI", "IDA", "MDW", "RFD", "SBN", "FWA", "DSM", "ALO", "ICT", "HYS",
                "CVG", "PAH", "SHV", "BTR", "PWM", "RKD", "BWI", "HGR", "BOS", "ACK", "FNT", "IMT", "MSP", "STC", "MEI", "TUP", "MCI", "SGF", "WYS",
                "GTF", "LNK", "OMA", "LAS", "RNO", "MHT", "ACY", "TTN", "ROW", "SAF", "ALB", "JFK", "HPN", "CLT", "ILM", "GFK", "MOT", "CLE", "LCK",
                "OKC", "TUL", "EUG", "PDX", "PHL", "PIT", "PVD", "WST", "CHS", "FLO", "ABR", "PIR", "MEM", "BNA", "DAL", "CRP", "SAT", "CNY", "SLC",
                "BTV", "RIC", "ROA", "BFI", "ALW", "CRW", "LWB", "EAU", "MKE", "CPR", "JAC"));
        if (!airportList.contains(code)) {
            //throw new IllegalArgumentException("Sorry, there are no flights available for this airport");
        }
        airportCode = code;
    }
    public List<String> getCodes() {
        //returns a list of all airport codes;
        return airportList;
    }

    public String getAirportCode() {
        //returns the airport code name to be displayed in the list of SweetEscape Flight Schedule
        return airportCode;
    }
}