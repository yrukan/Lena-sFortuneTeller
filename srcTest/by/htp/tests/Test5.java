package by.htp.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.htp.fortuneteller.bean.Client;
import by.htp.fortuneteller.logic.impl.FortuneTellerServiceImpl;

public class Test5 {
	
    private FortuneTellerServiceImpl service;
    private Client client;
    private HashMap<String, List<String>> hm = new HashMap<>();
	private String predictionType = "Love";
	private String[] predictions = {"not love", "love", "enfold", "it's a bad day for love"};

	
	@Before
	public void initData(){
		service = new FortuneTellerServiceImpl();		
		hm.put(predictionType, Arrays.asList(predictions));
		client = new Client("Ivan", "Petrov", 18);
	}

	@Test
	//Check that client got prediction
	public void test() {
		String result = service.getFortune(client, predictionType);
		assertTrue(result != null);
	}

}
