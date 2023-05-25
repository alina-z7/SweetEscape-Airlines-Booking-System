import java.io.File;
import java.time.LocalDate;
import java.util.Random;

public class Passenger {
    private String fullName;
    private String email;
    private String gender;
    private int age;
    private LocalDate dateOfBirth;
    private long passportCode;
    private String phoneNumber;
    private long memberCode;
    public Passenger(String fullName, int age, LocalDate birthday, String gender) {
        this.fullName = fullName;
        this.age = age;
        dateOfBirth = birthday;
        this.gender = gender;
        Random codeGenerator = new Random();
        memberCode = codeGenerator.nextLong(100000000, 999999999);
        // stores the passenger's name, age, and date of birth creates a random variable for new members
        // or for those who lost their code
    }
    public long getCode() {
        // returns the member code of the passenger to be checked in MemberList
        return memberCode;
    }

    public String getName() {
        // returns the name of the passenger to be checked in MemberList
        return fullName;
    }
    public void setContactInfo(String email, String phoneNum) {
       if (phoneNum.length() != 10|| email.equals(null)) {
          //  throw new IllegalArgumentException("Sorry. Invalid contact information.");
       }
        this.email = email;
        phoneNumber = phoneNum;
        // stores the email and phone number of the passenger
        // if email does not contain char '@' or '.' throw error for wrong email
        // if phone number is greater than 9,999,999,999 throw error for wrong phone number
    }
    public boolean checkPassport(long passportCode, LocalDate passportExpiry) {
        // checks whether the passenger is eligible to fly by checking the passport expiry date and code
        // if today is after or equal to expiry date, or passport code is null, return false
        if (passportCode < 99999) {
            throw new IllegalArgumentException("Invalid passport ID.");
        }
        this.passportCode = passportCode;
        LocalDate today = LocalDate.now();
        return today.isAfter(passportExpiry) || today.isEqual(passportExpiry);
    }
    public File getMenu() {
        // return a menu so that the user may first see meal options before booking them
        return new File("/Users/alizac/IdeaProjects/Data Structures I/src/Final SweetEscape Airlines Flight Menu");
    }
    public File getAirportCodes() {
        // returns a list of airport codes associated with their location and full name
        return new File("/Users/alizac/IdeaProjects/Data Structures I/src/Final SweetEscape Airlines Airport Codes");
    }

    public File getNewMemberInfo() {
        // returns new member information in a text file if the passenger is not registered in memberList
        // (see MemberList constructor)
        return new File("/Users/alizac/IdeaProjects/Data Structures I/src/Final SweetEscape Airlines New Member Info");
    }

}