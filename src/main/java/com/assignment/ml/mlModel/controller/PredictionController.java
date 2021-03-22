package com.assignment.ml.mlModel.controller;

import com.assignment.ml.mlModel.service.PredictionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "PredictionService")
@Slf4j
public class PredictionController {

  private PredictionService predictionService;

  public PredictionController(PredictionService predictionService) {
    this.predictionService = predictionService;
  }

  @ApiOperation(value = "Predict the Outcome of Car Insurance Calling Campaign ", notes = "Gives a Call to ML Model for prediction", response = String.class)
  @PostMapping(path = "/predictOutcome")
  @ResponseStatus(code = HttpStatus.CREATED)
  public ResponseEntity<String> predictOutcome(
      @Valid @RequestBody(required = true) String rawData) throws JsonProcessingException {
    String results = predictionService.predictOutcome(rawData);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/predictCallOutcome/")
        .buildAndExpand(results).toUri();

    return ResponseEntity.created(location).body(results);

  }


}
