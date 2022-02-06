package com.qa;

import com.qa.base.TestBase;
import com.qa.client.RequestClient;
import com.qa.utils.jsonParser;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class TestUserMS extends TestBase {
    String  url;
    RequestClient req = new RequestClient();
    CloseableHttpResponse   httpresponse;

    @Test
    public void getAllUser() throws IOException {
        url = prop.getProperty("baseUrl") + prop.getProperty("users_endpoint");
        httpresponse=   req.getRequest(url);

        System.out.println("Response code:"+httpresponse.getStatusLine());

        String responseBody = EntityUtils.toString(httpresponse.getEntity(), StandardCharsets.UTF_8);
        JSONObject response = new JSONObject(responseBody);
        System.out.println("Response Msg\n"+response.get("per_page"));

        Header[] headerArr = httpresponse.getAllHeaders();
        Map<String,String> headerMap = new HashMap<>();

        for(Header header: headerArr){
            headerMap.put(header.getName(),header.getValue());
        }
        System.out.println("\n\nheaders:\n"+ headerMap);
    }


    @Test
    public void getAllUserWithHeader() throws IOException {
        url = prop.getProperty("baseUrl") + prop.getProperty("users_endpoint");

        Map<String,String> requestHeader = new HashMap<>();
        requestHeader.put("Content-Type", "application/json");

        httpresponse=   req.getRequest(url, requestHeader);
        Assert.assertEquals(httpresponse.getStatusLine().getStatusCode(), STATUS_CODE_200, "Status is  not 200");

        String response =  EntityUtils.toString(httpresponse.getEntity());
        JSONObject responseJson = new JSONObject(response);

        System.out.println(response + "\n\n");
        String actVal = jsonParser.getValueFromJson_simple(responseJson, "data[0]\\id");

        System.out.println(actVal);
    }




}
