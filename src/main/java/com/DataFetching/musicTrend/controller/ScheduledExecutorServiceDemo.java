package com.DataFetching.musicTrend.controller;


import java.util.concurrent.*;
import java.util.function.Function;
//TODO:AFTER FIRST FULL VERSION FINISH, CONSIDER USE MULTITHREAD SCHEUDLER
public class ScheduledExecutorServiceDemo {

    private void execute() throws InterruptedException, ExecutionException, TimeoutException {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

//        getTasksToRun().apply(executorService);
        ScheduledFuture<?> scheduledFuture4 = executorService.schedule(() -> {
            // Task
            System.out.println("Hellow world");
        }, 1, TimeUnit.SECONDS);
        scheduledFuture4.get(20, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    private void executeWithMultiThread() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        getTasksToRun().apply(executorService);
        executorService.shutdown();
    }

    private Function<ScheduledExecutorService, Void> getTasksToRun() {
        return (executorService -> {
//            ScheduledFuture<?> scheduledFuture1 = executorService.schedule(() -> {
//                // Task
//            }, 1, TimeUnit.SECONDS);
//
//            ScheduledFuture<?> scheduledFuture2 = executorService.scheduleAtFixedRate(() -> {
//                // Task
//            }, 1, 10, TimeUnit.SECONDS);
//
//            ScheduledFuture<?> scheduledFuture3 = executorService.scheduleWithFixedDelay(() -> {
//                // Task
//            }, 1, 10, TimeUnit.SECONDS);

            ScheduledFuture<String> scheduledFuture4 = executorService.schedule(() -> {
                // Task
                return "Hellow world";
            }, 1, TimeUnit.SECONDS);
            return null;
        });
    }

    public static void main(String... args) {
        ScheduledExecutorServiceDemo demo = new ScheduledExecutorServiceDemo();
        try {
            demo.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
//        demo.executeWithMultiThread();
    }


}