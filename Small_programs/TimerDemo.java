package com.demo;

import java.util.*;

public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            // Java does not allow the same TimerTask to be scheduled more than once
            int counter = 10;

            @Override
            public void run() {
                if (counter > 0) {
                    System.out.println(counter + " seconds");
                    counter--;
                } else {
                    System.out.println("Happy New Year");
                    timer.cancel();
                }
            }
        };

        timer.schedule(task, 5); // Schedule the "task" to run ONCE after 5 milliseconds

        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, 2000);
        date.set(Calendar.MONTH, Calendar.DECEMBER);
        date.set(Calendar.DAY_OF_MONTH, 31);;
        date.set(Calendar.HOUR_OF_DAY, 23);
        date.set(Calendar.MINUTE, 59);
        date.set(Calendar.SECOND, 50);
        date.set(Calendar.MILLISECOND, 10);
        // Set up a Calendar object to represent December 31, 2000, 23:59:50.010

        timer.schedule(task, date.getTime()); // Schedule the "task" to run once at exactly the time specified in the Calendar

        timer.scheduleAtFixedRate(task, 0, 1000); // Start immediately and run "task" every 1 second

        timer.scheduleAtFixedRate(task, date.getTime(), 1000); // Start at the specific date and time (date.getTime()) and repeat every second

    }
}
