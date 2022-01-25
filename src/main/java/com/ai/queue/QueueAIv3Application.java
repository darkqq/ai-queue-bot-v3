package com.ai.queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.ai.queue.properties")
public class QueueAIv3Application {
    public static void main(String[] args) {
        SpringApplication.run(QueueAIv3Application.class, args);
    }

}
