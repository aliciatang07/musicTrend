package com.DataFetching.musicTrend.controller;

import org.springframework.kafka.core.KafkaTemplate;

import java.util.TimerTask;

public class StreamAudioAnalysis extends TimerTask {
    String country;
    int limit;
    int offset;
    String topic;
    DataSynthese ds = new DataSynthese();
    private KafkaTemplate<String, String> template;

    public StreamAudioAnalysis(String country, int limit, int offset, String topic, KafkaTemplate<String, String> template) {
        this.country = country;
        this.limit = limit;
        this.offset = offset;
        this.topic = topic;
        this.template = template;
    }

    @Override
    public void run() {
        System.out.println("test");
//        try {
//            List<JsonObject> analysis = ds.streamAudioAnalysis(country, limit, offset);
//            template.send(topic, analysis);
//            System.out.print("Sent New audio analysis at" + new Date() + "in topic" + topic);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        need further process

//    }
}
}
