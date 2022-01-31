package com.qa.client;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class RequestClient {

    public void getRequest(String requestUrl) throws IOException {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpGet httpget = new HttpGet("http://www.tutorialspoint.com/");
        HttpResponse httpresponse = httpclient.execute(httpget);
        System.out.println("Response:"+httpresponse.getEntity().getContent());
    }

}
