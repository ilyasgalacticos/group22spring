package kz.bitlab.group22.controllers;

import kz.bitlab.group22.beans.CountryBean;
import kz.bitlab.group22.entities.Cities;
import kz.bitlab.group22.entities.Countries;
import kz.bitlab.group22.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryBean countryBean;

    @GetMapping(path = "/")
    public String index(Model model){

        List<Countries> countries = countryBean.getAllCountries();
        model.addAttribute("countries", countries);

        List<Cities> cities = countryBean.getAllCities();
        model.addAttribute("cities", cities);

        List<Users> users = countryBean.getAllUsers();
        model.addAttribute("users", users);

        return "countries/index";
    }

    @PostMapping(path = "/addcity")
    public String addCity(@RequestParam(name = "name") String name,
                          @RequestParam(name = "country_id") Long countryId){

        Countries country = countryBean.getCountry(countryId);
        Cities city = new Cities(null, name, country);
        countryBean.addCity(city);

        return "redirect:/";

    }

    @PostMapping(path = "/adduser")
    public String addUser(@RequestParam(name = "full_name") String fullName){

        countryBean.addUser(new Users(null, fullName, null));

        return "redirect:/";

    }

    @GetMapping(path = "/details/{id}")
    public String details(Model model, @PathVariable(name = "id") Long id){

        Users user = countryBean.getUser(id);
        model.addAttribute("user", user);

        List<Cities> cities = countryBean.getAllCities();
        model.addAttribute("cities", cities);

        return "countries/details";
    }

    @PostMapping(path = "/assigncity")
    public String assignCity(@RequestParam(name = "city_id") Long cityId,
                             @RequestParam(name = "user_id") Long userId){

        Users user = countryBean.getUser(userId);
        Cities city = countryBean.getCity(cityId);

        List<Cities> userCities = user.getCities();
        if(userCities==null){
            userCities = new ArrayList<>();
        }

        userCities.add(city);
        user.setCities(userCities);
        countryBean.saveUser(user);

        return "redirect:/details/"+userId;

    }

}
