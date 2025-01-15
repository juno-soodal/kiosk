package lv6.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class MenuInputValidator {
    private static final Logger log = LoggerFactory.getLogger(MenuInputValidator.class);
    public static int getValidNumberInput(Scanner scanner,int min, int max) {
        int inputNum;
        while (true) {
            try {
                inputNum = scanner.nextInt();
                log.debug("inputNumber:{}, min:{}, max:{}", inputNum, max, max);
                validateNumberRange(inputNum, min, max);
                break;
            } catch (InputMismatchException e) {
                throw new IllegalArgumentException("숫자만 입력가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (NoSuchElementException e) {
                scanner.close();
                log.info("프로그램이 종료 된 상태입니다.");
            }
        }

        return inputNum;
    }

    public static void validateNumberRange(int inputNumber, int min, int max) {
        if (inputNumber < min || inputNumber > max) {
            throw new IllegalArgumentException(min + "~" + max + "사이의 숫자만 입력가능합니다.");
        }
    }
}
