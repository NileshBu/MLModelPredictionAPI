package com.assignment.ml.mlModel.service;

import com.assignment.ml.mlModel.exception.CorruptDataException;

import com.assignment.ml.mlModel.utils.ConstantTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PredictionServiceTest {

    @InjectMocks
    PredictionService predictionService;

    @Mock
    RestTemplate restTemplate;

    @Test
    public void testPredictOutcomeValid()  {
        //Assertion
        Assertions.assertThrows(CorruptDataException.class, () -> {
            predictionService.predictOutcome(ConstantTest.INVALID_JSON);
        });
    }

    

}
