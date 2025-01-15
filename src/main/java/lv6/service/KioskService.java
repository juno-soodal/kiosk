package lv6.service;

import lv6.cart.Cart;
import lv6.menu.Category;
import lv6.menu.Menu;
import lv6.menu.MenuItem;

import java.util.List;
import java.util.Scanner;

import static lv6.ui.KioskUi.*;
import static lv6.validation.MenuInputValidator.inputNumber;
import static lv6.validation.MenuInputValidator.validateNumberRange;

public class KioskService {


    private final List<Menu> menus;
    private final Cart cart;

    private static final int CATEGORY_COUNT = Category.values().length;
    private static final int VALID_INPUT_RANGE = CATEGORY_COUNT + 2;
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

            int inputMainMenuNum = inputNumber(scanner);
            validateNumberRange(inputMainMenuNum, 0, VALID_INPUT_RANGE);

            if (inputMainMenuNum == 0) {
                System.out.println("프로그램을 종료합니다.");
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

            int inputMenuItemNum = inputNumber(scanner);
            validateNumberRange(inputMenuItemNum, 0, findMenu.getMenuItemsCount());

            //뒤로가기
            if (inputMenuItemNum == 0) {
                break;
            }
            MenuItem selectedMenuItem = findMenu.getMenuItemByInput(inputMenuItemNum);
            handleMenuItemClick(selectedMenuItem);
        }

    }

    private void handleMenuItemClick(MenuItem menuItem) {

        displaySelectedMenuInfo(menuItem);
        displayAddToCartConfirm();

        int inputCartNum = inputNumber(scanner);
        validateNumberRange(inputCartNum, 1, 2);

        if (inputCartNum == 1) {
            cart.addCart(menuItem);
        }
    }

    private void handleCancelMenuClick() {
        displayCancelMenu(cart);
        int inputCancelNum = inputNumber(scanner);
        validateNumberRange(inputCancelNum, 1, 2);
        if (inputCancelNum == 1) {
            cart.clearCart();
        }
    }

    private void handleOrderMenuClick() {
        displayOrderSummary(cart);

        int inputOrderNum = inputNumber(scanner);
        validateNumberRange(inputOrderNum, 1, 2);
        if (inputOrderNum == 1) {
            //order
            order();
        }
    }

    private void order() {
        System.out.println("주문이 완료되었습니다. 금액은 W" + cart.totalPrice() + "입니다.");
        cart.clearCart();
    }


    public boolean canShowOrderMenu() {
        return cart.totalCount() > 0;
    }
}
