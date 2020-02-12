package kz.bitlab.group22.db;

import java.util.Date;

public class Blogs {

    private Long id;
    private String title;
    private String content;
    private Date postDate;
    private String latinUrl;

    public Blogs(Long id, String title, String content, Date postDate, String latinUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.postDate = postDate;
        this.latinUrl = latinUrl;
    }

    public Blogs() {
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

    public String getLatinUrl() {
        return latinUrl;
    }

    public void setLatinUrl(String latinUrl) {
        this.latinUrl = latinUrl;
    }
}
