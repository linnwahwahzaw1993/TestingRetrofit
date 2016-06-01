package com.example.ice.retrofitjsonstring;

/**
 * Created by ICE on 30-May-16.
 */
public class News {
    int id,cele_id;
    String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCele_id() {
        return cele_id;
    }

    public void setCele_id(int cele_id) {
        this.cele_id = cele_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCele_name() {
        return cele_name;
    }

    public void setCele_name(String cele_name) {
        this.cele_name = cele_name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    String description;
    String summary;
    String cele_name;
    String created_at;


}
