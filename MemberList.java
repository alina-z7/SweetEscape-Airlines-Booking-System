import java.util.HashMap;
import java.util.Map;
public class MemberList {
    private Map<String, Long> memberList;
    private boolean isMember;
    private Passenger p;
    public MemberList(Passenger p) {
        // assigns new passengers to a list with a newly generated code
        // if the memberList map does not contain the passenger's name put the name and the generated code
        // else the passenger is a member @var - isMember = true
        memberList = new HashMap<>();
        if (!memberList.containsKey(p.getName())) { //can be a name to code or passenger to code in memberList map
            memberList.put(p.getName(), p.getCode());
        } else {
            isMember = true;
        }
        this.p = p;
    }
    public void checkMemberCode(long number) {
        // makes sure if the booker has been registered, to provide its membership code
        // if memberList contains the name and if memberList value of that name does not equal the number parameter
        // throw a new illegal argument exception that requires the booker to put a valid code.
        if (memberList.containsKey(p.getName())) {
            if (memberList.get(p.getName()) != number) {
                throw new IllegalArgumentException("That is an invalid number, please try again");
            }
        }
    }

    public boolean getMembershipStatus() {
        // returns @var - isMember status for main to print a new member welcome of already member alert on the console
        return isMember;
    }
}
