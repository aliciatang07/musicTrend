package com.DataFetching.musicTrend.controller;

import java.util.Timer;

public class timer {
    // call kafka controller to produce the data periodically
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new NewsletterTask(), 0, 1000);

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
        }
        timer.cancel();
    }
}
