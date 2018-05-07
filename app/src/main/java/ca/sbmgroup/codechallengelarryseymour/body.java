package ca.sbmgroup.codechallengelarryseymour;

import java.net.URL;

public class body {
    private int Id;
    private String bodyType;
    private String text;
    private URL mediaLocation;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public URL getMediaLocation() {
        return mediaLocation;
    }

    public void setMediaLocation(URL mediaLocation) {
        this.mediaLocation = mediaLocation;
    }

    public body(){

    }

    public body(int id, String bodyType, String text) {
        this.Id = id;
        this.bodyType = bodyType;
        this.text = text;
    }

    public body(int id, String bodyType, URL mediaLocation) {
        this.Id = id;
        this.bodyType = bodyType;
        this.mediaLocation = mediaLocation;
    }
}
