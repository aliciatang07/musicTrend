package com.DataFetching.musicTrend.controller;

import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
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
    //TODO: add refresh token mechanism to each method once it detect 401 error and retry the same method


    public DataFetcher() {
    }

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    private void close() throws IOException {
        httpClient.close();
    }


    public JsonObject getNewRelase(String country, int limit, int offset) throws Exception {

        HttpGet request = new HttpGet("https://api.spotify.com/v1/browse/new-releases?country=" + country + "&limit=" + limit + "&offset=" + offset);
        String bearer_token = new ConfigReader().getPropValues("access_token");
        request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + bearer_token);
        JsonObject res = new JsonObject();

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
//            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 400) {
//                refreshToken
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

            }
            String jsonstring = EntityUtils.toString(response.getEntity());
            Gson g = new Gson();
            res = g.fromJson(jsonstring, JsonObject.class);

        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
        return res;
    }

    public JsonObject getTracks(String id) throws IOException {
        HttpGet request = new HttpGet("https://api.spotify.com/v1/albums/" + id + "/tracks");
        String bearer_token = new ConfigReader().getPropValues("access_token");
        request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + bearer_token);
        JsonObject res = new JsonObject();

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            String jsonstring = EntityUtils.toString(response.getEntity());
            Gson g = new Gson();
            res = g.fromJson(jsonstring, JsonObject.class);

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);

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
    public JsonObject getAudioAnalysis(String id) throws IOException {
        HttpGet request = new HttpGet("https://api.spotify.com/v1/audio-analysis/" + id);
        String bearer_token = new ConfigReader().getPropValues("access_token");
        request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + bearer_token);
        JsonObject res = new JsonObject();

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }
            String jsonstring = EntityUtils.toString(response.getEntity());
            Gson g = new Gson();
            res = g.fromJson(jsonstring, JsonObject.class);


        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

    //ids are comma separated
    public JsonObject getAudioFeatures(String ids) throws IOException, URISyntaxException {
        URIBuilder builder = new URIBuilder("https://api.spotify.com/v1/audio-features");
        builder.setParameter("ids", ids);
        HttpGet request = new HttpGet(builder.build());
        String bearer_token = new ConfigReader().getPropValues("access_token");
        request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + bearer_token);
        JsonObject res = new JsonObject();

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);

            }
            String jsonstring = EntityUtils.toString(response.getEntity());
            Gson g = new Gson();
            res = g.fromJson(jsonstring, JsonObject.class);


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


//
//    private static HttpRequest.BodyPublisher buildFormDataFromMap(Map<Object, Object> data) {
//        StringBuilder builder = new StringBuilder();
//        for (Map.Entry<Object, Object> entry : data.entrySet()) {
//            if (builder.length() > 0) {
//                builder.append("&");
//            }
//            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
//            builder.append("=");
//            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
//        }
//        System.out.println(builder.toString());
//        return HttpRequest.BodyPublishers.ofString(builder.toString());
//    }

//    public void getToken() throws IOException, InterruptedException {
//        String encodedClient = new ConfigReader().getPropValues("encode_client");
//        Map<Object, Object> data = new HashMap<>();
//        data.put("grant_type", "client_credentials");
//
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://accounts.spotify.com/api/token"))
//                .POST(buildFormDataFromMap(data))
//                .setHeader(HttpHeaders.AUTHORIZATION,"Basic "+encodedClient)
//                .build();
//
//        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//
//        // print status code
//        System.out.println(response.statusCode());
//
//        // print response body
//        System.out.println(response.body());
//    }


    //get new release
//    public void getNewRelase(String country, int limit, int offset) throws IOException, InterruptedException {
//
//        String bearer_token =  new ConfigReader().getPropValues("access_token");
//        HttpRequest request = HttpRequest.newBuilder()
//                .GET()
//                .uri(URI.create("https://api.spotify.com/v1/browse/new-releases?country="+country+"&limit="+limit+"&offset="+offset))
//                .setHeader(HttpHeaders.AUTHORIZATION,"Bearer "+bearer_token)
//                .build();
//
//        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//        // print status code
//        System.out.println(response.statusCode());
//
//        // print response body
//        System.out.println(response.body());
//    }


}
