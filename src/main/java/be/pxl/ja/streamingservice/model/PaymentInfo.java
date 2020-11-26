package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class PaymentInfo {
    private String firstName;
    private String lastName;
    private String cardNumber;
    private LocalDate expirationDate;

    private CreditCardType type;
    private int securityCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (LocalDate.now().plusMonths(1).isAfter(expirationDate)) {
            throw new InvalidDateException(expirationDate, "expirationdate", "Must be valid for at least 1 month.");
        }
        this.expirationDate = expirationDate;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }


//    public CreditCardType getType() {
//        return type;
//    }
//
//    public int getSecurityCode() {
//        return securityCode;
//    }
//

}