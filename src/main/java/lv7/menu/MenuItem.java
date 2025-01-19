package lv7.menu;


public abstract class MenuItem {
    private final int sequence;
    private final String menuName;
    private final Double price;
    private final String description;
    private final Category category;
    private final String currencyUnit = "W";

    public MenuItem(int sequence, String menuName, Double price, String description, Category category) {
        this.sequence = sequence;
        this.menuName = menuName;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public String getMenuName() {
        return menuName;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public int getSequence() {
        return sequence;
    }

    public String getFormattedPrice() {
        return currencyUnit + " " + price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "sequence=" + sequence +
                ", menuName='" + menuName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", currencyUnit='" + currencyUnit + '\'' +
                '}';
    }
}
