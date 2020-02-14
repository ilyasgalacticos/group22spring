package kz.bitlab.group22.controllers;

import kz.bitlab.group22.beans.FirstBean;
import kz.bitlab.group22.beans.FirstBeanInterface;
import kz.bitlab.group22.beans.MyNewBean;
import kz.bitlab.group22.db.Blogs;
import kz.bitlab.group22.db.DBConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class BlogController {

    @Autowired
    private DBConnection connection;

    @Autowired
    private FirstBeanInterface myFirstBean;

    @Autowired
    private MyNewBean myNewBean;

    @Autowired
    private MyNewBean mySecondBean;


    @GetMapping(path = "/")
    public String index(Model model){

        ArrayList<Blogs> blogs = connection.getAllBlogs();
        model.addAttribute("blogs", blogs);

        model.addAttribute("userData", myFirstBean.getData());
        myFirstBean.setData("Ilyas");

        myNewBean.printUserData();
        mySecondBean.printUserData();

        return "blog/index";
    }

    @GetMapping(path = "/addblog")
    public String addBlog(Model model){

        return "blog/addblog";

    }

    @PostMapping(path = "/addblog")
    public String toAddBlog(@RequestParam("title") String title,
                            @RequestParam("content") String content,
                            @RequestParam("latin_url") String latinUrl){

        Blogs b = new Blogs(null, title, content, null, latinUrl);

        if(connection.addBlog(b)){
            return "redirect:addblog?success";
        }else{
            return "redirect:addblog?error";
        }

    }

    @GetMapping(path = "/readblog/{id}/{latinUrl}.html")
    public String readBlog(Model model,
                           @PathVariable("id") Long id,
                           @PathVariable("latinUrl") String latinUrl
    ){

        Blogs blog = connection.getBlog(id);
        model.addAttribute("blog", blog);

        System.out.println(myFirstBean.getData());

        return "blog/readblog";
    }

}
