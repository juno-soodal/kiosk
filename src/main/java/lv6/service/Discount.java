package lv6.service;


import java.util.Arrays;

public enum Discount {
    VETERAN("국가유공자", 10),
    SOLDIER("군인", 5),
    STUDENT("학생", 3),
    REGULAR("일반", 0);

    private final String description;
    private final int discountRate;

    Discount(String description, int discountRate) {
        this.description = description;
        this.discountRate = discountRate;
    }

    public String getDescription() {
        return description;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public static double calculateDiscount(Discount discount, double price) {
        return price * (discount.discountRate / 100.0);
    }

    public static Discount getDiscount(int inputNumber) {
        return Arrays.stream(Discount.values())
                .filter(discount -> (discount.ordinal()+1) == inputNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지않은 할인입니다."));
    }
}
