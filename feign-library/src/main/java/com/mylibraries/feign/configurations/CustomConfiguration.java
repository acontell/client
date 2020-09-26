package com.mylibraries.feign.configurations;

import com.mylibraries.feign.decoders.CustomJacksonDecoder;
import com.mylibraries.feign.errordecoders.CustomFeignErrorDecoder;
import feign.Contract;
import feign.Feign;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.clientconfig.FeignClientConfigurer;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;

public class CustomConfiguration {

    @Bean
    public Encoder feignEncoder(final ObjectFactory<HttpMessageConverters> messageConverters) {

        return new SpringEncoder(messageConverters);
    }

    @Bean
    public Decoder feignDecoder() {

        return new CustomJacksonDecoder();
    }

    @Bean
    public Retryer retryer() {

        return Retryer.NEVER_RETRY;
    }

    @Bean
    public Contract feignContract() {

        return new SpringMvcContract();
    }

    @Bean
    public ErrorDecoder errorDecoder() {

        return new CustomFeignErrorDecoder();
    }

    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

    @Bean
    public FeignClientConfigurer feignClientConfigurer() {

        return new FeignClientConfigurer() {

            @Override
            public boolean inheritParentConfiguration() {

                return false;
            }
        };
    }
}
