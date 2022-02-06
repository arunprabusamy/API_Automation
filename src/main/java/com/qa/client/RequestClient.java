package com.qa.client;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class RequestClient {

    public CloseableHttpResponse getRequest(String requestUrl) throws IOException {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpGet httpget = new HttpGet(requestUrl);
        CloseableHttpResponse httpresponse = httpclient.execute(httpget);
        return httpresponse;
    }

    public CloseableHttpResponse getRequest(String requestUrl, Map<String, String>  requestHeader) throws IOException {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpGet httpget = new HttpGet(requestUrl);
        for (Map.Entry<String, String> header: requestHeader.entrySet()){
            httpget.addHeader(header.getValue(), header.getKey());
        }

        CloseableHttpResponse httpresponse = httpclient.execute(httpget);
        return httpresponse;
    }

}
