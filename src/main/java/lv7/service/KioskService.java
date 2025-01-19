package lv7.service;

import lv7.cart.Cart;
import lv7.discount.Discount;
import lv7.menu.Category;
import lv7.menu.Menu;
import lv7.menu.MenuItem;
import lv7.validation.InputValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class KioskService {
    private static final Logger log = LoggerFactory.getLogger(KioskService.class);

    private final Menu menu;
    private final Cart cart;

    public KioskService(Menu menu, Cart cart) {
        this.menu = menu;
        this.cart = cart;
    }


    public void start() {

        while (true) {
            System.out.println("[ MAIN MENU ]");
            List<Category> categories = Category.getCategories();
            categories.forEach(category -> System.out.printf("%d. %s\n", category.getSequence(), category.name()));
            System.out.printf("%d. %-10s | %s%n", 0, "종료", "종료");

            if (canShowOrderMenu()) {
                System.out.println("[ ORDER MENU ]");
                System.out.printf("%d. %-10s | %s%n", getOrderMenuNumber(), "Orders", "장바구니를 확인 후 주문합니다.");
                System.out.printf("%d. %-10s | %s%n", getCancelMenuNumber(), "Cancel", "진행중인 주문을 취소합니다.");
            }
            int inputMainMenuNum = InputValidator.getValidIntegerInputInRange(0, getMainMenuMaxInputRange());


            if (inputMainMenuNum == 0) {
                log.info("프로그램을 종료합니다.");
                return;
            }

            if (inputMainMenuNum >= 1 && inputMainMenuNum <= Category.getCategoryCount()) {
                handleCategoryMenu(inputMainMenuNum);
            }

            if (inputMainMenuNum == getOrderMenuNumber()) {
                handleOrderMenu();
                continue;
            }

            if (inputMainMenuNum == getCancelMenuNumber()) {
                handleCancelMenu();
            }

        }
    }


    private void handleCategoryMenu(int inputMainMenuNum) {
        Category category = Category.from(inputMainMenuNum);
        List<MenuItem> menuItems = menu.getMenuItems(category);
        while (true) {
            System.out.println("[ " + category.name() + " MENU ]");
            menuItems.forEach(menuItem -> System.out.printf("%d. %-15s | %s | %s%n", menuItem.getSequence(), menuItem.getMenuName(), menuItem.getFormattedPrice(), menuItem.getDescription()));
            System.out.println("0. 뒤로가기");
            int inputMenuItemNum = InputValidator.getValidIntegerInputInRange(0, menuItems.size());
            //뒤로가기
            if (inputMenuItemNum == 0) {
                break;
            }
            MenuItem selectedMenuItem = menu.getMenuItem(inputMenuItemNum);
            handleMenuItem(selectedMenuItem);
        }

    }

    private void handleMenuItem(MenuItem menuItem) {

        System.out.printf("선택한 메뉴 : %s, %s, %s", menuItem.getMenuName(), menuItem.getFormattedPrice(), menuItem.getDescription());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        int inputCartNum = InputValidator.getValidIntegerInputInRange(1, 2);
        if (inputCartNum == 1) {
            cart.addItemToCart(menuItem);
            System.out.println(menuItem.getMenuName() + "이 장바구니에 추가되었습니다.");
        }
    }

    private void handleCancelMenu() {
        Map<MenuItem, Integer> cartItemCountMap = cart.getCartItemCountMap();
        cartItemCountMap.forEach((menuItem, count) -> {
            System.out.printf("%-15s | %s | %s X %d %n", menuItem.getMenuName(), menuItem.getFormattedPrice(), menuItem.getDescription(), count);
        });
        System.out.println("진행중인 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        int inputCancelNum = InputValidator.getValidIntegerInputInRange(1, 2);
        if (inputCancelNum == 1) {
            cart.clearCart();
        }
    }

    private void handleOrderMenu() {

        Map<MenuItem, Integer> cartItemCountMap = cart.getCartItemCountMap();
        System.out.println("[ Orders ]");
        cartItemCountMap.forEach((menuItem, count) -> {
            System.out.printf("%-15s | %s | %s X %d %n", menuItem.getMenuName(), menuItem.getFormattedPrice(), menuItem.getDescription(), count);
        });
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W " + cart.totalPrice());
        System.out.println();
        System.out.println("1. 확인        2. 취소");

        int inputOrderNum = InputValidator.getValidIntegerInputInRange(1, 2);

        if (inputOrderNum == 1) {
            //order
            System.out.println("할인 정보를 입력해주세요.");
            Arrays.stream(Discount.values())
                    .forEach(discount -> System.out.printf("%d. %-10s : %s%n", discount.getSequence(), discount.getDescription(), discount.getDiscountRate() + "%"));
            handleDiscountSelection();
        }
    }

    private void handleDiscountSelection() {

        int inputDiscountNum = InputValidator.getValidIntegerInputInRange(1, Discount.values().length);
        Discount discount = Discount.from(inputDiscountNum);
        double discountedPrice = discount.applyDiscount(cart.totalPrice());
        System.out.println("주문이 완료되었습니다. 금액은 W" + discountedPrice + "입니다.");
        cart.clearCart();
    }



    public boolean canShowOrderMenu() {
        return cart.totalCount() > 0;
    }

    private int getCancelMenuNumber() {
        return Category.getCategoryCount() + 2;
    }

    private int getOrderMenuNumber() {
        return Category.getCategoryCount() + 1;
    }

    private int getMainMenuMaxInputRange() {
        if (cart.totalCount() > 0) {
            return Category.getCategoryCount() + 2;
        }
        return Category.getCategoryCount();
    }
}
