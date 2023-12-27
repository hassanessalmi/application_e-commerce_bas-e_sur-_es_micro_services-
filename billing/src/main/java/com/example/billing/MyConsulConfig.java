package com.example.billing;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "token")
@Data
public class MyConsulConfig {

    private String accessTokenTimeout;

    private String refreshTokenTimeout;
}
