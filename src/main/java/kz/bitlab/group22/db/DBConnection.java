package kz.bitlab.group22.db;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
@Scope("singleton")
public class DBConnection {

    private Connection connection;

    public DBConnection(){

        try{

            System.out.println("CONNECTING TO DB");

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/group22_db?serverTimezone=UTC", "root", "");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public boolean addBlog(Blogs blog){

        boolean result = false;

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO blogs (title, content, post_date, latin_url) " +
                    "VALUES (?, ?, NOW(), ?)");

            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setString(3, blog.getLatinUrl());

            result = statement.executeUpdate()>0;

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;

    }

    public ArrayList<Blogs> getAllBlogs(){
        ArrayList<Blogs> blogs = new ArrayList<>();
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM blogs ORDER BY post_date DESC");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                blogs.add(
                        new Blogs(
                                resultSet.getLong("id"),
                                resultSet.getString("title"),
                                resultSet.getString("content"),
                                resultSet.getDate("post_date"),
                                resultSet.getString("latin_url")
                        )
                );

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return blogs;
    }

    public Blogs getBlog(Long id){
        Blogs blog = null;
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM blogs WHERE id = ? ");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                blog = new Blogs(
                    resultSet.getLong("id"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getDate("post_date"),
                    resultSet.getString("latin_url")
                );
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return blog;
    }

}
