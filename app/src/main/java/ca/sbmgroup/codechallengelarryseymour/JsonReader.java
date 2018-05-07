package ca.sbmgroup.codechallengelarryseymour;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonReader {

    public JsonReader(){

    }

    public ArrayList<FeedObject> gsonToFeedItem(String jsonString){
        ArrayList<FeedObject> feedList = new ArrayList<>();

        FeedObject[] feedArray = new Gson().fromJson(jsonString, FeedObject[].class);
        feedList = new ArrayList<FeedObject>(Arrays.asList(feedArray));


        return feedList;
    }

    public ArrayList<FeedObject> jsonToFeedItem(String jsonString){
        try {
            ArrayList<FeedObject> feedList = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(jsonString);
            FeedObject feedObject = null;

            for (int i =0; i< jsonArray.length();i++)
            {
                List<body> bodyList = new ArrayList<>();
                JSONObject feedJsonObject = jsonArray.getJSONObject(i);
                int feedId = feedJsonObject.getInt("Id");
                String userName = feedJsonObject.getString("username");

                JSONArray bodyArray = feedJsonObject.getJSONArray("body");
                for(int r =0; r< bodyArray.length(); r++)
                {
                    body bodyObject = null;
                    JSONObject bodyJsonObject = bodyArray.getJSONObject(r);
                    int bodyId = bodyJsonObject.getInt("Id");
                    String bodyType = bodyJsonObject.getString("bodyType");
                    String text = null;
                    URL mediaLocation = null;

                    if(bodyType.equals("text")){
                        text = bodyJsonObject.getString("text");
                        bodyObject = new body(bodyId, bodyType,text);
                    }
                    else {
                        mediaLocation = new URL(bodyJsonObject.getString("mediaLocation"));
                        bodyObject = new body(bodyId, bodyType, mediaLocation);
                    }
                    bodyList.add(bodyObject);
                }
                feedObject = new FeedObject(feedId, userName, bodyList);
                feedList.add(feedObject);
            }
            return feedList;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (MalformedURLException me) {
            me.printStackTrace();
        }

        return null;
    }
}
