package lv5;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu burger = new Menu("Burgers");
        Menu drinks = new Menu("Drinks");
        Menu desserts = new Menu("Desserts");
        burger.addMenuItem(new MenuItem(1L, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem(2L, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem(3L, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burger.addMenuItem(new MenuItem(4L, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        List<Menu> menus = new ArrayList<>();
        menus.add(burger);
        menus.add(drinks);
        menus.add(desserts);
        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();


    }
}
