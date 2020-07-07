package com.DataFetching.musicTrend.controller;


import org.springframework.kafka.core.KafkaTemplate;

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

//    public KafkaController(KafkaTemplate<String, String> template) {
//        this.template = template;
//    }
    //  this segrgation is not good, topic should separate from audiofeatures
    public StreamAudioFeatures(String country, int limit, int offset, String topic,KafkaTemplate<String, String> template) {
        this.country = country;
        this.limit = limit;
        this.offset = offset;
        this.topic = topic;
        this.template = template;
    }

    @Override
    public void run() {
//        System.out.println("test");
        try {
            /*
            * {
      "danceability": 0.572,
      "energy": 0.898,
      "key": 9,
      "loudness": -3.661,
      "mode": 0,
      "speechiness": 0.241,
      "acousticness": 0.154,
      "instrumentalness": 0,
      "liveness": 0.232,
      "valence": 0.494,
      "tempo": 82.934,
      "type": "audio_features",
      "id": "6lL3GA2rq8UvdvjMdp2H5g",
      "uri": "spotify:track:6lL3GA2rq8UvdvjMdp2H5g",
      "track_href": "https://api.spotify.com/v1/tracks/6lL3GA2rq8UvdvjMdp2H5g",
      "analysis_url": "https://api.spotify.com/v1/audio-analysis/6lL3GA2rq8UvdvjMdp2H5g",
      "duration_ms": 174133,
      "time_signature": 4
    },*/
            List<String> analysis = ds.streamAudioFeaturesVectors(country, limit, offset);
            for(String s:analysis){
                template.send(topic, s);
            }
            System.out.print("Sent New audio analysis at" + new Date() + "in topic" + topic);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        need further process

//    }
}
}
