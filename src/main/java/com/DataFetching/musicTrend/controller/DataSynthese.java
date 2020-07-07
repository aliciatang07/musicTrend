package com.DataFetching.musicTrend.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


import java.util.ArrayList;
import java.util.List;

public class DataSynthese {
    //TODO: too much association to this class, consider refactor
    DataFetcher df = new DataFetcher();

    public String getNewReleases(String country, int limit, int offset) throws Exception {
        df.getToken();
        JsonObject newrelease = df.getNewRelase(country, limit, offset,0);
        JsonArray releaseItems = newrelease.get("albums").getAsJsonObject().get("items").getAsJsonArray();
        int size = releaseItems.size();
        System.out.println("Got"+size+"newrelease albums");

        StringBuilder tracksids = new StringBuilder();


        for (int i = 0; i < size; i++) {
            JsonObject tracks = df.getTracks(releaseItems.get(i).getAsJsonObject().get("id").getAsString(),0);
            JsonArray tracksArray = tracks.get("items").getAsJsonArray();
            int tracksize = tracksArray.size();
            for (int j = 0; j < tracksize; j++) {
                tracksids.append(tracksArray.get(j).getAsJsonObject().get("id").getAsString());
                tracksids.append(",");
            }
        }
//        remove last comma
        tracksids.deleteCharAt(tracksids.length() - 1);
        return tracksids.toString();

    }

    private String generateVectors(JsonObject item){
        StringBuilder vector = new StringBuilder();
        vector.append("[");
        vector.append(item.get("danceability").getAsString()+",");
        vector.append(item.get("energy").getAsString()+",");
        vector.append(item.get("key").getAsString()+",");
        vector.append(item.get("loudness").getAsString()+",");
        vector.append(item.get("mode").getAsString()+",");
        vector.append(item.get("speechiness").getAsString()+",");
        vector.append(item.get("acousticness").getAsString()+",");
        vector.append(item.get("instrumentalness").getAsString()+",");
        vector.append(item.get("liveness").getAsString()+",");
        vector.append(item.get("valence").getAsString()+",");
        vector.append(item.get("tempo").getAsString()+",");
        //convert to s
        vector.append(Integer.toString(item.get("duration_ms").getAsInt()/1000)+",");
        vector.append(item.get("time_signature"));
        vector.append("]");
        return vector.toString();
    }

    private String generateLabeledPoint(JsonObject item){
        StringBuilder labeledpoint = new StringBuilder();
        labeledpoint.append("(");
        labeledpoint.append(item.get("id").getAsString()+",");
        labeledpoint.append("[");
        labeledpoint.append(item.get("danceability").getAsString()+",");
        labeledpoint.append(item.get("energy").getAsString()+",");
        labeledpoint.append(item.get("key").getAsString()+",");
        labeledpoint.append(item.get("loudness").getAsString()+",");
        labeledpoint.append(item.get("mode").getAsString()+",");
        labeledpoint.append(item.get("speechiness").getAsString()+",");
        labeledpoint.append(item.get("acousticness").getAsString()+",");
        labeledpoint.append(item.get("instrumentalness").getAsString()+",");
        labeledpoint.append(item.get("liveness").getAsString()+",");
        labeledpoint.append(item.get("valence").getAsString()+",");
        labeledpoint.append(item.get("tempo").getAsString()+",");
        //convert to s
        labeledpoint.append(Integer.toString(item.get("duration_ms").getAsInt()/1000)+",");
        labeledpoint.append(item.get("time_signature"));
        labeledpoint.append("]");
        labeledpoint.append(")");
        return labeledpoint.toString();
    }

    public String getNewReleaseFeatures(String country, int limit, int offset) throws Exception{
        String tracksids = getNewReleases(country, limit, offset);
        String features =  df.getAudioFeatures(tracksids,0);
        return features;
    }

    public List<String> streamAudioFeaturesVectors(String country, int limit, int offset) throws Exception {
        String features = getNewReleaseFeatures(country,limit,offset);
        List<String> res = new ArrayList<String>();

//      TODO: need further process for audio features, finally return jsonstring
        Gson g = new Gson();
        JsonObject p = g.fromJson(features, JsonObject.class);
        JsonArray body = p.get("audio_features").getAsJsonArray();
        for(int i = 0;i<body.size();i++){

            if(!body.get(i).isJsonNull()){
                String vector = generateVectors(body.get(i).getAsJsonObject());
                System.out.println(vector);
                res.add(vector);
            }
        }

        return res;

    }

    public List<String> streamAudioFeaturesLabeledPoint(String country, int limit, int offset) throws Exception {
        String features = getNewReleaseFeatures(country,limit,offset);
        List<String> res = new ArrayList<String>();

//      TODO: need further process for audio features, finally return jsonstring
        Gson g = new Gson();
        JsonObject p = g.fromJson(features, JsonObject.class);
        JsonArray body = p.get("audio_features").getAsJsonArray();
        for(int i = 0;i<body.size();i++){
            if(!body.get(i).isJsonNull()){
                String labeledPoint = generateLabeledPoint(body.get(i).getAsJsonObject());
                System.out.println(labeledPoint);
                res.add(labeledPoint);
            }
        }

        return res;

    }


    public List<JsonObject> streamAudioAnalysis(String country, int limit, int offset) throws Exception {
        String[] ids = getNewReleases(country, limit, offset).split(",");
        List<JsonObject> result = new ArrayList<JsonObject>();
        for (String id : ids) {
            JsonObject aa = df.getAudioAnalysis(id,0);
            result.add(aa);
        }

        return result;
        //     TODO: need further process for audio analysis, finally return jsonstring

    }

    public static void main(String[] args){
        try {
            System.out.println( new DataSynthese().getNewReleases( "US", 3, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
