package com.assignment.ml.mlModel.controller;

import com.assignment.ml.mlModel.exception.CorruptDataException;
import com.assignment.ml.mlModel.service.PredictionService;
import com.assignment.ml.mlModel.utils.ConstantTest;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PredictionControllerTest {

    @InjectMocks
    PredictionController predictionController;

    @Mock
    PredictionService predictionService;


    @Test
    public void testPredictOutcomeValid() throws JsonProcessingException {

        // When
        Mockito.when(predictionService.predictOutcome(ConstantTest.JSON1))
                .thenReturn(Arrays.asList(ConstantTest.RESULT).toString());

        ResponseEntity<String> resultOutCome = predictionController.predictOutcome(ConstantTest.JSON1);

        // Assertions
        assertNotNull(resultOutCome);
        assertEquals(resultOutCome.getBody(), ConstantTest.OUTCOME_RESULT);

        // verification
        verify(predictionService, times(1))
                .predictOutcome(ConstantTest.JSON1);

    }

    @Test
    public void testPredictOutcomeInValid() throws JsonProcessingException {

        // When
        Mockito.when(predictionService.predictOutcome(ConstantTest.INVALID_JSON)).thenThrow(
                new CorruptDataException(
                        "Age is not Valid "));

        // Assertions
        Assertions.assertThrows(CorruptDataException.class, () -> {
            predictionController.predictOutcome(
                    ConstantTest.INVALID_JSON);
        });

        // verification
        verify(predictionService, times(1))
                .predictOutcome(ConstantTest.INVALID_JSON);


    }

}
