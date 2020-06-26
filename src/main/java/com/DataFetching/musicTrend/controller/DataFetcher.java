package com.DataFetching.musicTrend.controller;

import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.google.gson.*;

import javax.xml.ws.http.HTTPException;

import org.json.simple.JSONObject;
import org.apache.tomcat.util.json.JSONParser;

import org.springframework.http.HttpHeaders;

import java.io.IOException;


import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;

import java.util.List;

public class DataFetcher {
    //DONE: add refresh token mechanism to each method once it detect 401 error and retry the same method

    public DataFetcher() {
    }

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    private void close() throws IOException {
        httpClient.close();
    }


    public JsonObject getNewRelase(String country, int limit, int offset,int trials) throws Exception {

        HttpGet request = new HttpGet("https://api.spotify.com/v1/browse/new-releases?country=" + country + "&limit=" + limit + "&offset=" + offset);
        String bearer_token = new ConfigReader().getPropValues("access_token");
        request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + bearer_token);
        JsonObject res = new JsonObject();

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
//            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 401) {
//                refreshToken
                if(trials<5){
                    getToken();
                    return getNewRelase(country, limit,  offset, trials+1);
                }
                System.out.println("retry exceeds 5 times, api might got broken or meet server done");
            }
            if (statusCode != 200) {
                throw new HTTPException(statusCode);
            }
            System.out.println("status" + response.getStatusLine().getStatusCode());
            Header headers = entity.getContentType();
            System.out.println(headers);

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println("here" + result);
                Gson g = new Gson();
                res = g.fromJson(result, JsonObject.class);
            }



        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
        return res;
    }

    public JsonObject getTracks(String id,int trials) throws IOException {
        HttpGet request = new HttpGet("https://api.spotify.com/v1/albums/" + id + "/tracks");
        String bearer_token = new ConfigReader().getPropValues("access_token");
        request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + bearer_token);
        JsonObject res = new JsonObject();

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 401) {
//                refreshToken
                if(trials<5){
                    getToken();
                    return getTracks(id, trials+1);
                }
                System.out.println("retry exceeds 5 times, api might got broken or meet server done");
            }
            if (statusCode != 200) {
                throw new HTTPException(statusCode);
            }
            Header headers = entity.getContentType();
            System.out.println(headers);




            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
                Gson g = new Gson();
                res = g.fromJson(result, JsonObject.class);

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }


    //     get audio info
//    GET https://api.spotify.com/v1/audio-analysis/{id}
//    The base-62 identifier that you can find at the end of the Spotify URI (see above) for an artist, track, album, playlist, etc. Unlike a Spotify URI, a Spotify ID does not clearly identify the type of resource; that information is provided elsewhere in the call.
//
    public JsonObject getAudioAnalysis(String id,int trials) throws IOException {
        HttpGet request = new HttpGet("https://api.spotify.com/v1/audio-analysis/" + id);
        String bearer_token = new ConfigReader().getPropValues("access_token");
        request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + bearer_token);
        JsonObject res = new JsonObject();

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 401) {
//                refreshToken
                if(trials<5){
                    getToken();
                    return getAudioAnalysis(id, trials+1);
                }
                System.out.println("retry exceeds 5 times, api might got broken or meet server done");
            }
            if (statusCode != 200) {
                throw new HTTPException(statusCode);
            }

            System.out.println(headers);

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
                Gson g = new Gson();
                res = g.fromJson(result, JsonObject.class);

            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    //ids are comma separated
    public String getAudioFeatures(String ids,int trials) throws IOException, URISyntaxException {
        URIBuilder builder = new URIBuilder("https://api.spotify.com/v1/audio-features");
        builder.setParameter("ids", ids);
        HttpGet request = new HttpGet(builder.build());
        String bearer_token = new ConfigReader().getPropValues("access_token");
        request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + bearer_token);
        String res = "";

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 401) {
//                refreshToken
                if(trials<5){
                    getToken();
                    return getAudioFeatures(ids, trials+1);
                }
                System.out.println("retry exceeds 5 times, api might got broken or meet server done");
            }
            if (statusCode != 200) {
                throw new HTTPException(statusCode);
            }

            System.out.println(headers);

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
                res = result;
//                Gson g = new Gson();
//                res = g.fromJson(result, JsonObject.class);

            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }


    public void getToken() throws Exception {

        HttpPost post = new HttpPost("https://accounts.spotify.com/api/token");
        String encode_client = new ConfigReader().getPropValues("encode_client");
        post.addHeader(HttpHeaders.AUTHORIZATION, encode_client);

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("grant_type", "client_credentials"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters, Consts.UTF_8));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            String jsonstring = EntityUtils.toString(response.getEntity());
            Gson g = new Gson();
            JsonObject p = g.fromJson(jsonstring, JsonObject.class);
            String token = p.get("access_token").getAsString();
            System.out.println("access_token" + token);
            new ConfigReader().setPropValues("access_token", token);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
