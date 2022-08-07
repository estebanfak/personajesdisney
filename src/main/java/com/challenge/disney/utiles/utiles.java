package com.challenge.disney.utiles;

public class utiles {
    public static String modificarPalabras(String parametro){
        return parametro
                .toLowerCase()
                .replace('á', 'a')
                .replace('é', 'e')
                .replace('í', 'i')
                .replace('ó', 'o')
                .replace('ú', 'u')
                .replace('ñ', 'n')
                .replace('ü', 'u');
    }
}