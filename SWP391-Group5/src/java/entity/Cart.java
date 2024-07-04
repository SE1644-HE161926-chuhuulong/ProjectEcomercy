/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import model.ProductModel;

/**
 *
 * @author black
 */
public final class Cart {

    private List<CartItem> items;

    public Cart() {
    }

    public Cart(List<CartItem> items) {
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public int getQuantityById(int id) {
        return getItembyId(id).getQuantity();
    }

    private CartItem getItembyId(int id) {
        for (CartItem i : items) {
            if (i.getProduct().getProductId() == id) {
                return i;
            }
        }
        return null;
    }

    public void addItem(CartItem t) {
        if (getItembyId(t.getProduct().getProductId()) != null) {
            CartItem m = getItembyId(t.getProduct().getProductId());
            m.setQuantity(m.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }

    public void removeItem(int id) {
        if (getItembyId(id) != null) {
            items.remove(getItembyId(id));
        }
    }

    public double getTotalMoney() {
        double t = 0;
        for (CartItem i : items) {
            t += (i.getQuantity() * i.getProduct().getPrice());
        }
        return t;
    }

    private Product getProductById(int id, List<Product> list) {
        for (Product i : list) {
            if (i.getProductId() == id) {
                return i;
            }
        }
        return null;
    }

    public Cart(String txt, List<Product> list) {
        items = new ArrayList<>();
        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split("/");//thay / cho dau ,
                for (String i : s) {
                    String[] n = i.split(":");
                    int id = Integer.parseInt(n[0]);
                    int quantity = Integer.parseInt(n[1]);
                    Product p = getProductById(id, list);
                    CartItem t = new CartItem(p, quantity, p.getPrice() * quantity);
                    addItem(t);
                }
            }
        } catch (NumberFormatException e) {

        }
    }
}
