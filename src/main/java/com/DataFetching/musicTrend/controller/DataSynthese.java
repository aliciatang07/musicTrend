package com.DataFetching.musicTrend.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import java.util.ArrayList;
import java.util.List;

public class DataSynthese {
    //TODO: too much association to this class, consider refactor
    DataFetcher df = new DataFetcher();

    public String getNewReleases(String country, int limit, int offset) throws Exception {
        df.getToken();
        JsonObject newrelease = df.getNewRelase(country, limit, offset);
        JsonArray releaseItems = newrelease.get("albums").getAsJsonObject().get("items").getAsJsonArray();
        int size = releaseItems.size();

        StringBuilder tracksids = new StringBuilder();


        for (int i = 0; i < size; i++) {
            JsonObject tracks = df.getTracks(releaseItems.get(i).getAsJsonObject().get("id").getAsString());
            JsonArray tracksArray = tracks.get("items").getAsJsonArray();
            int tracksize = tracksArray.size();
            for (int j = 0; j < tracksize; j++) {
                tracksids.append(tracksArray.get(i).getAsJsonObject().get("id").getAsString());
                tracksids.append(",");
            }
        }
//        remove last comma
        tracksids.deleteCharAt(tracksids.length() - 1);
        return tracksids.toString();

    }


    public JsonObject streamAudioFeatures(String country, int limit, int offset) throws Exception {
        String tracksids = getNewReleases(country, limit, offset);
        return df.getAudioFeatures(tracksids);

//      TODO: need further process for audio features, finally return jsonstring
    }


    public List<JsonObject> streamAudioAnalysis(String country, int limit, int offset) throws Exception {
        String[] ids = getNewReleases(country, limit, offset).split(",");
        List<JsonObject> result = new ArrayList<JsonObject>();
        for (String id : ids) {
            JsonObject aa = df.getAudioAnalysis(id);
            result.add(aa);
        }
        return result;
        //     TODO: need further process for audio analysis, finally return jsonstring
    }

}
