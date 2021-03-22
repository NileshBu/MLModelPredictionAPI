package com.assignment.ml.mlModel.service;

import com.assignment.ml.mlModel.aspectj.LogInputOutput;
import com.assignment.ml.mlModel.exception.CorruptDataException;
import com.assignment.ml.mlModel.model.RawData;
import com.assignment.ml.mlModel.utils.Constant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Slf4j
public class PredictionService {

    @LogInputOutput
    public String predictOutcome(String rawData) throws JsonProcessingException {

        Map<Integer,String> resultMap = processData(rawData);
        List<String> results = modelResult(resultMap);
        return results.toString();

    }

    private Map<Integer,String> processData(String rawData) {
        Gson gson = new Gson();
        JSONObject jsonobject = new JSONObject(rawData);
        JSONArray jsonArray = jsonobject.getJSONArray(Constant.DATA);
        Map<Integer,String> results = new HashMap<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject rawDataObject = jsonArray.getJSONObject(i);
            RawData rawDataConverted = gson.fromJson(String.valueOf(rawDataObject), RawData.class);
            validateData(rawDataConverted);
            String prediction = predictResult(rawDataObject);
            results.put(rawDataConverted.getId(),prediction);
        }
        return results;

    }


    private void validateData(RawData rawDataConverted) {

        if(rawDataConverted.getAge()<=0){
            throw new CorruptDataException("Age is not Valid ");
        }
        if(rawDataConverted.getLastContactDay()<=0){
            throw new CorruptDataException("Last Contact Day is not Valid ");
        }
        if(rawDataConverted.getHHInsurance()<0){
            throw new CorruptDataException("Last HH Insurance is not Valid ");
        }
        if(rawDataConverted.getCarLoan()<0){
            throw new CorruptDataException("Last Car Loan is not Valid ");
        }
        if(rawDataConverted.getNoOfContacts()<0){
            throw new CorruptDataException("Last Number of Contact is not Valid ");
        }
        if(rawDataConverted.getPrevAttempts()<0){
            throw new CorruptDataException("Last Prev Attempt is not Valid ");
        }
        if(rawDataConverted.getLastContactMonth().equalsIgnoreCase("NA")){
            throw new CorruptDataException("Last LAst Contact Month is not Valid ");
        }
        if(rawDataConverted.getCallStart().equalsIgnoreCase("NA")){
            throw new CorruptDataException("Last  Call Start Date is not Valid ");
        }
        if(rawDataConverted.getCallEnd().equalsIgnoreCase("NA")){
            throw new CorruptDataException("Last  Call End Date is not Valid ");
        }

    }


    private String predictResult(JSONObject rawDataObject) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(rawDataObject.toString(),headers);
        String prediction = restTemplate.postForObject(Constant.URI, entity, String.class);
        if(prediction.trim().equalsIgnoreCase("\"[1]\"")){
            return Constant.SUCCESS;
        }
        else{
            return Constant.FAILURE;
        }
    }

    private List<String>  modelResult(Map<Integer, String> resultMap) {

        Iterator it = resultMap.entrySet().iterator();
        List<String> resultList = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            StringBuffer sb = new StringBuffer("The Outcome for DataSet with Id : ");
            sb.append("'"+pair.getKey()+"'");
            sb.append(" Is Predicted that it would be a : ");
            sb.append("'"+pair.getValue()+"'");
            sb.append(System.lineSeparator());
            resultList.add(sb.toString());
        }
        return resultList;

    }

}
