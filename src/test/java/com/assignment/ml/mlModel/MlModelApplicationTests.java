package com.assignment.ml.mlModel;

import com.assignment.ml.mlModel.controller.PredictionController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
class MlModelApplicationTests {

	@Autowired
	PredictionController controller;

	@Test
	void contextLoads() {
		assertNotNull(controller);

	}


}
