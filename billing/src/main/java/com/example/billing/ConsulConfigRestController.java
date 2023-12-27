package com.example.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RefreshScope
@RestController

public class ConsulConfigRestController {
   /* @Value("${token.accessTokenTimeout}")
    private String accessTokenTimeout;
    @Value("${token.refreshTokenTimeout}")
    private String   refreshTokenTimeout;
    @GetMapping("/myConfig")
    public Map<String,Object> myConfig(){
        return Map.of("accessTokenTimeout",accessTokenTimeout,"refreshTokenTimeout",refreshTokenTimeout);
    }*/
    @Autowired
    private MyConsulConfig myConsulConfig;
    @Autowired
    private  MyVaultConfig myVaultConfig;
    /*@GetMapping("/myConfig")
    public MyConsulConfig myConfig(){
        return myConfig;
    }*/
    @GetMapping("/myConfig")
    public Map<String,Object> myConfig(){
        return Map.of("consulConfig",myConsulConfig,"vaultConfig",myVaultConfig);
    }
}
