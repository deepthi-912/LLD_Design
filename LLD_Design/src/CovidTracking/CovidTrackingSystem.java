package CovidTracking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Build an application to calculate covid risk for users where users can register and tell if they have any symptoms, travel history, or came in contact with any positive patient. Based on which application will calculate and return the risk percentage of the user.
//
//USER:
//You need to provide following options for User:
//Register: A user can register by mobile number and pincode.
//Self Assessment: Users can enter:
//Any symptoms (cough, sore throat,etc).
//Any Travel history in the last 15 days.
//Any contact with covide positive patient.
//Covid Risk: Users can see the risk of being affected by Covid based on self assessment.
//
//Risk Calculation:
//No symptoms, No travel history, No contact with covid positive patient - Risk = 5%
//Any one out of symptoms, travel history or contact with covid positive patient is true - Risk = 50%
//Any two out of symptoms, travel history or contact with covid positive patient is true - Risk = 75%
//All 3 symptoms, travel history or contact with covid positive patient is true - Risk = 95%
//
//INPUT:
//RegisterUser(ABC,9999999999,560037);
//SelfAssessment(UserId,Y, N, N);
//
//OUTPUT:
//Risk is 50%
//
//ADMIN:
//You need to provide Admin options for Covid Healthworkers:
//Register: Covid Healthworkers can register by mobile number and pin code on user’s behalf
//Covid Result: Health workers can enter the result of covid tests for patients.
//Health workers can also mark already registered user as Recovered.
//
//INPUT:
//RegisterUser(ABC,9999999999,560037);
//CovidResult(AdminId, UserId, Y);
//
//OUTPUT:
//Record of UserId saved successfully as Positive
//
//ZONES:
//Mark zones(pincodes) as green, orange and red based on positive covid cases
//Default zone - GREEN
//<5 cases in a zone - ORANGE
//>5 cases in a zone - RED
//
//INPUT:
//GetZone(560037);
//
//OUTPUT:
//No. of positive cases: 1
//ORANGE

enum ZoneType {
    GREEN, ORANGE, RED;
}
class User {
    String userName;
    String mobileNumber;
    String pincode;

    public User(String userName, String mobileNumber, String pincode) {
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.pincode = pincode;
    }
}
class RegisterUser {
    public RegisterUser(String userName, String mobileNumber, String pincode) {
        User user = new User(userName, mobileNumber, pincode);
    }
}

class SelfAssessment {
    String userName;
    boolean isCough;
    boolean isThroat;
    boolean isCold;
    boolean isTravelHistory;
    boolean isContact;

    Integer generateCovidRisk() {
        int c=0;
        if(isCough) {
            c++;
        }
        if(isThroat) {
            c++;
        }
        if(isCold) {
            c++;
        }
        if(c==0 && !isTravelHistory && !isContact) {
            return 0;
        } else if(isTravelHistory || isContact) {
            if(c==1) {
                return 50;
            } else if(c==2) {
                return 75;
            } else if(c==3) {
                return 95;
            }
        }
        return 0;
    }
}

class CovidResult {
    String adminUserName;
    String patientUserName;
    boolean covidTestResult;

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getPatientUserName() {
        return patientUserName;
    }

    public void setPatientUserName(String patientUserName) {
        this.patientUserName = patientUserName;
    }

    public boolean isCovidTestResult() {
        return covidTestResult;
    }

    public void setCovidTestResult(boolean covidTestResult) {
        this.covidTestResult = covidTestResult;
    }
}

class Zone {
    Integer numberOfCovidCases;
    String pincode;
    ZoneType zoneType;


    public Integer getNumberOfCovidCases() {
        return numberOfCovidCases;
    }

    public void setNumberOfCovidCases(Integer numberOfCovidCases) {
        this.numberOfCovidCases = numberOfCovidCases;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public ZoneType getZoneType() {
        return zoneType;
    }

    public void setZoneType(ZoneType zoneType) {
        this.zoneType = zoneType;
    }
}
public class CovidTrackingSystem {
    // map all the users with a particular pincode
    HashMap<String, List<String>> mapUserWithPinCode;
    // map the test result with a particular user
    HashMap<String, CovidResult> mapUserWithTestResult;
    String getZoneByPincode(String pincode) {
        int count=0;
        List<String> covidResults = mapUserWithPinCode.get(pincode);
        for(int i=0;i<covidResults.size();i++) {
            if(mapUserWithTestResult.get(covidResults.get(i)).isCovidTestResult()) {
                count++;
            }
        }
        if(count<5) {
            return "ORANGE";
        }
        if(count>5) {
            return "RED";
        }
        return "GREEN";
    }
    public static void main(String[] args) {

    }
}