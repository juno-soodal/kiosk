package lv7.discount;


import java.util.Arrays;

public enum Discount {
    VETERAN(1,"국가유공자", 10),
    SOLDIER(2,"군인", 5),
    STUDENT(3,"학생", 3),
    REGULAR(4,"일반", 0);

    private final int sequence;
    private final String description;
    private final int discountRate;

    Discount(int sequence, String description, int discountRate) {
        this.sequence = sequence;
        this.description = description;
        this.discountRate = discountRate;
    }

    public static Discount from(int inputNumber) {
        return Arrays.stream(values())
                .filter(discount -> discount.getSequence() == inputNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("없는 번호입니다."));
    }

    public String getDescription() {
        return description;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public int getSequence() {
        return sequence;
    }

    public double applyDiscount(double price) {
        return price - ( price * (discountRate / 100.0));
    }
}
