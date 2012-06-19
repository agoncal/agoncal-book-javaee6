package org.agoncal.book.javaee6.chapter03.ex22;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex22_credit_card")
public class CreditCard22 {

    // ======================================
    // =             Attributes             =
    // ======================================
    @Id
    private String number;
    private String expiryDate;
    private Integer controlNumber;
    @Enumerated(EnumType.STRING)
    private CreditCardType22 creditCardType;

    // ======================================
    // =            Constructors            =
    // ======================================

    public CreditCard22() {
    }

    public CreditCard22(String number, String expiryDate, Integer controlNumber, CreditCardType22 creditCardType) {
        this.number = number;
        this.expiryDate = expiryDate;
        this.controlNumber = controlNumber;
        this.creditCardType = creditCardType;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Integer controlNumber) {
        this.controlNumber = controlNumber;
    }

    public CreditCardType22 getType() {
        return creditCardType;
    }

    public void setType(CreditCardType22 creditCardType) {
        this.creditCardType = creditCardType;
    }
}
