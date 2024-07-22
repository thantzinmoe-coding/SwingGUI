package Model;

import java.math.BigDecimal;

public class UserModel {
    private long Id;
    private String name;
    private String PhoneNo;
    private String password;
    private BigDecimal Amount;
    private String Salt;


    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String PhoneNo) {
        this.PhoneNo = PhoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal Amount) {
        this.Amount = Amount;
    }

    public String getSalt() {
        return Salt;
    }

    public void setSalt(String salt) {
        Salt = salt;
    }
}
