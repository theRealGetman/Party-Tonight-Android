package app.media.opp.partytonight.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arkadii on 10/29/16.
 */
public class UserEntity {
    String userName;
    String phoneNumber;
    @SerializedName("billing")
    BillingEntity billingInfo;
    String emergencyContact;
    String email;
    String password;


    public UserEntity(String userName, String email, String phoneNumber, BillingEntity billingInfo, String emergencyContact, String password) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.billingInfo = billingInfo;
        this.emergencyContact = emergencyContact;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public BillingEntity getBillingInfo() {
        return billingInfo;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public String getPassword() {
        return password;
    }
}
