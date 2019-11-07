package com.mqtt.mqttconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class MqttconnectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqttconnectApplication.class, args);

        SensorEngine sensorEngine = new SensorEngine("localhost", 61616,"admin","admin","topic");
        new Thread(sensorEngine).start();
        Random random = new Random();


        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sensorEngine.send(random.nextDouble() * 60 + random.nextDouble() * 60 + random.nextDouble() * 60
                    + random.nextDouble() * 60+ random.nextDouble() * 60+ random.nextDouble() * 60);
        }
    }

}
