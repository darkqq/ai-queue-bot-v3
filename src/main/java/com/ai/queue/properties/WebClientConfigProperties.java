package com.ai.queue.properties;

import lombok.Data;

@Data
public class WebClientConfigProperties {
    private Integer connectTimeout;
    private Integer readTimeout;
    private Integer writeTimeout;
    private Integer maxConnections;
    private Integer maxAcquireTime;
    private Integer maxIdleTime;
    private Integer maxLifeTime;
}