package _05_BillsPaymentSystem;

import javax.persistence.*;

@Entity()
@Table(name = "bank_account")
public class BankAccount extends BillingDetails {
    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "SWIFT_code")
    private String SWIFTCode;

    private static final String BILLING_TYPE = "Bank account";

    public BankAccount() {}

    public BankAccount(int number, User owner, String bankName, String SWIFTCode) {
        super(number, BILLING_TYPE, owner);
        this.bankName = bankName;
        this.SWIFTCode = SWIFTCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSWIFTCode() {
        return SWIFTCode;
    }

    public void setSWIFTCode(String SWIFTCode) {
        this.SWIFTCode = SWIFTCode;
    }
}
