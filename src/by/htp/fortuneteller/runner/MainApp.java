package by.htp.fortuneteller.runner;

import by.htp.fortuneteller.bean.Client;
import by.htp.fortuneteller.logic.impl.FortuneTellerServiceImpl;

public class MainApp {

	public static void main(String[] args) {
		
		Client cl = new Client("Ivan", "Petrov", 18);
		Client cl1 = new Client("Ivan", "Petrov", 18);
		Client cl2 = new Client("Ilja", "Bobrov", 19);
		Client cl3 = new Client("Ilja", "Bobrov", 19);

		FortuneTellerServiceImpl fc = new FortuneTellerServiceImpl();
		fc.inite();
		fc.Fortune(cl, "Love");
		fc.Fortune(cl1, "Love");
		fc.Fortune(cl2, "Luck");
		fc.Fortune(cl3, "Work");
		
	}
}