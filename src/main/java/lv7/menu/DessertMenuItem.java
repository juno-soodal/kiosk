package lv7.menu;

public class DessertMenuItem extends MenuItem{
    private static int sequence =0;

    public DessertMenuItem(String menuName, Double price, String description) {
        super(++sequence, menuName, price, description, Category.DESSERT);
    }
}
