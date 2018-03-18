package by.htp.fortuneteller.logic.impl;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import by.htp.fortuneteller.bean.Chamomile;
import by.htp.fortuneteller.bean.Client;
import by.htp.fortuneteller.bean.ClientDateComparator;
import by.htp.fortuneteller.logic.FortuneTellerService;

public class FortuneTellerServiceImpl implements FortuneTellerService {
	private LinkedList<Chamomile> listChamomile = new LinkedList<>();
	private HashMap<String, List<String>> hm = new HashMap<>();
	private Set<Client> treeSetClient = new TreeSet<>(new ClientDateComparator());

	public FortuneTellerServiceImpl() {

	}

	// private methode
	private boolean clientVerify(Client cl) {
		return treeSetClient.contains(cl);
	}

	private List<String> GetFortune(String nameType) {
		return hm.get(nameType);
	}

	public Chamomile GetChamomile() {
		return listChamomile.isEmpty() ? null : listChamomile.getLast();
	}

	public void initChamomile() {
		int lenght = (int) (Math.random() * 10);
		if (lenght == 0) {
			lenght = 4;
		}
		for (int i = 0; i < lenght; i++)
			listChamomile.add(new Chamomile());
	}

	public void initFortune() {
		hm.put("Love", Arrays.asList("not love", "love", "enfold", "it's a bad day for love"));
		hm.put("Work", Arrays.asList("this month is not work", "growth of salary", "decrease of salary"));
		hm.put("Luck", Arrays.asList("all month is luck", "not luck all year", "luck in love"));
	}

	// public method
	public void inite() {
		initChamomile();
		initFortune();
	}

	public String getResultFotune(List<String> ls, Chamomile chm) {

		int res = chm.getPetalCount() % ls.size();
		String rs;
		if (res != 0) {
			rs = ls.get(res - 1);
		} else {
			rs = ls.get(ls.size() - 1);
		}
		return rs;

	}

	public void Fortune(Client cl, String nametype) {
		String str = getFortune(cl, nametype);
		System.out.println(str);
	}

	@Override
	public String getFortune(Client cl, String nametype) {
		cl.setLastDate(new Date());
		if (this.clientVerify(cl))
			return "fortune is not possibly today";
		List<String> ls = null;
		ls = GetFortune(nametype);
		if (ls == null)
			return "the type of fortune is not find";
		Chamomile chm = null;
		chm = GetChamomile();
		if (chm == null)
			return "the chamomille are expired today";
		String res = getResultFotune(ls, chm);
		treeSetClient.add(cl);
		listChamomile.remove(chm);
		return res;

	}

}