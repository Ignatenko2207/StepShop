package org.itstep.kiev.domain;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.itstep.kiev.DAOLayer.GoodDAO;

public class ShowOurProgBySide {

	public static void main(String[] args){
		/*
		Good good = new Good();
		good.setName("pen");
		good.setPrice(1523);
		GoodDAO.createGood(good.getName(), good.getPrice());
		*/
		Customer customer = new Customer();
		GregorianCalendar gc = new GregorianCalendar(1982, 7, 22);
		long timeInMills = gc.getTimeInMillis();
		customer.setDateOfBirth(timeInMills);
		System.out.println(customer.getDateOfBirth());
	}
}
