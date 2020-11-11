package com.covidPotar19.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
            String urlstr = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"
                    + "?serviceKey=" + SERVICE_KEY
                    + "&pageNo=" + pageNo
                    + "&numOfRows=" + numOfRows
                    + "&startCreateDt=" + startCreateDt
                    + "&endCreateDt=" + endCreateDt;

            URL url = new URL(urlstr);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));

            String result = "";

//            String line;
//            while ((line = br.readLine()) != null) {
//                result = result + line;
//            }
//

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(urlstr);

            NodeList nList = doc.getElementsByTagName("item");

            for(int temp = 0; temp < nList.getLength(); temp++){
                Node nNode = nList.item(temp);
                if(nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    result += "######################" + "\n";
                    result += ("기준일  : " + getTagValue("stateDt", eElement))+ "\n";
                    result += ("기준시간  : " + getTagValue("stateTime", eElement))+ "\n";
                    result += ("확진자수  : " + getTagValue("decideCnt", eElement))+ "\n";
                    result += ("격리해제수 : " + getTagValue("clearCnt", eElement))+ "\n";
                    result += ("검사진행수  : " + getTagValue("examCnt", eElement))+ "\n";
                    result += ("사망자수  : " + getTagValue("deathCnt", eElement))+ "\n";
                    result += ("치료중환자수  : " + getTagValue("careCnt", eElement))+ "\n";
                    result += ("결과음성수  : " + getTagValue("resutlNegCnt", eElement))+ "\n";
                    result += ("누적검사수 : " + getTagValue("accExamCnt", eElement))+ "\n";
                    result += ("누적검사완료수  : " + getTagValue("accExamCompCnt", eElement))+ "\n";
                    result += ("누적확진률  : " + getTagValue("accDefRate", eElement))+ "\n";
                    result += ("등록일시분초  : " + getTagValue("createDt", eElement))+ "\n";
                    result += ("수정일시분초  : " + getTagValue("updateDt", eElement))+ "\n";
                }	// for end
            }	// if end

            return result;

        } catch (Exception e) {
        }
        return "http 연결 실패 !!! ";

    }

    private static String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if(nValue == null)
            return null;
        return nValue.getNodeValue();
    }

}
