package com.mylibraries.feign.decoders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;
import java.lang.reflect.Type;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

public class CustomJacksonDecoder implements Decoder {

    private static final JavaTimeModule JAVA_TIME_MODULE = new JavaTimeModule();
    private static final ObjectMapper MAPPER = Jackson2ObjectMapperBuilder.json()
            .modules(JAVA_TIME_MODULE)
            .serializationInclusion(NON_NULL)
            .featuresToDisable(WRITE_DATES_AS_TIMESTAMPS)
            .build();
    private static final ObjectFactory<HttpMessageConverters> OBJECT_FACTORY =
            () -> new HttpMessageConverters(new MappingJackson2HttpMessageConverter(MAPPER));
    private static final ResponseEntityDecoder DELEGATE = new ResponseEntityDecoder(new SpringDecoder(OBJECT_FACTORY));

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {

        return DELEGATE.decode(response, type);
    }
}
