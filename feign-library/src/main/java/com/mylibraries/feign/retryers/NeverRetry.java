package com.mylibraries.feign.retryers;

import feign.RetryableException;
import feign.Retryer;

public class NeverRetry implements Retryer {

    @Override
    public void continueOrPropagate(final RetryableException e) {

        NEVER_RETRY.continueOrPropagate(e);
    }

    @Override
    public Retryer clone() {

        return NEVER_RETRY.clone();
    }
}
