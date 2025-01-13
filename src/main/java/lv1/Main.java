package lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] menuList = {
                "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거"
        };
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");
            for (String menu : menuList) {
                System.out.println(menu);
            }
            System.out.println(" 0. 종료      | 종료");
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

            if (inputNum > menuList.length) {
                throw new IllegalArgumentException("메뉴에 있는 숫자만 입력가능합니다.");
            }

            System.out.println(menuList[inputNum-1]);

        }


    }
}
