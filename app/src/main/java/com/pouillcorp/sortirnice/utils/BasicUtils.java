package com.pouillcorp.sortirnice.utils;

public class BasicUtils {

    public static String afficherChiffre(int valeur) {
        String str = "";
        if (valeur<10) {
            str+="0";
        }
        str+=valeur;
        return str;
    }

    public static String stringRaccourci(String string, int limit) {
        String reponse = string;
        if (string.length()>limit+1) {
            reponse = string.substring(0, limit)+"...";
        }
        return reponse;
    }
}
