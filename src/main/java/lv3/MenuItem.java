package lv3;

public class MenuItem {
    private Long id;
    private String menuName;
    private Double price;
    private String description;

    public MenuItem(Long id, String menuName, Double price, String description) {
        this.id = id;
        this.menuName = menuName;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
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
}
