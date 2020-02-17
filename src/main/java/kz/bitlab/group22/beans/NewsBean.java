package kz.bitlab.group22.beans;

import kz.bitlab.group22.entities.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("singleton")
public class NewsBean {

    @Autowired
    private SessionFactory sessionFactory;

    public void addNews(News news){

        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(news);
        tr.commit();
        session.close();

    }

    public List<News> getAllNews(){

        Session session = sessionFactory.openSession();
        List<News> allNews = session.createQuery("SELECT n FROM News n").getResultList();
        session.close();
        return allNews;

    }

    public News getNews(Long id){
        Session session = sessionFactory.openSession();
        News news = (News)session.createQuery("SELECT n FROM News n WHERE n.id = :idshka ").
                setParameter("idshka", id).uniqueResult();
        session.close();
        return news;
    }

    public void updateNews(News news){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(news);
        transaction.commit();
        session.close();
    }

    public void deleteNews(News news){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(news);
        transaction.commit();
        session.close();
    }

}
