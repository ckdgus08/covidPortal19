package com.covidPotar19.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class DetailService {

    Logger logger = LoggerFactory.getLogger(DetailService.class);

    public String getJsonData(int pageNo, int numOfRows, int startCreateDt, int endCreateDt) {

        BufferedReader br = null;
        String SERVICE_KEY = "Y%2Fp5JLBmrkILvFkISB3Yp282tJ9n4Syw7T6U7rK5JjokV53hvlumKQOVZW%2FK9tGdJtL4HUW6IB1%2Bmr59et%2B9sQ%3D%3D";

        try {

            String urlstr = "http://openapi.data.go.kr/openapi/service/rest/Covid19"
                    + "?ServiceKey=" + SERVICE_KEY
                    + "&pageNo=" + pageNo
                    + "&numOfRows=" + numOfRows
                    + "&startCreateDt=" + startCreateDt
                    + "&endCreateDt=" + endCreateDt;

            URL url = new URL(urlstr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                urlConnection.setRequestMethod("GET");
                br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));

                String result = "";
                String line;
                while ((line = br.readLine()) != null) {
                    result = result + line;
                }

//                JsonParser jsonParser = new JsonParser();
//                JsonObject k = (JsonObject) jsonParser.parse(result);
//
//                String name = k.get("name").getAsString();


                return result;

            } else {
                throw new IllegalStateException("http 연결 실패 !!! ");
            }


        } catch (Exception e) {
        }
        return "http 연결 실패 !!! ";

    }

}
