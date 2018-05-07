package ca.sbmgroup.codechallengelarryseymour;

import java.net.URL;
import java.util.List;

public class FeedObject {
    private int Id;
    private String username;
    private List<body> body;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public List<body> getBodyList() {
        return body;
    }

    public void setBodyList(List<body> bodyList) {
        this.body = bodyList;
    }

    public FeedObject(int id, String userName) {
        this.Id = id;
        this.username = userName;
    }
    public FeedObject(int id, String userName, List<body> bodyList) {
        this.Id = id;
        this.username = userName;

    this.body = bodyList;
    }

}
