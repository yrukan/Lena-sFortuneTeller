package by.htp.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import by.htp.fortuneteller.bean.Client;
import by.htp.fortuneteller.logic.impl.FortuneTellerServiceImpl;

public class Test1 {
	
	private HashMap<String, List<String>> hm = new HashMap<>();
	private String predictionType = "Love";
	private String[] predictions = {"not love", "love", "enfold", "it's a bad day for love"};
	private FortuneTellerServiceImpl service; 
	private Client cl;
	private boolean result;
	
	@Before
	public void initFortune() {
		hm.put(predictionType, Arrays.asList(predictions));
		cl = new Client("Ivan", "Petrov", 18);
		service = new FortuneTellerServiceImpl();
		result = false;
	}
	
	@Test
	//check that prediction is selected from correct type of predictions 
	public void test() {
		
		initFortune(); 
		String prediction = service.getFortune(cl, predictionType);
		result = hm.containsValue(prediction);
		assertTrue(result ==  true);
		
		}

}
