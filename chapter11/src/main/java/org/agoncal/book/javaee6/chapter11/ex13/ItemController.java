package org.agoncal.book.javaee6.chapter11.ex13;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@ManagedBean
@RequestScoped
public class ItemController {

    // ======================================
    // =             Attributes             =
    // ======================================

    @EJB
    private ItemEJB itemEJB;

    private Book book = new Book();
    private CD cd = new CD();
    private Item item = new Item();
    private List<Item> itemList = new ArrayList<Item>();

    // ======================================
    // =           Public Methods           =
    // ======================================

    public String doNewBook() {
        return "newBook.xhtml";
    }

    public String doNewCD() {
        return "newCD.xhtml";
    }

    public String doCreateBook() {
//        book.setDescription(item.getDescription());
//        book.setPrice(item.getPrice());
//        book.setTitle(item.getTitle());
        book = itemEJB.createBook(book);
        itemList = itemEJB.findItems();
        return "listItems.xhtml";
    }

    public String doCreateCD() {
//        cd.setDescription(item.getDescription());
//        cd.setPrice(item.getPrice());
//        cd.setTitle(item.getTitle());
        cd = itemEJB.createCD(cd);
        itemList = itemEJB.findItems();
        return "listItems.xhtml";
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}