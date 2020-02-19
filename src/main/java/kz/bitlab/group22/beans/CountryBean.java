package kz.bitlab.group22.beans;

import kz.bitlab.group22.entities.Cities;
import kz.bitlab.group22.entities.Countries;
import kz.bitlab.group22.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("singleton")
public class CountryBean {

    @Autowired
    private SessionFactory sessionFactory;

    public void addCity(Cities city){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(city);
        transaction.commit();
        session.close();
    }

    public void addCountry(Countries country){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(country);
        transaction.commit();
        session.close();
    }

    public List<Countries> getAllCountries(){
        Session session = sessionFactory.openSession();
        List<Countries> countries = session.createQuery("SELECT c FROM Countries c").getResultList();
        session.close();
        return countries;
    }

    public List<Cities> getAllCities(){
        Session session = sessionFactory.openSession();
        List<Cities> cities = session.createQuery("SELECT c FROM Cities c").getResultList();
        session.close();
        return cities;
    }

    public Countries getCountry(Long id){
        Session session = sessionFactory.openSession();
        Countries country = (Countries)session.createQuery("SELECT c FROM Countries c WHERE c.id = :idshka")
                .setParameter("idshka", id).uniqueResult();
        session.close();
        return country;
    }


    public void addUser(Users user){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public List<Users> getAllUsers(){
        Session session = sessionFactory.openSession();
        List<Users> list = session.createQuery("SELECT u FROM Users u").getResultList();
        session.close();
        return list;
    }

    public Users getUser(Long id){
        Session session = sessionFactory.openSession();
        Users user = (Users) session.createQuery("SELECT u FROM Users u WHERE u.id = :idshka")
        .setParameter("idshka", id).uniqueResult();
        session.close();
        return user;
    }

    public void saveUser(Users user){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
    }

    public Cities getCity(Long id){
        Session session = sessionFactory.openSession();
        Cities city = (Cities) session.createQuery("SELECT c FROM Cities c WHERE c.id = :idshka")
                .setParameter("idshka", id).uniqueResult();
        session.close();
        return city;
    }


}
