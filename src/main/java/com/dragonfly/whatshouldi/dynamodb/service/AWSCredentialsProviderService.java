package com.dragonfly.whatshouldi.dynamodb.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

@Service
@RequiredArgsConstructor
public class AWSCredentialsProviderService implements AWSCredentialsProvider {

    public static ThreadLocal<AWSCredentialsProvider> awsCredentailProviderThreadLocal = new ThreadLocal<AWSCredentialsProvider>();

    /**
     * Gets instance.
     *
     * @param credentialAccessKey
     *            the credential access key
     * @param credentialSecretKey
     *            the credential secret key
     * @return the instance
     */
    public static AWSCredentialsProvider getInstance() {
        return awsCredentailProviderThreadLocal.get();
    }

    @Override
    public AWSCredentials getCredentials() {
        return getInstance().getCredentials();
    }

    @Override
    public void refresh() {
        // TODO Auto-generated method stub
    }

}
