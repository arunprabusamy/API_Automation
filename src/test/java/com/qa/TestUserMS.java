package com.qa;

import com.qa.base.TestBase;
import com.qa.client.RequestClient;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestUserMS extends TestBase {
    String  url;
    RequestClient req = new RequestClient();

    @Test
    public void getAllUser() throws IOException {
        url = prop.getProperty("baseUrl") + prop.getProperty("users_endpoint");
        req.getRequest(url);
//        System.out.println();
    }


}
