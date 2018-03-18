package by.htp.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import by.htp.fortuneteller.bean.Chamomile;
import by.htp.fortuneteller.logic.impl.FortuneTellerServiceImpl;

public class Test4 {

	 
	private FortuneTellerServiceImpl service;
	
	@Before
	public void initData(){
		service = new FortuneTellerServiceImpl();
		service.initChamomile();
	}
	
	@Test
	//check that there is not empty list of flowers for prediction
	public void test() {
		initData();
		Chamomile result = service.GetChamomile();
		assertTrue(result != null);
	}

}
