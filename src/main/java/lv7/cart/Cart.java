package lv7.cart;

import lv7.menu.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {
    private static final Logger log = LoggerFactory.getLogger(Cart.class);
    private final List<MenuItem> cartItems = new ArrayList<>();

    public void addItemToCart(MenuItem menuItem) {
        cartItems.add(menuItem);
        log.debug("장바구니:{}", cartItems);
    }

    public Map<MenuItem, Integer> getCartItemCountMap() {
        return cartItems.stream()
                .collect(Collectors.groupingBy(
                                menuItem -> menuItem, Collectors.summingInt(menuItem -> 1)
                        )
                );
    }

    public double totalPrice() {
       return cartItems.stream().mapToDouble(menuItem -> menuItem.getPrice()).sum();
    }

    public Integer totalCount() {
        return cartItems.size();
    }

    public void clearCart() {
        cartItems.clear();
        log.debug("장바구니:{}", cartItems);
    }
}
