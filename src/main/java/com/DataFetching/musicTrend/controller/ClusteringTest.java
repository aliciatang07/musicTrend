package com.DataFetching.musicTrend.controller;

import org.springframework.kafka.core.KafkaTemplate;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

public class ClusteringTest extends TimerTask {
    private KafkaTemplate<String, String> template;
    String traintopic;
    String testtopic;
    DataSynthese ds = new DataSynthese();
    public ClusteringTest(String traintopic, String testtopic,KafkaTemplate<String, String> template){
        this.template = template;
        this.traintopic = traintopic;
        this.testtopic = testtopic;
    }

    @Override
    public void run(){
        try {

//            String train = "[2.3,3.4,4.9]";
//            String test = "(2.0, [2.2, 1.8, 0.0])";
//            template.send(traintopic, train);
//            template.send(testtopic, test);

            List<String> trains = ds.streamAudioFeaturesVectors("US", 3, 0);
            for(String s:trains){
                template.send(traintopic, s);
            }
            List<String> tests = ds.streamAudioFeaturesLabeledPoint("US", 3, 0);
            for(String t:tests){
                template.send(testtopic, t);
            }

            System.out.print("Sent " + new Date() + "in topic" + testtopic);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
