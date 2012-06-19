package org.agoncal.book.javaee6.chapter07.ex17;

import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class OrderEJB17 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Resource
    SessionContext ctx;

    // ======================================
    // =           Public Methods           =
    // ======================================

    @Asynchronous
    public void sendEmailOrderComplete(Order17 order, Customer17 customer) {
        // Very Long task
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
        }
    }

    @Asynchronous
    public void printOrder(Order17 order) {
        // Very Long task
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
        }
    }

    @Asynchronous
    public Future<Integer> sendOrderToWorkflow(Order17 order) {
        Integer status = 0;
        // processing
        status = 1;
        if (ctx.wasCancelCalled()) {
            return new AsyncResult<Integer>(2);
        }
        // processing
        return new AsyncResult<Integer>(status);
    }
}