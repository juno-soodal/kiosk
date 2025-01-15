package lv6.menu;


import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<MenuItem> menuItems;
    private final Category category;

    public Menu(Category category) {
        this.category = category;
        this.menuItems = initMenuItems(category);
    }

    private List<MenuItem> initMenuItems(Category category) {
        List<MenuItem> items = new ArrayList<>();
        switch (category) {
            case BURGERS:
                items.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
                items.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
                items.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
                items.add(new MenuItem( "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
                break;
            case  DRINKS:
                items.add(new MenuItem("Coca-Cola", 2.5, "시원한 코카콜라"));
                items.add(new MenuItem("Diet Coke", 2.5, "칼로리를 줄인 다이어트 코크"));
                items.add(new MenuItem("Lemonade", 3.0, "신선한 레몬 에이드"));
                items.add(new MenuItem("Iced Tea", 3.0, "얼음이 든 시원한 아이스티"));
                break;
            case DESSERT:
                items.add(new MenuItem("Chocolate Shake", 5.5, "진한 초콜릿 쉐이크"));
                items.add(new MenuItem("Vanilla Shake", 5.5, "부드러운 바닐라 쉐이크"));
                items.add(new MenuItem("Strawberry Shake", 5.5, "달콤한 딸기 쉐이크"));
                items.add(new MenuItem("Ice Cream Cone", 3.5, "바삭한 콘에 담긴 바닐라 아이스크림"));
                break;
        }
        return items;
    }

    public Category getCategory() {
        return category;
    }

    public void showMenuItems() {
        for (MenuItem menuItem : menuItems) {
            System.out.printf("%d. %-15s | %c %.1f | %s%n",menuItems.indexOf(menuItem) + 1, menuItem.getMenuName(), 'W', menuItem.getPrice(), menuItem.getDescription());
        }
    }

    public int getMenuItemsCount() {
        return menuItems.size();
    }

    public MenuItem getMenuItemByInput(int inputNumber) {
        return menuItems.get(inputNumber);
    }
}
