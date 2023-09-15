package _05_BillsPaymentSystem;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity()
@Table(name = "credit_cards")
public class CreditCard extends BillingDetails{
    private String cardType;

    @Column(name = "expiration_month")
    private Month expirationMonth;

    @Column(name = "expiration_year")
    private Year expirationYear;

    private static final String BILLING_TYPE = "Credit card";

    public CreditCard() {}

    public CreditCard(int number, User owner, String cardType, Month expirationMonth, Year expirationYear) {
        super(number, BILLING_TYPE, owner);
        this.cardType = cardType;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Month getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Month expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Year getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Year expirationYear) {
        this.expirationYear = expirationYear;
    }
}
