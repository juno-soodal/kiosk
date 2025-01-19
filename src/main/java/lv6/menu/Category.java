package lv6.menu;

public enum Category {
    BURGERS(1),
    DRINKS(2),
    DESSERT(3);

    private final int sequence;

    Category(int sequence) {
        this.sequence = sequence;
    }

    public int getSequence() {
        return sequence;
    }
}
