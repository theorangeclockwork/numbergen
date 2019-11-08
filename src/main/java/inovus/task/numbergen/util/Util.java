package inovus.task.numbergen.util;


public class Util {

    private final static String letters = "АВЕКМНОРСТУХ";
    private final static String regionalCode = "116 RUS";

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

    public static String getAlphanumericCode(int id) {
        StringBuilder letterCode = new StringBuilder(getLetterCode(id));
        StringBuilder numericCode = new StringBuilder(String.valueOf(id % 1000));
        while (numericCode.length() < 3) {
            numericCode.insert(0, '0');
        }
        letterCode.insert(1, numericCode);
        letterCode.append(" " + regionalCode);
        return String.valueOf(letterCode);
    }

    //Получить последовательность букв автомобильного номера в соответствии с его порядковым номером id
    public static String getLetterCode(int id) {
        StringBuilder code = new StringBuilder(Util.convertDecimalToBase(id / 1000, letters));
        while (code.length() < 3) {
            code.insert(0, 'A');
        }
        return String.valueOf(code);
    }


}
