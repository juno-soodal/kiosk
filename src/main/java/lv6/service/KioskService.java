package lv6.service;

import lv6.cart.Cart;
import lv6.menu.Category;
import lv6.menu.Menu;
import lv6.menu.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;

import static lv6.service.Discount.calculateDiscount;
import static lv6.ui.KioskUi.*;
import static lv6.validation.MenuInputValidator.getValidNumberInput;
import static lv6.validation.MenuInputValidator.validateNumberRange;

public class KioskService {
    private static final Logger log = LoggerFactory.getLogger(KioskService.class);

    private final List<Menu> menus;
    private final Cart cart;

    private static final int CATEGORY_COUNT = Category.values().length;
    private static final int ORDER_NUMBER = CATEGORY_COUNT + 1;
    private static final int CANCEL_NUMBER = CATEGORY_COUNT + 2;
    private static final Scanner scanner = new Scanner(System.in);

    public KioskService(List<Menu> menus, Cart cart) {
        this.menus = menus;
        this.cart = cart;
    }


    public void start() {

        while (true) {
            displayMain();

            if (canShowOrderMenu()) {
                displayOrderMenu();
            }

            int inputMainMenuNum = getValidNumberInput(scanner, 0, getMainMenuInputRange());

            if (inputMainMenuNum == 0) {
                scanner.close();
                log.info("프로그램을 종료합니다.");
                return;
            }

            if (inputMainMenuNum == ORDER_NUMBER) {
                handleOrderMenuClick();
                continue;
            }

            if (inputMainMenuNum == CANCEL_NUMBER) {
                handleCancelMenuClick();
                continue;
            }


            handleCategoryMenuClick(inputMainMenuNum - 1);

        }
    }

    private void handleCategoryMenuClick(int inputMainMenuNum) {
        Menu findMenu = menus.get(inputMainMenuNum);
        while (true) {
            displayMenuItems(findMenu);

            int inputMenuItemNum = getValidNumberInput(scanner, 0, findMenu.getMenuItemsCount());
            //뒤로가기
            if (inputMenuItemNum == 0) {
                break;
            }
            MenuItem selectedMenuItem = findMenu.getMenuItemByInput(inputMenuItemNum - 1);
            handleMenuItemClick(selectedMenuItem);
        }

    }

    private void handleMenuItemClick(MenuItem menuItem) {

        displaySelectedMenuInfo(menuItem);
        displayAddToCartConfirm();

        int inputCartNum = getValidNumberInput(scanner, 1, 2);
        validateNumberRange(inputCartNum, 1, 2);

        if (inputCartNum == 1) {
            cart.addItemToCart(menuItem);
            System.out.println(menuItem.getMenuName() + "이 장바구니에 추가되었습니다.");
        }
    }

    private void handleCancelMenuClick() {
        displayCancelMenu(cart);
        int inputCancelNum = getValidNumberInput(scanner, 1, 2);
        if (inputCancelNum == 1) {
            cart.clearCart();
        }
    }

    private void handleOrderMenuClick() {
        displayOrderSummary(cart);

        int inputOrderNum = getValidNumberInput(scanner, 1, 2);
        if (inputOrderNum == 1) {
            //order
            displayDiscountInfo();
            handleDiscountClick();
        }
    }

    //orderService
    private void handleDiscountClick() {
        int inputDiscountNum = getValidNumberInput(scanner, 1, Discount.values().length);
        Discount discount = Discount.getDiscount(inputDiscountNum);
        double totalPrice = getTotalPrice(discount);
        displayOrderComplete(totalPrice);
        cart.clearCart();
    }



    private double getTotalPrice(Discount discount) {
        return cart.totalPrice() - calculateDiscount(discount, cart.totalPrice());
    }


    public boolean canShowOrderMenu() {
        return cart.totalCount() > 0;
    }

    private int getMainMenuInputRange() {
        if (cart.totalCount() > 0) {
            return CATEGORY_COUNT + 2;
        }
        return CATEGORY_COUNT;
    }
}
