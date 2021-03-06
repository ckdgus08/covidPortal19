package com.covidPotar19.service;

import com.covidPotar19.domain.Detail;
import com.covidPotar19.repository.DetailRepository;
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
import java.util.ArrayList;
import java.util.List;

@Service
public class DetailService {

    private final DetailRepository detailRepository;
    Logger logger = LoggerFactory.getLogger(DetailService.class);

    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    private String getTagValue(String tag, Element eElement) {
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }

    public List<Detail> getDetail(int start, int end) {

        if (start < 20200000 || end > 20210000) {
            throw new IllegalStateException("api 통신 실패!");
        }

        List<Detail> result = new ArrayList<>();

        for (int i = start; i <= end; i++) {

            Detail detailFromStateDt = detailRepository.getDetailFromStateDt(i);
            if (detailFromStateDt != null) {
                result.add(detailFromStateDt);
            } else {
                List<Detail> detail = getJsonData(i, end);
                for (Detail d : detail) {
                    if(detailRepository.getDetailFromStateDt(d.getStateDt()) == null) {
                        detailRepository.saveDetail(d);
                        result.add(d);
                    }
                }
                return result;
            }

        }

        return result;
    }

    public List<Detail> getJsonData(int startCreateDt, int end) {

        BufferedReader br = null;
        String SERVICE_KEY = "OaY9khv9WTK0x96WqjSs260MzhdYxPKlJS0rYrOEDIYZBkKyprEgM0JzEcm5mQorMI7n%2BInSVIsQSQ3DxPDxOQ%3D%3D";
//        String SERVICE_KEY = "xKzn86%2FQvwa1b%2FvD5bQDzMN8SdVg5wj21glqBrTC7ahEwhbAfzTaosdpLIsvwOgGT2lx1dMfykoVamxeM6f8uQ%3D%3D";

        int pageNo = 1;
        int numOfRows = 50;
        List<Detail> list = new ArrayList<>();

        try {
            String urlstr = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19InfStateJson"
                    + "?serviceKey=" + SERVICE_KEY
                    + "&pageNo=" + pageNo
                    + "&numOfRows=" + numOfRows
                    + "&startCreateDt=" + startCreateDt
                    + "&endCreateDt=" + end;

            URL url = new URL(urlstr);

            logger.info(urlstr);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));

//            String line;
//            while ((line = br.readLine()) != null) {
//                result = result + line;
//            }
//


            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(urlstr);

            NodeList nList = doc.getElementsByTagName("item");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Detail result = new Detail();
                    result.setStateDt(Integer.parseInt(getTagValue("stateDt", eElement)));
                    result.setStateTime(getTagValue("stateTime", eElement));
                    result.setDecideCnt(getTagValue("decideCnt", eElement));
                    result.setClearCnt(getTagValue("clearCnt", eElement));
                    result.setExamCnt(getTagValue("examCnt", eElement));
                    result.setDeathCnt(getTagValue("deathCnt", eElement));
                    result.setCareCnt(getTagValue("careCnt", eElement));
                    result.setResutlNegCnt(getTagValue("resutlNegCnt", eElement));
                    result.setAccExamCnt(getTagValue("accExamCnt", eElement));
                    result.setAccExamCompCnt(getTagValue("accExamCompCnt", eElement));
                    result.setAccDefRate(getTagValue("accDefRate", eElement));
                    result.setCreateDt(getTagValue("createDt", eElement));
                    result.setUpdateDt(getTagValue("updateDt", eElement));

                    list.add(result);

                }    // for end
            }    // if end


        } catch (Exception e) {
            throw new IllegalStateException("api 통신 실패!");
        }
        return list;

    }

}
