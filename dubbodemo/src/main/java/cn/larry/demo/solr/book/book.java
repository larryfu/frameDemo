package cn.larry.demo.solr.book;

import cn.larry.demo.solr.feeds.TimeUtils;
import org.apache.solr.client.solrj.beans.Field;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by fugz on 2016/4/19.
 */
public class Book {

    @Field
    private String id;
    @Field
    private String name;
    @Field
    private List<String> authors;
    @Field
    private String press;
    @Field
    private Date pubTime;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Field
    private double price;
    @Field
    private double mark;

    Book() {
    }

    public static Book fromBook2(Map<String,Object> book2) {
        return new Book(book2);
    }

    private Book(Map<String,Object> book2) {
        this.id = (String)book2.get("id");
        this.setPrice((double)book2.get("price"));
        this.setPress((String) book2.get("press"));
        this.setAuthors((List<String>)book2.get("authors"));
        this.setName((String)book2.get("name"));
        this.setMark((double)book2.get("mark"));
        this.setPubTime(transferDate((String)book2.get("pubTime")));
    }

    private Date transferDate(String date) {
        return TimeUtils.parseDate(date, "yyyy-MM-dd'T'HH:mm:ss'Z'");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }


    public void setPrice(float price) {
        this.price = price;
    }



    public void setMark(float mark) {
        this.mark = mark;
    }
}
