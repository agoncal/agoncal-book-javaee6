package org.agoncal.book.javaee6.chapter14.ex01;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Invoking web service programmatically");

        CreditCard01 creditCard = new CreditCard01();
        creditCard.setNumber("12341234");
        creditCard.setExpiryDate("10/10");
        creditCard.setType("VISA");
        creditCard.setControlNumber(1234);

        CardValidator01 cardValidator = new CardValidator01Service().getCardValidator01Port();
        System.out.println(cardValidator.validate(creditCard));

        creditCard.setNumber("12341233");
        System.out.println(cardValidator.validate(creditCard));
    }
}