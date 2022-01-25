package com.ai.queue.configuration;

import com.ai.queue.properties.WebClientConfigIISProperties;
import com.ai.queue.properties.WebClientConfigProperties;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.Connection;
import reactor.netty.ConnectionObserver;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class WebClientConfiguration implements ConnectionObserver {

    @Bean("web-client-iis")
    public WebClient webClientInternal(WebClientConfigIISProperties config) {
        return getWebClientBuilder(config).build();
    }


    public WebClient.Builder getWebClientBuilder(WebClientConfigProperties config) {
        Integer connectTimeout = config.getConnectTimeout();
        Integer readTimeout = config.getReadTimeout();
        Integer writeTimeout = config.getWriteTimeout();
        Integer maxConnections = config.getMaxConnections();
        Integer maxAcquireTime = config.getMaxAcquireTime();
        Integer maxIdleTime = config.getMaxIdleTime();
        Integer maxLifeTime = config.getMaxLifeTime();
        ConnectionProvider connectionProvider =
                ConnectionProvider.builder("aod-http-client")
                        .maxConnections(maxConnections)
                        .pendingAcquireTimeout(Duration.ofMillis(maxAcquireTime))
                        .maxIdleTime(Duration.ofMillis(maxIdleTime))
                        .maxLifeTime(Duration.ofMillis(maxLifeTime))
                        .build();
        HttpClient httpClient = HttpClient.create(connectionProvider)
                .doOnConnected(conn -> conn
                        .addHandlerLast(new ReadTimeoutHandler(readTimeout, TimeUnit.MILLISECONDS))
                        .addHandlerLast(new WriteTimeoutHandler(writeTimeout, TimeUnit.MILLISECONDS))
                ).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectTimeout)
                .observe(this);

        log.info("WebClientConfig: connectTimeout={}, readTimeout={}, writeTimeout={}", connectTimeout, readTimeout, writeTimeout);

        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient));
    }

    /**
     * @see ConnectionObserver#onStateChange(Connection, State)
     */
    @Override
    public void onStateChange(Connection connection, State newState) {
        log.info("WebClient State Change: connection={}, newState={}", connection, newState);
    }

    /**
     * @see ConnectionObserver#onUncaughtException(Connection, Throwable)
     */
    @Override
    public void onUncaughtException(Connection connection, Throwable error) {
        log.error("WebClient Uncaught Exception: connection={}", connection, error);
    }

}