package kz.bitlab.group22.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 20000)
    private String title;

    @Lob
    private String content;

    @Column(name = "post_date")
    private Date postDate;

    public News(String title, String content, Date postDate) {
        this.title = title;
        this.content = content;
        this.postDate = postDate;
    }

    public News(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
