package lv7.validation;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputValidator {

    private InputValidator() {
    }
    private static final Scanner scanner = new Scanner(System.in);


    public static void validateRange(int inputNumber, int min, int max) {
        if (inputNumber < min || inputNumber > max) {
            throw new IllegalArgumentException(min + "~" + max + "사이의 숫자만 입력가능합니다.");
        }
    }

    public static int getValidIntegerInputInRange(int min, int max) {
        int inputNumber;
        while (true) {
            try {
                inputNumber = scanner.nextInt();
                validateRange(inputNumber, min, max);
                return inputNumber;
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("숫자만 입력가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
