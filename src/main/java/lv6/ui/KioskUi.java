package lv6.ui;

import lv6.cart.Cart;
import lv6.menu.Category;
import lv6.menu.Menu;
import lv6.menu.MenuItem;
import lv6.service.Discount;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class KioskUi {
    public static void displayMain() {
        System.out.println("[ MAIN MENU ]");
        Arrays.stream(Category.values())
                .forEach(category -> System.out.printf("%d. %s\n",category.ordinal()+1 , category.name()));
        System.out.printf("%d. %-10s | %s%n", 0, "종료", "종료");
    }

    public static void displayOrderMenu() {
        System.out.println("[ ORDER MENU ]");
        System.out.printf("%d. %-10s | %s%n", 4, "Orders", "장바구니를 확인 후 주문합니다.");
        System.out.printf("%d. %-10s | %s%n", 5, "Cancel", "진행중인 주문을 취소합니다.");
    }


    public static void displayOrderSummary(Cart cart) {
        System.out.println("[ Orders ]");
        Map<MenuItem, Integer> items = cart.getItems();
        showCartItems(items);
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W " + cart.totalPrice());
        System.out.println();
        System.out.println("1. 확인        2. 취소");
    }

    public static void displayOrderComplete(double totalPrice) {
        System.out.println("주문이 완료되었습니다. 금액은 W" + totalPrice + "입니다.");
    }

    private static void showCartItems(Map<MenuItem, Integer> items) {
        items.forEach((menuItem, count) -> {
            System.out.printf("%-15s | %c %.1f | %s X %d %n", menuItem.getMenuName(), 'W', menuItem.getPrice(), menuItem.getDescription(), count);
        });
    }

    public static void displayCancelMenu(Cart cart) {
        Map<MenuItem, Integer> items = cart.getItems();
        showCartItems(items);
        System.out.println("진행중인 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
    }

    public static void displayAddToCartConfirm() {
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
    }

    public static void displaySelectedMenuInfo(MenuItem menuItem) {
        String split = ", ";
        System.out.println("선택한 메뉴 : " + menuItem.getMenuName() + split + menuItem.getPrice() + split + menuItem.getDescription());
    }

    public static void displayMenuItems(Menu menu) {
        System.out.println("[ " + menu.getCategory().name() + " MENU ]");
        List<MenuItem> menuItems = menu.getMenuItems();
        showMenuItems(menuItems);
        System.out.println("0. 뒤로가기");
    }

    private static void showMenuItems(List<MenuItem> menuItems) {
    }

    public static void displayDiscountInfo() {
        System.out.println("할인 정보를 입력해주세요.");
        Arrays.stream(Discount.values())
                .forEach(discount -> System.out.printf("%d. %-10s : %s%n", discount.ordinal()+1, discount.getDescription(), discount.getDiscountRate()+"%"));

    }
}
