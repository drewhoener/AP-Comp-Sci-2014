package me.drewhoener.compsci.advanced;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatTest {

    public static void main(String[] args) {

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date curDate = Calendar.getInstance().getTime();
        System.out.println(df.format(curDate));


        System.out.println();
        System.out.println();


        double time = 590 / 60;

        int hours = (int) time;
        double minutes = ((time - hours) * 60);
        int minutesInt = (int) minutes;

        System.out.println(new DecimalFormat("#.00").format(590D / 60D));


    }

}
