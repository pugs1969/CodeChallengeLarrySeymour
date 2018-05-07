package ca.sbmgroup.codechallengelarryseymour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        displayFeed( new JsonReader().gsonToFeedItem(getFeed()));

        displayFeed( new JsonReader().jsonToFeedItem(getFeed()));

    }

    public String getFeed(){
        String json = "[" +
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
                "'mediaLocation':'http://.../'" +
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
                "'mediaLocation':'http://.../'" +
                "}" +
                "]" +
                "}" +
                "]";

        return json;//returns a json array of json objects representing the feed items.
    }

    public void displayFeed(ArrayList<FeedObject> feed)
    {

    }

}
