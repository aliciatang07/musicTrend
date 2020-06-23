package com.DataFetching.musicTrend.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Timer;
import java.util.stream.Stream;

@RestController
public class ClientProducer {
//
//    private KafkaTemplate<String, String> template;
//
//    public KafkaController(KafkaTemplate<String, String> template) {
//        this.template = template;
//    }

    DataSynthese ds = new DataSynthese();

    @GetMapping("/kafka/getAudioFeature")
    public void produceAudioFeatures(@RequestParam String country, @RequestParam int limit, @RequestParam int offset, @RequestParam String topic) {
        try {
            StreamAudioAnalysis sa = new StreamAudioAnalysis(country, limit, offset, topic);
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(sa, 0, 1000);
            Thread.sleep(10000);
            timer.cancel();
        } catch (Exception e) {
            System.out.println("Failed to fetch audio features due to" + e);
        }
    }


    @GetMapping("/kafka/getAudioAnalysis")
    public void produceAudioAnalysis(@RequestParam String country, @RequestParam int limit, @RequestParam int offset, @RequestParam String topic) {
        try {
            StreamAudioFeatures sf = new StreamAudioFeatures(country, limit, offset, topic);
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(sf, 0, 1000);
            Thread.sleep(10000);
            timer.cancel();
        } catch (Exception e) {
            System.out.println("Failed to fetch audio features due to" + e);
        }
    }


//    https://www.baeldung.com/java-timer-and-timertask
//    https://www.baeldung.com/java-executor-service-tutorial

}