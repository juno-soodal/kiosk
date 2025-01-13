package lv5;


import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<MenuItem> menuItems = new ArrayList<>();
    private final String category;

    public Menu(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void showMenuItems() {
        menuItems.forEach(MenuItem::showMenuItem);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void showMenuCategory(int idx) {
        System.out.printf("%d. %s\n",idx, category);
    }
}
