package lv6.cart;

import lv6.menu.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Cart {
    private static final Logger log = LoggerFactory.getLogger(Cart.class);
    private final Map<MenuItem, Integer> items = new HashMap<>();

    public void addCart(MenuItem menuItem) {
        items.put(menuItem, items.getOrDefault(menuItem, 0) + 1);
        log.debug("장바구니:{}",items);
        System.out.println(menuItem.getMenuName() + "이 장바구니에 추가되었습니다.");
    }

    public void showCart() {
        items.forEach((menuItem, count) -> {
            System.out.printf("%d. %-15s | %c %.1f | %s X %d %n", menuItem.getMenuName(), 'W', menuItem.getPrice(), menuItem.getDescription(), count);
        });
    }

    public double totalPrice() {
        return Math.round(items.entrySet().stream().mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue()).sum());
    }

    public Integer totalCount() {
        return items.values().stream().mapToInt(count -> count).sum();
    }

    public void clearCart() {
        items.clear();
        log.debug("장바구니:{}",items);
    }
}
