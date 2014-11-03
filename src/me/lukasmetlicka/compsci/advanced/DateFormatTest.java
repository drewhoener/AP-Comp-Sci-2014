package me.lukasmetlicka.compsci.advanced;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatTest {

	public static void main(String[] args) {

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date curDate = Calendar.getInstance().getTime();
		System.out.println(df.format(curDate));

	}

}
