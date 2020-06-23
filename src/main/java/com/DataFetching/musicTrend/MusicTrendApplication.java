package com.DataFetching.musicTrend;

import com.DataFetching.musicTrend.controller.DataFetcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;


@SpringBootApplication
public class MusicTrendApplication {
    //	for testing
    public static void main(String[] args) {
        try {
            DataFetcher df = new DataFetcher();
//			df.getAudioFeatures("0qU3XhIH9xczYPUWV6OopS");
//			df.getTracks("6ZTl8hHvYNuEg4Mk8yxz75");
//			df.getAudioAnalysis("5f7VJjfbwm532GiveGC0ZK");
//			df.getToken();
//			System.out.print("access_token"+df.getToken());
            df.getNewRelase("CA", 2, 0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


//	final normal version
//	public static void main(String[] args) {
//		SpringApplication.run(MusicTrendApplication.class, args);
//	}


//	main logic, get list of new release and fetch all of their audio analysis infor

}
