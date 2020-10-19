package test;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Prediction;

@RunWith(MockitoJUnitRunner.class)
public class GetQuestionPredictionsMockTest  {

	@Mock
	DataAccess dataAccess = Mockito.mock(DataAccess.class);

	@InjectMocks
	BLFacade sut = new BLFacadeImplementation(dataAccess);

	@Test
	public void test1() {		
		try {
			//test params
			List<Prediction> predictions = new ArrayList<Prediction>();
			predictions.add(new Prediction("F", 4));
			//mockito config
			Mockito.doReturn(predictions).when(dataAccess).getQuestionPredictions(Mockito.anyInt());
			//call sut
			List <Prediction> predictionsReality = sut.getQuestionPredictions(1);
			boolean valid = true;
			if (predictions.size() != predictionsReality.size()) {
				fail();
			} else {
				for (int i = 0; i < predictions.size(); i++) {
					if(!predictions.get(i).equals(predictionsReality.get(i))) {
						fail();
					}
				}
				assertTrue(valid);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void test2() {
		fail();
	}
	@Test
	public void test3() {
		fail();
	}

	@Test
	public void test4() {
		fail();
	}
	
	@Test
	public void test5 () {
		fail();
	}
}
