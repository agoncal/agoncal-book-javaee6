package org.agoncal.book.javaee6.chapter07.ex20;

import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class StatisticsEJB20 {

    // ======================================
    // =           Public Methods           =
    // ======================================

    @Schedule(dayOfMonth = "1", hour = "5", minute = "30")
    public void statisticsItemsSold() {
        // ...
    }

    @Schedules({
            @Schedule(hour = "2"),
            @Schedule(hour = "14", dayOfWeek = "Wed")
    })
    public void generateReport() {
        // ...
    }

    @Schedule(minute = "*/10", hour = "*", persistent = false)
    public void refreshCache() {
        // ...
    }
}