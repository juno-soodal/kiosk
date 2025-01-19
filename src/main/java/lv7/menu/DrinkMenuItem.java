package lv7.menu;

public class DrinkMenuItem extends MenuItem {
    private static int sequence = 0;

    public DrinkMenuItem(String menuName, Double price, String description) {
        super(++sequence, menuName, price, description, Category.DRINKS);
    }
}
