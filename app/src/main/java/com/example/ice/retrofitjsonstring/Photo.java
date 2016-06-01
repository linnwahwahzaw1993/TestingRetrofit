package com.example.ice.retrofitjsonstring;

/**
 * Created by ICE on 30-May-16.
 */
public class Photo {
    int id, cele_id;
    String name, original_url, thumb_url, thumbsamll, created_at;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getThumbsamll() {
        return thumbsamll;
    }

    public void setThumbsamll(String thumbsamll) {
        this.thumbsamll = thumbsamll;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }
}
