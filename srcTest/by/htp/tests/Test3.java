package by.htp.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import by.htp.fortuneteller.bean.Chamomile;

public class Test3 {

	private Chamomile cam;
	
	@Before
	public void initData(){
		cam = new Chamomile();
	}
	
	
	@Test	
	//Check that camomile has correct number of petals
	public void test() {
		int result = cam.getPetalCount();
		assertTrue(result == 0 || result == 4);
	}

}
