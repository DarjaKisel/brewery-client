package com.dzinevich.breweryclient.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "client.config", ignoreUnknownFields = false)
public class ClientConfiguration {
    private int maxTotalConnections;
    private int maxConnectionsPerRoute;
    private int connectionRequestTimeout;
    private int connectionSocketTimeout;
}
