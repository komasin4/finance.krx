package com.komasin4.finance.krx.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.komasin4.finance.krx.model.ETFInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class ProductInfoGather {

    @Value("${enc.test}")
    private String encString;

    public static void main(String[] args) {
        System.out.println("test");
        ProductInfoGather pig = new ProductInfoGather();
        //pig.test();
        pig.printEnc();
    }

    public void printEnc() {
        log.debug("encString:" + encString);
    }

    public void test()   {
        String url = "https://data.krx.co.kr/comm/bldAttendant/getJsonData.cmd?mktsel=ETF&bld=dbms/comm/finder/finder_secuprodisu";
        WebClient webClient = WebClient.create(url);

        String responseBody = webClient.get().retrieve().bodyToMono(String.class).block();
//        Mono<ETFInfo[]> responseBody = webClient.get().accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(ETFInfo[].class).log();
//        System.out.println("1.------" + responseBody);
//        ETFInfo[] etfs = responseBody.block();
//        System.out.println("2.------" + etfs);

        log.debug("responseBody:" + responseBody);

        Gson gson = new Gson();

        JsonObject json = gson.fromJson(responseBody, JsonObject.class);

        JsonArray etfList = json.getAsJsonArray("block1");

        int index = 0;
        for(JsonElement etf:etfList) {
            ETFInfo etfInfo = gson.fromJson(etf, ETFInfo.class);
            log.debug((index++) + ":" + etf.toString());
        }
    }
}
