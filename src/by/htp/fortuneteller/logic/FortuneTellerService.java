package by.htp.fortuneteller.logic;

import java.util.List;

import by.htp.fortuneteller.bean.Chamomile;
import by.htp.fortuneteller.bean.Client;

public interface FortuneTellerService {
	
	String getFortune(Client cl, String nametype);
	void Fortune(Client cl, String nametype);
	

}
