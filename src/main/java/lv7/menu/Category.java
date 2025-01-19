package lv7.menu;

import java.util.Arrays;
import java.util.List;

public enum Category {
    BURGERS(1),
    DRINKS(2),
    DESSERT(3);

    private final int sequence;

    Category(int sequence) {
        this.sequence = sequence;
    }

    public static Category from(int inputNumber) {
       return Arrays.stream(values())
               .filter(category -> category.getSequence() == inputNumber)
               .findFirst()
               .orElseThrow(() -> new IllegalArgumentException("존재하지않는 카테고리 번호입니다."));
    }

    public static List<Category> getCategories() {
        return List.of(values());
    }

    public static int getCategoryCount() {
        return values().length;
    }

    public int getSequence() {
        return sequence;
    }
}
