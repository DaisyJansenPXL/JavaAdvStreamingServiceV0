package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.util.PasswordUtil;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String email;
    private String password;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles = new ArrayList<>();
    private PaymentInfo paymentInfo;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
        Profile profile = new Profile("profile1");
        this.addProfile(profile);
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public void addProfile(Profile profile) {
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
}
