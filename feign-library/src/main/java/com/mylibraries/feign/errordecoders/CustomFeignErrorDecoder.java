package com.mylibraries.feign.errordecoders;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomFeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder delegate = new Default();

    @Override
    public Exception decode(final String s, final Response response) {

        return this.delegate.decode(s, response);
    }
}
