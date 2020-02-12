package kz.bitlab.group22.controllers;

import kz.bitlab.group22.db.DBManager;
import kz.bitlab.group22.db.Items;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/archive")
public class HomeController {

    @RequestMapping(path = {"/", "/index", "/home", "/index.html"}, method = RequestMethod.GET)
    public String index(Model model){

        ArrayList<Items> items = DBManager.getItems();
        model.addAttribute("itemler", items);

        ArrayList<String> shops = new ArrayList<>();
        shops.add("Toi Mart");
        shops.add("My Mart");
        shops.add("Magnum");
        model.addAttribute("shopCenters", shops);
        // request.setAttribute("items", items);

        return "home";
    }

    @RequestMapping(path = "/about", method = RequestMethod.GET)
    public String aboutPage(){
        return "about";
    }

    @RequestMapping(path = "/additem", method = RequestMethod.POST)
    public String addItem(
            @RequestParam(name = "item_name") String name,
            @RequestParam(name = "shop_name") String shopName,
            @RequestParam(name = "item_price") int price
    ){

        DBManager.addItem(new Items(null, name,  price, shopName));

        String text = "Ilyas";

        return "redirect:/index?success";
    }

    @GetMapping(path = "/details/{itemId}")
    public String details(Model model, @PathVariable(name = "itemId") Long id){

        Items item = DBManager.getItem(id);
        model.addAttribute("item", item);

        ArrayList<String> shops = new ArrayList<>();
        shops.add("Toi Mart");
        shops.add("My Mart");
        shops.add("Magnum");
        model.addAttribute("shopCenters", shops);

        return "details";

    }

}
