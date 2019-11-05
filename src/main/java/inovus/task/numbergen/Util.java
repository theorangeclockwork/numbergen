package inovus.task.numbergen;

import java.util.LinkedList;

public class Util {

    //Перевод десятичного числа в новую систему счисления с алфавтом alphabet
    public static String convertDecimalToBase(int decimal, String alphabet) {
        StringBuilder result = new StringBuilder();
        int remainder; //остаток от деления
        int base = alphabet.length(); //основание системы счисления, в которую осуществляется перевод

        if (decimal == 0) return String.valueOf(alphabet.charAt(0));

        while (decimal != 0) {
            remainder = decimal % alphabet.length();
            decimal = decimal / base; //decimal заменяется на частное от деления
            result.insert(0, alphabet.charAt(remainder));
        }
        return String.valueOf(result);
    }


}
