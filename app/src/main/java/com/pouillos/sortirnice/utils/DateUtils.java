package com.pouillos.sortirnice.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {

    public static String formatDateYYYY_MM_DD(Date date) {
        String reponse = "";
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
        reponse += dt1.format(date);
        return reponse;
    }

    public static String formatDateDD_MM_YYYY(String date) {
        //creer date depuis string en premier
       /* Date tradeDate = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(date);
        String reponse = "";
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        reponse += dt1.format(date);*/
       String reponse = date.substring(8,10)+"/"+date.substring(5,7)+"/"+date.substring(0,4);


        return reponse;
    }

    public static Date calculerVeille(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        Date reponse = calendar.getTime();
        return reponse;
    }

    public static Date calculerXJourPrecedent(Date date,int nbJour) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,-nbJour);
        Date reponse = calendar.getTime();
        return reponse;
    }

}
