package com.pouillos.sortirnice.utils;

public class BasicUtils {

    public static String afficherChiffre(int valeur) {
        String str = "";
        if (valeur<10) {
            str+="0";
        }
        str+=valeur;
        return str;
    }
}
