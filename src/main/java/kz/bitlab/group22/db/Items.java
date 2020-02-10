package kz.bitlab.group22.db;

public class Items {

    private Long id;
    private String name;
    private int price;
    private String shop;

    public Items() {
    }

    public Items(Long id, String name, int price, String shop) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.shop = shop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }
}
