package by.htp.tests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import by.htp.fortuneteller.bean.Client;
import by.htp.fortuneteller.bean.ClientDateComparator;
import by.htp.fortuneteller.logic.impl.FortuneTellerServiceImpl;

public class Test2 {
	
	private FortuneTellerServiceImpl fortune;
	private Client client;	
	private Set<Client> treeSetClient;

	@Before
	public void initData() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date date = df.parse("13-01-2001");		
		client = new Client("Ivan", "Petrov", 18, date);
		fortune = new FortuneTellerServiceImpl(); 
		treeSetClient = new TreeSet<>(new ClientDateComparator());
	}
	
	@Test
	//check that there are less than 2 predictions per day for the one client
	public void test() {
		
		treeSetClient.add(client);
		fortune.setTreeSetClient(treeSetClient);
		boolean result = fortune.clientVerify(client);
		assertTrue(result);
	}

}
