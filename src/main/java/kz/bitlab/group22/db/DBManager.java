package kz.bitlab.group22.db;

import java.util.ArrayList;

public class DBManager {

    private static ArrayList<Items> items = new ArrayList<>();

    static{

        items.add(new Items(1L, "Snickers", 200, "Toi Mart"));
        items.add(new Items(2L, "Mars", 210, "My Mart"));
        items.add(new Items(3L, "Bounty", 190, "Magnum"));
        items.add(new Items(4L, "Cola", 250, "Toi Mart"));
        items.add(new Items(5L, "Fanta", 220, "Toi Mart"));

    }

    private static Long id = 6L;

    public static void addItem(Items item){
        item.setId(id);
        items.add(item);
        id++;
    }

    public static ArrayList<Items> getItems(){
        return items;
    }

    public static Items getItem(Long id){
        for(Items i : items){
            if(i.getId()==id){
                return i;
            }
        }
        return null;
    }

}
