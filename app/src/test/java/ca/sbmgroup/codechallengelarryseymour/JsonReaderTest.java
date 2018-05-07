package ca.sbmgroup.codechallengelarryseymour;

import org.junit.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import static org.junit.Assert.*;

public class JsonReaderTest {
    JsonReader jr = new JsonReader();
    String json;
    int feedCount, bodyCount1, bodyCount2, feedId1, feedId2, bodyId1, bodyId2, bodyId3;
    int feedCountExpected, bodyCountExpected1, bodyCountExpected2, feedIdExpected1, feedIdExpected2, bodyIdExpected1, bodyIdExpected2, bodyIdExpected3;
    String userName1, userName2, bodyType1, bodyType2, bodyType3, text;
    String userNameExpected1, userNameExpected2, bodyTypeExpected1, bodyTypeExpected2, bodyTypeExpected3, textExpected;
    String image, media1, media2;
    String imageExpected, mediaExpected1, mediaExpected2;
    HttpURLConnection conn;

    private void setVariables() throws Exception{
        json = "[" +
                "{" +
                "'Id':1," +
                "'username':'test user'," +
                "'body':[" +
                "{" +
                "'Id':3," +
                "'bodyType':'text'," +
                "'text':'Hello World'" +
                "}," +
                "{" +
                "'Id':4," +
                "'bodyType':'image'," +
                "'mediaLocation':'http://sbmgroup.ca/images/sbmgrouplogo.gif'" +
                "}" +
                "]" +
                "}," +
                "{" +
                "'Id':2," +
                "'username':'test user'," +
                "'body':[" +
                "{" +
                "'Id':4," +
                "'bodyType':'video'," +
                "'mediaLocation':'http://sbmgroup.ca/squirrel5.mpg'" +
                "}" +
                "]" +
                "}" +
                "]";
        feedCountExpected = 2;
        bodyCountExpected1 = 2;
        bodyCountExpected2 = 1;
        feedIdExpected1 = 1;
        feedIdExpected2 = 2;
        bodyIdExpected1 = 3;
        bodyIdExpected2 = 4;
        bodyIdExpected3 = 5;
        userNameExpected1 = "test user";
        userNameExpected2 = "test user";
        bodyType1 = "text";
        bodyType2 = "image";
        bodyType3 = "video1";
        textExpected = "Hello World";
    }

    @Test
    public void gsonToFeedItemFeedCount() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        assertEquals("Gson Feed count is incorrect",feedCountExpected,list.size());
    }

    @Test
    public void gsonToFeedItemBodydCount1() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        assertEquals("Gson Body count 1 is incorrect",bodyCountExpected1,list.get(0).getBodyList().size());
    }

    @Test
    public void gsonToFeedItemBodydCount2() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        assertEquals("Gson Body count 2 is incorrect",bodyCountExpected2,list.get(1).getBodyList().size());
    }

    @Test
    public void gsonToFeedItemId11() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        assertEquals("Gson Feed Id 1 is incorrect",feedIdExpected1,list.get(0).getId());
    }

    @Test
    public void gsonToFeedItemId12() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        assertEquals("Gson Feed Id 2 is incorrect",feedIdExpected2,list.get(1).getId());
    }
    @Test
    public void gsonToFeedItemBodyId1() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        assertEquals("Gson Feed Body Id 1 is incorrect",bodyIdExpected1,list.get(0).getBodyList().get(0).getId());
    }
    @Test
    public void gsonToFeedItemBodyId2() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        assertEquals("Gson Feed Body Id 2 is incorrect",bodyIdExpected2,list.get(0).getBodyList().get(1).getId());
    }
    @Test
    public void gsonToFeedItemBodyId3() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        assertEquals("Gson Feed Body Id 3 is incorrect",bodyIdExpected3,list.get(1).getBodyList().get(0).getId());
    }
    @Test
    public void gsonToFeedItemBodyType1() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        assertEquals("Gson Feed Body Type 1 is incorrect",bodyTypeExpected1,list.get(0).getBodyList().get(0).getBodyType());
    }
    @Test
    public void gsonToFeedItemBodyType2() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        System.console().printf(list.get(0).getBodyList().get(1).getBodyType());
        assertEquals("Gson Feed Body Type 2 is incorrect",bodyTypeExpected2,list.get(0).getBodyList().get(1).getBodyType());
    }
    @Test
    public void gsonToFeedItemBodyType3() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        assertEquals("Gson Feed Body Type 3 is incorrect",bodyTypeExpected3,list.get(1).getBodyList().get(0).getBodyType());
    }
    @Test
    public void gsonToFeedItemText() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        assertEquals("Gson Text Value is incorrect",textExpected,list.get(0).getBodyList().get(0).getText());
    }
    @Test
    public void gsonToFeedItemImage() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        URL u = list.get(0).getBodyList().get(1).getMediaLocation();
        conn = (HttpURLConnection) u.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        assertEquals("Gson Image link is incorrect",200,conn.getResponseCode());
    }
    @Test
    public void gsonToFeedItemVideo() throws Exception{
        setVariables();
        ArrayList<FeedObject> list = new ArrayList();
        list = jr.gsonToFeedItem(json);
        URL u = list.get(1).getBodyList().get(0).getMediaLocation();
        conn = (HttpURLConnection) u.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        assertEquals("Gson Video link is incorrect",200,conn.getResponseCode());
    }
}