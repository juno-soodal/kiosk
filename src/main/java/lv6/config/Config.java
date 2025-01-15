package lv6.config;

import lv6.cart.Cart;
import lv6.menu.Category;
import lv6.menu.Menu;
import lv6.service.KioskService;

import java.util.List;

public class Config {

    public Cart cart() {
        return new Cart();
    }

    public KioskService kioskService() {
        return new KioskService(menus(), cart());
    }
    public List<Menu> menus() {
        Menu burger = new Menu(Category.BURGERS);
        Menu drinks = new Menu(Category.DRINKS);
        Menu desserts = new Menu(Category.DESSERT);
        return List.of(burger, drinks, desserts);
    }
}
