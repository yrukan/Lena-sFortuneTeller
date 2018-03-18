package by.htp.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.htp.fortuneteller.bean.Client;
import by.htp.fortuneteller.bean.ClientDateComparator;

public class Test2 {
	
	private ClientDateComparator cmp;
	private Client client1;
	private Client client2;

	@Before
	public void initData(){
		cmp = new ClientDateComparator();
		client1 = new Client("Ivan", "Petrov", 18);
		client2 = new Client("Ivan", "Petrov", 18);
	}
	@Test
	//check that there are less than 2 predictions per day for the one client
	public void test() {
		initData();
		int result = cmp.compare(client1, client2);
		assertTrue(result == 0);
	}

}
