import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Exp userExp = new Exp();
        StringBuilder operand1 = new StringBuilder();
        StringBuilder operand2 = new StringBuilder();
        String operator = "";
        int i = 0; // индекс
        int e = 1; // счётчик
        boolean isArabic = false;
        boolean isRoman = false;

        String inputExp = scanner.nextLine();
        String exp = inputExp.replaceAll(" ", "");

        int lenght = exp.length();
        if (lenght < 3) {
            throw new IllegalArgumentException("Cтрока не является математической операцией");
        } // минимальное кол-во символов = 3

        //блок, определяющий тип первого символа
        char firstChar = exp.charAt(i);

        if (firstChar >= '1' && firstChar <= '9') {
            isArabic = true;
        } else if (firstChar == 'I' || firstChar == 'V' || firstChar == 'X') {
            isRoman = true;
        } else if (firstChar == '0') {
            throw new IllegalArgumentException("операнды должны быть в диапазоне чисел от 1 до 10");
        } else {
            throw new IllegalArgumentException("Cтрока не является приемлемой математической операцией");
        }

        i++; // равно 1
        e++; // равно 2
        operand1.append(firstChar);
        //конец блока, определяющего тип первого символа

        //блок, вычисисляющий выражение с арабскими цифрами
        if (isArabic) {
            while (exp.charAt(i) >= '0' && exp.charAt(i) <= '9' && e < 3) {
                operand1.append(exp.charAt(i));
                i++; //
                e++; //
            }


            int a = Integer.parseInt(operand1.toString());

            if (a > 10) {
                throw new IllegalArgumentException("операнды должны быть в диапазоне чисел от 1 до 10");
            }

            userExp.setA(a);

            char operation = exp.charAt(i);

            operator = String.valueOf(operation);
            userExp.setO(operator);
            i++; // = 3
            e++; // = 4

            if (exp.charAt(i) == 'I' || exp.charAt(i) == 'V' || exp.charAt(i) == 'X') {
                throw new IllegalArgumentException("используются одновременно разные системы счисления");
            }

            while (i < lenght && exp.charAt(i) >= '0' && exp.charAt(i) <= '9') {
                operand2.append(exp.charAt(i));
                i++;
                e++;

            }


            int b = Integer.parseInt(operand2.toString());

            if (b > 10) {
                throw new IllegalArgumentException("операнды должны быть в диапазоне чисел от 1 до 10");
            }

            userExp.setB(b);

            int userResult = userExp.calculation();
            userExp.setR(userResult);

        }
        //конец блока, вычисисляющего выражение с арабскими цифрами

        //блок, вычисисляющий выражение с римскими цифрами
        else {
            while (i < exp.length() && (exp.charAt(i) == 'I' || exp.charAt(i) == 'V' || exp.charAt(i) == 'X')) {
                operand1.append(exp.charAt(i));
                i++;
                e++;
            }

            char operation = exp.charAt(i);
            operator = String.valueOf(operation);
            i++;
            e++;

            if (exp.charAt(i) >= '0' && exp.charAt(i) <= '9') {
                throw new IllegalArgumentException("используются одновременно разные системы счисления");
            }


            while (i < exp.length() && (exp.charAt(i) == 'I' || exp.charAt(i) == 'V' || exp.charAt(i) == 'X')) {
                operand2.append(exp.charAt(i));
                i++;
                e++;
            }

            String r1 = operand1.toString();
            String r2 = operand2.toString();

            int a = 0;
            switch (r1) {
                case "I":
                    a = 1;
                    break;
                case "II":
                    a = 2;
                    break;
                case "III":
                    a = 3;
                    break;
                case "IV":
                    a = 4;
                    break;
                case "V":
                    a = 5;
                    break;
                case "VI":
                    a = 6;
                    break;
                case "VII":
                    a = 7;
                    break;
                case "VIII":
                    a = 8;
                    break;
                case "IX":
                    a = 9;
                    break;
                case "X":
                    a = 10;
                    break;
                default:
                    throw new IllegalArgumentException("операнды должны быть в диапазоне чисел от 1 до 10");
            }

            int b = 0;
            switch (r2) {
                case "I":
                    b = 1;
                    break;
                case "II":
                    b = 2;
                    break;
                case "III":
                    b = 3;
                    break;
                case "IV":
                    b = 4;
                    break;
                case "V":
                    b = 5;
                    break;
                case "VI":
                    b = 6;
                    break;
                case "VII":
                    b = 7;
                    break;
                case "VIII":
                    b = 8;
                    break;
                case "IX":
                    b = 9;
                    break;
                case "X":
                    b = 10;
                    break;
                default:
                    throw new IllegalArgumentException("операнды должны быть в диапазоне чисел от 1 до 10");
            }

            userExp.setA(a);
            userExp.setB(b);
            userExp.setO(operator);
            int userResult = userExp.calculation();
            userExp.setR(userResult);
        }
        //конец блока, вычисисляющего выражение с римскими цифрами

        if (isArabic) {
            System.out.println(userExp.result);

        } else if (isRoman) {
            StringBuilder input = new StringBuilder();
            int p = userExp.result;


            if (p < 0) {
                throw new IllegalArgumentException("в римской системе нет отрицательных чисел");
            }



            switch (p) {
                case 1:
                    input.append("I");
                    break;
                case 2:
                    input.append("II");
                    break;
                case 3:
                    input.append("III");
                    break;
                case 4:
                    input.append("IV");
                    break;
                case 5:
                    input.append("V");
                    break;
                case 6:
                    input.append("VI");
                    break;
                case 7:
                    input.append("VII");
                    break;
                case 8:
                    input.append("VIII");
                    break;
                case 9:
                    input.append("IX");
                    break;
                case 10:
                    input.append("X");
                    break;
                case 11:
                    input.append("XI");
                    break;
                case 12:
                    input.append("XII");
                    break;
                case 13:
                    input.append("XIII");
                    break;
                case 14:
                    input.append("XIV");
                    break;
                case 15:
                    input.append("XV");
                    break;
                case 16:
                    input.append("XVI");
                    break;
                case 17:
                    input.append("XVII");
                    break;
                case 18:
                    input.append("XVIII");
                    break;
                case 19:
                    input.append("XIX");
                    break;
                case 20:
                    input.append("XX");
                    break;
                case 21:
                    input.append("XXI");
                    break;
                case 22:
                    input.append("XXII");
                    break;
                case 23:
                    input.append("XXIII");
                    break;
                case 24:
                    input.append("XXIV");
                    break;
                case 25:
                    input.append("XXV");
                    break;
                case 26:
                    input.append("XXVI");
                    break;
                case 27:
                    input.append("XXVII");
                    break;
                case 28:
                    input.append("XXVIII");
                    break;
                case 29:
                    input.append("XXIX");
                    break;
                case 30:
                    input.append("XXX");
                    break;
                case 31:
                    input.append("XXXI");
                    break;
                case 32:
                    input.append("XXXII");
                    break;
                case 33:
                    input.append("XXXIII");
                    break;
                case 34:
                    input.append("XXXIV");
                    break;
                case 35:
                    input.append("XXXV");
                    break;
                case 36:
                    input.append("XXXVI");
                    break;
                case 37:
                    input.append("XXXVII");
                    break;
                case 38:
                    input.append("XXXVIII");
                    break;
                case 39:
                    input.append("XXXIX");
                    break;
                case 40:
                    input.append("XL");
                    break;
                case 41:
                    input.append("XLI");
                    break;
                case 42:
                    input.append("XLII");
                    break;
                case 43:
                    input.append("XLIII");
                    break;
                case 44:
                    input.append("XLIV");
                    break;
                case 45:
                    input.append("XLV");
                    break;
                case 46:
                    input.append("XLVI");
                    break;
                case 47:
                    input.append("XLVII");
                    break;
                case 48:
                    input.append("XLVIII");
                    break;
                case 49:
                    input.append("XLIX");
                    break;
                case 50:
                    input.append("L");
                    break;
                case 51:
                    input.append("LI");
                    break;
                case 52:
                    input.append("LII");
                    break;
                case 53:
                    input.append("LIII");
                    break;
                case 54:
                    input.append("LIV");
                    break;
                case 55:
                    input.append("LV");
                    break;
                case 56:
                    input.append("LVI");
                    break;
                case 57:
                    input.append("LVII");
                    break;
                case 58:
                    input.append("LVIII");
                    break;
                case 59:
                    input.append("LIX");
                    break;
                case 60:
                    input.append("LX");
                    break;
                case 61:
                    input.append("LXI");
                    break;
                case 62:
                    input.append("LXII");
                    break;
                case 63:
                    input.append("LXIII");
                    break;
                case 64:
                    input.append("LXIV");
                    break;
                case 65:
                    input.append("LXV");
                    break;
                case 66:
                    input.append("LXVI");
                    break;
                case 67:
                    input.append("LXVII");
                    break;
                case 68:
                    input.append("LXVIII");
                    break;
                case 69:
                    input.append("LXIX");
                    break;
                case 70:
                    input.append("LXX");
                    break;
                case 71:
                    input.append("LXXI");
                    break;
                case 72:
                    input.append("LXXII");
                    break;
                case 73:
                    input.append("LXXIII");
                    break;
                case 74:
                    input.append("LXXIV");
                    break;
                case 75:
                    input.append("LXXV");
                    break;
                case 76:
                    input.append("LXXVI");
                    break;
                case 77:
                    input.append("LXXVII");
                    break;
                case 78:
                    input.append("LXXVIII");
                    break;
                case 79:
                    input.append("LXXIX");
                    break;
                case 80:
                    input.append("LXXX");
                    break;
                case 81:
                    input.append("LXXXI");
                    break;
                case 82:
                    input.append("LXXXII");
                    break;
                case 83:
                    input.append("LXXXIII");
                    break;
                case 84:
                    input.append("LXXXIV");
                    break;
                case 85:
                    input.append("LXXXV");
                    break;
                case 86:
                    input.append("LXXXVI");
                    break;
                case 87:
                    input.append("LXXXVII");
                    break;
                case 88:
                    input.append("LXXXVIII");
                    break;
                case 89:
                    input.append("LXXXIX");
                    break;
                case 90:
                    input.append("XC");
                    break;
                case 91:
                    input.append("XCI");
                    break;
                case 92:
                    input.append("XCII");
                    break;
                case 93:
                    input.append("XCIII");
                    break;
                case 94:
                    input.append("XCIV");
                    break;
                case 95:
                    input.append("XCV");
                    break;
                case 96:
                    input.append("XCVI");
                    break;
                case 97:
                    input.append("XCVII");
                    break;
                case 98:
                    input.append("XCVIII");
                    break;
                case 99:
                    input.append("XCIX");
                    break;
                case 100:
                    input.append("C");
                    break;
                default:
                    throw new IllegalArgumentException("notArabic");
            }
            System.out.println(input);
        }

    }
}

class Exp {
    String input;
    int a;
    int b;
    String operator;
    int result;


    void setA(int userA) {
        a = userA;
    }

    void setB(int userB) {
        b = userB;
    }

    void setO(String userO) {
        operator = userO;
    }

    void setR(int userR) {
        result = userR;
    }


    int calculation() {
        if (operator.equals("+")) {
            result = a + b;
        } else if (operator.equals("-")) {
            result = a - b;
        } else if (operator.equals("*")) {
            result = a * b;
        } else if (operator.equals("/")) {
            result = a / b;
        } else {
            throw new IllegalArgumentException("Cтрока не является приемлемой математической операцией");
        }
        return result;
    }

}
