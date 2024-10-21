package com.xyz.tennistrack.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.xyz.tennistrack.customSerializer.EmptyStringAsDoubleDeserializer;
import com.xyz.tennistrack.customSerializer.EmptyStringAsIntegerDeserializer;
import com.xyz.tennistrack.customSerializer.EmptyStringAsStringDeserializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule mod = new SimpleModule();
        //mod.addDeserializer(Integer.class, new EmptyStringAsIntegerDeserializer());
        //mod.addDeserializer(Double.class, new EmptyStringAsDoubleDeserializer());
        mod.addDeserializer(String.class, new EmptyStringAsStringDeserializer());
        mapper.registerModule(mod);

        return mapper;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate rt = new RestTemplate();

        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        converter.setObjectMapper(objectMapper());

        rt.getMessageConverters().add(converter);

        return rt;
    }


}
