package by.htp.tests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import by.htp.fortuneteller.bean.Client;
import by.htp.fortuneteller.logic.impl.FortuneTellerServiceImpl;

public class Test1 {
	
	private HashMap<String, List<String>> hm = new HashMap<>();;
	private String predictionType = "Love";
	private String[] predictions = {"not love", "love", "enfold", "it's a bad day for love"};
	private FortuneTellerServiceImpl service; 
	private Client cl;	
	
	@Before
	public void initFortune() throws ParseException {		
		hm.put(predictionType, Arrays.asList(predictions));		
		cl = new Client("Ivan", "Petrov", 18);
		service = new FortuneTellerServiceImpl();		
	}
	
	@Test
	//check that prediction is selected from correct type of predictions 
	public void test() {	
		String prediction = service.getFortune(cl, predictionType);
		List<String> list = hm.get(predictionType);
		boolean result = false;
		for(String s: list){
			if(s.compareTo(prediction) == 0){
				result = true;
				break;
			}
		}
		//boolean result = hm.containsValue(prediction);
		assertTrue("Result is not correct: ", result);		
		}

}
