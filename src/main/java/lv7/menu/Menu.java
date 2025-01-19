package lv7.menu;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {
    private final List<MenuItem> menuItems;

    public Menu( ) {
        this.menuItems = initMenuItems();
    }

    private List<MenuItem> initMenuItems() {
        List<MenuItem> items = new ArrayList<>();
        items.add(new BurgerMenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new BurgerMenuItem( "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        items.add(new BurgerMenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        items.add(new BurgerMenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        items.add(new DrinkMenuItem("Coca-Cola", 2.5, "시원한 코카콜라"));
        items.add(new DrinkMenuItem( "Diet Coke", 2.5, "칼로리를 줄인 다이어트 코크"));
        items.add(new DrinkMenuItem("Lemonade", 3.0, "신선한 레몬 에이드"));
        items.add(new DrinkMenuItem( "Iced Tea", 3.0, "얼음이 든 시원한 아이스티"));
        items.add(new DessertMenuItem("Chocolate Shake", 5.5, "진한 초콜릿 쉐이크"));
        items.add(new DessertMenuItem( "Vanilla Shake", 5.5, "부드러운 바닐라 쉐이크"));
        items.add(new DessertMenuItem("Strawberry Shake", 5.5, "달콤한 딸기 쉐이크"));
        items.add(new DessertMenuItem( "Ice Cream Cone", 3.5, "바삭한 콘에 담긴 바닐라 아이스크림"));
        return items;
    }

    public MenuItem getMenuItem(int inputNumber) {
        //배열이 크지않음으로 가독성을 위하여 o(n) 처리
        menuItems.stream()
                .filter(menuItem -> menuItem.getSequence() == inputNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("없는 번호를 입력하였습니다."));
        return menuItems.get(inputNumber);
    }

    public List<MenuItem> getMenuItems(Category category) {
       return menuItems.stream()
               .filter(menuItem -> menuItem.getCategory() == category)
               .collect(Collectors.toList());
    }
}
