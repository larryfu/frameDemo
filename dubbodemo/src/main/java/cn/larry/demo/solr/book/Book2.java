package cn.larry.demo.solr.book;

import org.apache.solr.client.solrj.beans.Field;

import java.util.List;

/**
 * Created by fugz on 2016/6/24.
 */
public class Book2 {

    @Field
    private String id;
    @Field
    private String name;
    @Field
    private List<String> authors;
    @Field
    private String press;
    @Field
    private String pubTime;
    @Field
    private float price;
    @Field
    private float mark;

    public Book2() {
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
}
