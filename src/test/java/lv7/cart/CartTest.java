package lv7.cart;

import lv7.menu.BurgerMenuItem;
import lv7.menu.MenuItem;
import org.junit.jupiter.api.Test;

import java.util.Map;

class CartTest {

    private Cart cart = new Cart();

    @Test
    public void cartTest() {

        BurgerMenuItem shackBurger1 = new BurgerMenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        BurgerMenuItem smokeShack = new BurgerMenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        cart.addItemToCart(shackBurger1);
        cart.addItemToCart(shackBurger1);
        cart.addItemToCart(smokeShack);

        Map<MenuItem, Integer> cartItems = cart.getCartItemCountMap();
        System.out.println(cartItems);


    }
}