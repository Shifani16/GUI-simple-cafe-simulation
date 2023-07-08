/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudyCase3;

/**
 *
 * @author ASUS
 */
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Integer> cart;

    public ShoppingCart() {
        cart = new HashMap<>();
    }

    public boolean isMenuExist(String idMenu) {
        return cart.containsKey(idMenu);
    }

    public void incrementQty(String menus, int qty) {
        int currentQty = cart.getOrDefault(menus, 0);
        cart.put(menus, currentQty + qty);

    }

    public void decrementQty(String menus, int qty) {
        int currentQty = cart.getOrDefault(menus, 0);
        cart.put(menus, currentQty - qty);
    }

    public void addToCart(Menu menu, int qty) {
        String idMenu = menu.getIDMenu();
        int currentQty = cart.getOrDefault(idMenu, 0);
        cart.put(menu.getIDMenu(), qty + currentQty);

    }

    public void removeFromCart (String menus) {
        cart.remove(menus);
    }

    public int getQty(String menus) {
        return cart.getOrDefault(menus, 0);
    }
}
