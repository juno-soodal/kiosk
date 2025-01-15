package lv6.cart;

import lv6.menu.MenuItem;

import java.util.*;

public class Cart {
    private final Map<MenuItem, Integer> items = new HashMap<>();

    public void addCart(MenuItem menuItem) {
        items.put(menuItem, items.getOrDefault(menuItem, 0)+1);
        System.out.println(menuItem.getMenuName() +"이 장바구니에 추가되었습니다.");
    }

    public void showCart() {
        for (Map.Entry<MenuItem, Integer> menuItemIntegerEntry : items.entrySet()) {
            MenuItem menuItem = menuItemIntegerEntry.getKey();
            Integer count = menuItemIntegerEntry.getValue();
            System.out.printf("%-15s | %c %.1f | %s X %d %n", menuItem.getMenuName(), 'W', menuItem.getPrice(), menuItem.getDescription(), count);
        }
    }

    public double totalPrice() {
        double totalPrice = 0.0;
        for (Map.Entry<MenuItem, Integer> menuItemIntegerEntry : items.entrySet()) {
            MenuItem menuItem = menuItemIntegerEntry.getKey();
            Integer count = menuItemIntegerEntry.getValue();
            totalPrice += menuItem.getPrice() * count;
        }
        return Math.round(totalPrice);
    }

    public Integer totalCount() {
        int totalCount = 0;
        for (Integer value : items.values()) {
            totalCount += value;
        }
        return totalCount;
    }

    public void clearCart() {
        items.clear();
    }
}
