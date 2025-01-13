package lv4;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private final List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenus();
            int inputMenuNum = inputNumber(scanner);

            if (inputMenuNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            if (inputMenuNum > menus.size()) {
                throw new IllegalArgumentException("메뉴에 있는 숫자만 입력가능합니다.");
            }


            Menu menu = menus.get(inputMenuNum-1);
            List<MenuItem> menuItems = menu.getMenuItems();
            while (true) {
                System.out.println("[ " + menu.getCategory().toUpperCase() + " MENU ]");
                menu.showMenuItems();
                System.out.println("0. 뒤로가기");

                int inputMenuItemNum = inputNumber(scanner);

                if (inputMenuItemNum == 0) {
                    break;
                }

                if (inputMenuItemNum > menuItems.size()) {
                    throw new IllegalArgumentException("메뉴에 있는 숫자만 입력가능합니다.");
                }

                printResult(menuItems.get(inputMenuItemNum-1));
            }

        }
    }

    private void showMenus() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i+1) + ". " + menus.get(i).getCategory());
        }
        System.out.printf("%d. %-10s | %s%n", 0, "종료", "종료");
    }

    private int inputNumber(Scanner scanner) {
        int inputNum;
        try {
            inputNum = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
        return inputNum;
    }

    private void printResult(MenuItem menuItem) {
        String split = ", ";
        System.out.println("선택한 메뉴 : " + menuItem.getMenuName() + split + menuItem.getPrice() + split + menuItem.getDescription());
    }
}
