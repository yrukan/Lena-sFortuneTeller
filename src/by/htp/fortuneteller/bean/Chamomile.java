package by.htp.fortuneteller.bean;

import java.util.LinkedList;
import java.util.ListIterator;

public class Chamomile {

	private LinkedList<Petal> listPetal = new LinkedList<>();

	public Chamomile() {
		int lenght = (int) (Math.random() * 10);
		if (lenght == 0) {
			lenght = 4;
		}
		for (int i = 0; i < lenght; i++)
			listPetal.add(new Petal(i));
	}

	public int getPetalCount() {
		return listPetal.size();
	}

	public int removePetal(int count) {
		int number = 0;
		if (listPetal.size() > count) {
			ListIterator<Petal> it = listPetal.listIterator(0);
			int i = 0;
			while (i < count) {
				Petal pt = (Petal) it.next();
				number = pt.getNumber();
				it.remove();
				i++;
			}
		}
		return number;
	}

}
