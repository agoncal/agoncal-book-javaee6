package org.agoncal.book.javaee6.chapter14;

import javax.jws.WebService;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebService
public class CardValidator {

    // ======================================
    // =           Public Methods           =
    // ======================================

    public boolean validate(CreditCard creditCard) {

        String lastDigit = creditCard.getNumber().substring(creditCard.getNumber().length() - 1, creditCard.getNumber().length());

        if (Integer.parseInt(lastDigit.toString()) % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }
}