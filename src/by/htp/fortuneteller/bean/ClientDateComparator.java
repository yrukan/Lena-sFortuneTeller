package by.htp.fortuneteller.bean;

import java.util.Comparator;
import java.util.Date;

public class ClientDateComparator implements Comparator<Client> {

	@Override
	public int compare(Client o1, Client o2) {
		if (o1.getSurname().compareTo(o2.getSurname()) == 0) {
			if (o1.getName().compareTo(o2.getName()) == 0) {
				if(o1.getLastDate().compareTo(o2.getLastDate()) == 0)	{
					return 0;
				}
			}
		}
		return -1;
	}
}
