package com.DataFetching.musicTrend.controller;

import com.google.gson.JsonObject;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

public class StreamAudioFeatures extends TimerTask {
    String country;
    int limit;
    int offset;
    String topic;
    DataSynthese ds = new DataSynthese();
    private KafkaTemplate<String, String> template;

    //  this segrgation is not good, topic should separate from audiofeatures
    public StreamAudioFeatures(String country, int limit, int offset, String topic) {
        this.country = country;
        this.limit = limit;
        this.offset = offset;
        this.topic = topic;
    }

    @Override
    public void run() {
        System.out.println("test");
//        try {
//            JsonObject analysis = ds.streamAudioFeatures(country, limit, offset);
//            template.send(topic, analysis);
//            System.out.print("Sent New audio analysis at" + new Date() + "in topic" + topic);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        need further process

//    }
}
}
