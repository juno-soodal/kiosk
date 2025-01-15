package lv6.menu;

import java.util.Objects;

public class MenuItem {
    private final String menuName;
    private final Double price;
    private final String description;

    public MenuItem(String menuName, Double price, String description) {
        this.menuName = menuName;
        this.price = price;
        this.description = description;
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

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        MenuItem menuItem = (MenuItem) object;
        return Objects.equals(menuName, menuItem.menuName) && Objects.equals(price, menuItem.price) && Objects.equals(description, menuItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName, price, description);
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "menuName='" + menuName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
