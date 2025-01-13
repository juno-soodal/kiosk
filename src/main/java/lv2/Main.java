package lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();

        add(menuItems, new MenuItem(1L, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        add(menuItems, new MenuItem(2L, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        add(menuItems, new MenuItem(3L, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        add(menuItems, new MenuItem(4L, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (MenuItem menuItem : menuItems) {
                print(menuItem);
            }
            System.out.printf("%d. %-10s | %s%n",0,"종료", "종료");
            int inputNum = 0;
            try {
                inputNum = scanner.nextInt();
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("숫자만 입력가능합니다.");
            }

            if (inputNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                return;
            }

            if (inputNum > menuItems.size()) {
                throw new IllegalArgumentException("메뉴에 있는 숫자만 입력가능합니다.");
            }

            printResult(menuItems.get(inputNum-1));

        }


    }

    public static void add(List<MenuItem> menuItems, MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    private static void printResult(MenuItem menuItem) {
        String split = ", ";
        System.out.println("선택한 메뉴 : " + menuItem.getMenuName()+split + menuItem.getPrice() + split + menuItem.getDescription());
    }

    private static void print(MenuItem menuItem) {

        System.out.printf("%d. %-15s | %c %.1f | %s%n",menuItem.getId(), menuItem.getMenuName(), 'W', menuItem.getPrice(), menuItem.getDescription());
    }
}
