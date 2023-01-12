package com.romanov.gateway.repository;

import com.romanov.gateway.config.AppParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.Resource;

@org.springframework.stereotype.Repository
public class Repository {
    @Resource
    public WebClient webClient;

    @Autowired
    public AppParams params;
}
