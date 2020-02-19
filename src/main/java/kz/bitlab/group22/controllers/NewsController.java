package kz.bitlab.group22.controllers;

import kz.bitlab.group22.beans.NewsBean;
import kz.bitlab.group22.entities.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/archiveNews")
public class NewsController {

    @Autowired
    private NewsBean newsBean;

    @GetMapping(path = "/")
    public String index(Model model){
        List<News> news = newsBean.getAllNews();
        model.addAttribute("news", news);
        return "news/index";
    }

    @GetMapping(path = "/addnews")
    public String addNews(Model model){
        return "news/addnews";
    }

    @PostMapping(path = "/addnews")
    public String addNews(@RequestParam(name = "title") String title,
                          @RequestParam(name = "content") String content){

        News news = new News(title, content, new Date());
        newsBean.addNews(news);
        return "redirect:/";

    }

    @GetMapping(path = "/readnews/{idshka}")
    public String readNews(Model model, @PathVariable(name = "idshka") Long id){

        News news = newsBean.getNews(id);
        model.addAttribute("news", news);
        return "news/readmore";

    }

    @GetMapping(path = "/editnews/{idshka}")
    public String editNews(Model model, @PathVariable(name = "idshka") Long id){

        News news = newsBean.getNews(id);
        model.addAttribute("news", news);
        return "news/editnews";

    }

    @PostMapping(path = "/savenews")
    public String saveNews(@RequestParam(name = "title") String title,
                           @RequestParam(name = "content") String content,
                           @RequestParam(name = "id") Long id){

        News news = newsBean.getNews(id);
        news.setTitle(title);
        news.setContent(content);
        news.setPostDate(new Date());

        newsBean.updateNews(news);

        return "redirect:/";

    }


    @PostMapping(path = "/deletenews")
    public String deleteNews(@RequestParam(name = "id") Long id){

        News news = newsBean.getNews(id);
        newsBean.deleteNews(news);

        return "redirect:/";

    }

}
