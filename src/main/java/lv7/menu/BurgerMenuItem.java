package lv7.menu;

public class BurgerMenuItem extends MenuItem{

    private static int sequence= 0;
    public BurgerMenuItem(String menuName, Double price, String description) {
        super(++sequence, menuName, price, description, Category.BURGERS);
    }
}
