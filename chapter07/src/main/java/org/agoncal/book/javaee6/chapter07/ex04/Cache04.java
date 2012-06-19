/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
package org.agoncal.book.javaee6.chapter07.ex04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Cache04 {
    // ======================================
    // =             Attributes             =
    // ======================================

    private static Cache04 instance = new Cache04();
    private Map<Long, Object> cache = new HashMap<Long, Object>();

    // ======================================
    // =            Constructors            =
    // ======================================

    private Cache04() {
    }

    // ======================================
    // =           Public Methods           =
    // ======================================

    public static synchronized Cache04 getInstance() {
        return instance;
    }

    public void addToCache(Long id, Object object) {
        if (!cache.containsKey(id))
            cache.put(id, object);
    }

    public void removeFromCache(Long id) {
        if (cache.containsKey(id))
            cache.remove(id);
    }

    public Object getFromCache(Long id) {
        if (cache.containsKey(id))
            return cache.get(id);
        else
            return null;
    }

    public Integer getNumberOfItems() {
        if (cache == null || cache.isEmpty())
            return 0;
        return cache.size();
    }
}
