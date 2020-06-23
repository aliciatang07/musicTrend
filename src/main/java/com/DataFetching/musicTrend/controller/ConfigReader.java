package com.DataFetching.musicTrend.controller;


import java.io.*;
import java.net.URL;
import java.util.Properties;


//https://developer.spotify.com/documentation/web-api/reference/browse/get-list-new-releases/
//fetch data from third party api and feed into topic

public class ConfigReader {
    public ConfigReader() {
    }

    static InputStream inputStream;

    public String getPropValues(String key) throws IOException {

        String result = "";
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            result = prop.getProperty(key);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }


    public void setPropValues(String key, String value) throws IOException {
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            URL res = ConfigReader.class.getClassLoader().getResource(propFileName);

            inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            prop.setProperty(key, value);

            FileOutputStream os = new FileOutputStream(res.toString().substring(5));
            prop.store(os, "UTF-8");
            os.close();


        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }


//    public static void main(String[] args){
//        try{
//            new ConfigReader().setPropValues("access_token","BQB3Y4WJPZCLW1z_ZSrlv9zRmvGf4ZNEPT2wwItS6JnpDqZoRq1W9_xweoUqgni9e4ETscyPeuhALMxm0cU");
//        } catch(Exception e){
//            System.out.println("Exception: " + e);
//        }
//
//
//        }


}
