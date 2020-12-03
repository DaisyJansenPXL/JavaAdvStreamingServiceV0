package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.util.PasswordUtil;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Account {
    private String email;
    private String password;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles = new ArrayList<>();
    private PaymentInfo paymentInfo;
    //private Map<String, Profile> profileHashMap;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
        Profile profile = new Profile("profile1");
        this.addProfile(profile);
        //profileHashMap.put(profile.getName(), profile);
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
        //profileHashMap = new HashMap<>(streamingPlan.getNumberOfProfiles());
    }

    public void addProfile(Profile profile) {
        /*try {
            profileHashMap.put(profile.getName(), profile);
            this.profiles.add(profile);
        }
        catch (TooManyProfilesException e) {
            System.out.println(e.getMessage());
        }*/
        this.profiles.add(profile);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean verifyPassword(String password) {
        return PasswordUtil.isValid(password, this.password);
    }

    public void setPassword(String password) {
        this.password = PasswordUtil.encodePassword(password);
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public Profile getFirstProfile() {
        return profiles.get(0);
    }

    /*public Profile getProfile(String name) {
        return profileHashMap.get(name);
    }*/
}
