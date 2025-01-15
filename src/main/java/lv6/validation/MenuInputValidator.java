package lv6.validation;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MenuInputValidator {
    public static int inputNumber(Scanner scanner) {
        int inputNum;
        try {
            inputNum = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }
        return inputNum;
    }

    public static void validateNumberRange(int inputNumber, int min, int max) {
        if (inputNumber < min || inputNumber > max) {
            throw new IllegalArgumentException(min + "~" + max + "사이의 숫자만 입력가능합니다.");
        }
    }
}
