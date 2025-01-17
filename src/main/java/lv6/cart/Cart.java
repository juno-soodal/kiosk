package lv6.cart;

import lv6.menu.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Cart {
    private static final Logger log = LoggerFactory.getLogger(Cart.class);
    private final Map<MenuItem, Integer> items = new HashMap<>();

    public void addItemToCart(MenuItem menuItem) {
        items.put(menuItem, items.getOrDefault(menuItem, 0) + 1);
        log.debug("장바구니:{}",items);
    }

    public Map<MenuItem, Integer> getItems() {
        return Map.copyOf(items);
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
