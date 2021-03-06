package com.codeb1ooded.megha.scientificcalculator.conversion_number_system;


import com.codeb1ooded.megha.scientificcalculator.Constants;

/**
 * Created by megha on 20/08/17.
 */

public class ConversionFunctions implements Constants{
    
    private int numberSystem;
    private StringBuffer number;
    private StringBuffer binary, octal, decimal, hexadecimal;

    public ConversionFunctions(String convertFrom, StringBuffer input){
        number = input;
        if(convertFrom.equals(convertBinary))
            numberSystem = 0;
        if(convertFrom.equals(convertOctal))
            numberSystem = 1;
        if(convertFrom.equals(convertDecimal))
            numberSystem = 2;
        if(convertFrom.equals(convertHexadecimal))
            numberSystem = 3;
        toBinary();
        toOctal();
        toDecimal();
        toHexadecimal();
    }

    public StringBuffer getBinary() {
        return binary;
    }

    public StringBuffer getOctal() {
        return octal;
    }

    public StringBuffer getDecimal() {
        return decimal;
    }

    public StringBuffer getHexadecimal() {
        return hexadecimal;
    }

    private void toBinary(){
        if(numberSystem == 0){
            binary = number;
        } else if(numberSystem == 1){
            binary = octalToBinary(number);
        } else if(numberSystem == 2){
            binary = decimalToBinary(number);
        } else if(numberSystem == 3){
            binary = hexadecimalToBinary(number);
        }
    }
    private void toOctal(){
        if(numberSystem == 0){
            octal = binaryToOctal(number);
        } else if(numberSystem == 1){
            octal = number;
        } else if(numberSystem == 2){
            octal = decimalToOctal(number);
        } else if(numberSystem == 3){
            octal = hexadecimalToOctal(number);
        }
    }
    private void toDecimal(){
        if(numberSystem == 0){
            decimal = binaryToDecimal(number);
        } else if(numberSystem == 1){
            decimal = octalToDecimal(number);
        } else if(numberSystem == 2){
            decimal = number;
        } else if(numberSystem == 3){
            decimal = hexadecimalToDecimal(number);
        }
    }
    private void toHexadecimal(){
        if(numberSystem == 0){
            hexadecimal = binaryToHexadecimal(number);
        } else if(numberSystem == 1){
            hexadecimal = octalToHexadecimal(number);
        } else if(numberSystem == 2){
            hexadecimal = decimalToHexadecimal(number);
        } else if(numberSystem == 3){
            hexadecimal = number;
        }
    }

    private StringBuffer binaryToOctal( StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        int locPer = num.length();
        for(int i=0; i<num.length(); i++){
            if ( num.charAt(i) == '.'){
                locPer = i;
                break;
            }
        }
        for(int i= locPer-1; i>=0;){
            int n;
            if(i>=2){
                int first = (int) (num.charAt(i--)) -48;
                int second = (int) (num.charAt(i--)) -48;
                int third = (int) (num.charAt(i--)) -48;
                n = first +second*2 + third*4;
            }else if(i==1){
                int first = (int) (num.charAt(i--)) -48;
                int second = (int) (num.charAt(i--)) -48;
                n = first +second*2;
            }else {
                n = (int) (num.charAt(i--)) -48;
            }
            stringBuffer = new StringBuffer(n + stringBuffer.toString());
        }
        if(locPer != num.length())
            stringBuffer = stringBuffer.append('.');
        int len = num.length();
        for(int i= locPer+1; i<len;){
            int n;
            if(len-i >= 3){
                int first = (int) (num.charAt(i++)) -48;
                int second = (int) (num.charAt(i++)) -48;
                int third = (int) (num.charAt(i++)) -48;
                n = first*4 +second*2 + third;
            }else if(len-i == 2){
                int first = (int) (num.charAt(i++)) -48;
                int second = (int) (num.charAt(i++)) -48;
                n = first*4 +second*2;
            }else {
                int first = (int) (num.charAt(i++)) -48;
                n = first*4;
            }
            stringBuffer = stringBuffer.append(n);
        }
        return stringBuffer;
    }
    private StringBuffer binaryToHexadecimal(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        int locPer = num.length();
        for(int i=0; i<num.length(); i++){
            if ( num.charAt(i) == '.'){
                locPer = i;
                break;
            }
        }
        for(int i= locPer-1; i>=0;){
            int n;
            if(i >= 3){
                int first = (int) (num.charAt(i--)) -48;
                int second = (int) (num.charAt(i--)) -48;
                int third = (int) (num.charAt(i--)) -48;
                int fourth = (int) (num.charAt(i--)) -48;
                n = first +second*2 + third*4 + fourth*8;
            } else if(i >= 2){
                int first = (int) (num.charAt(i--)) -48;
                int second = (int) (num.charAt(i--)) -48;
                int third = (int) (num.charAt(i--)) -48;
                n = first +second*2 + third*4;
            } else if(i == 1){
                int first = (int) (num.charAt(i--)) -48;
                int second = (int) (num.charAt(i--)) -48;
                n = first +second*2;
            }else {
                n = (int) (num.charAt(i--)) -48;
            }
            if(n == 10)
                stringBuffer = new StringBuffer('A' + stringBuffer.toString());
            else if(n == 11)
                stringBuffer = new StringBuffer('B' + stringBuffer.toString());
            else if(n == 12)
                stringBuffer = new StringBuffer('C' + stringBuffer.toString());
            else if(n == 13)
                stringBuffer = new StringBuffer('D' + stringBuffer.toString());
            else if(n == 14)
                stringBuffer = new StringBuffer('E' + stringBuffer.toString());
            else if(n == 15)
                stringBuffer = new StringBuffer('F' + stringBuffer.toString());
            else
                stringBuffer = new StringBuffer(n + stringBuffer.toString());
        }
        if(locPer != num.length())
            stringBuffer = stringBuffer.append('.');
        int len = num.length();
        for(int i= locPer+1; i<len;){
            int n;
            if(len-i >= 4){
                int first = (int) (num.charAt(i++)) -48;
                int second = (int) (num.charAt(i++)) -48;
                int third = (int) (num.charAt(i++)) -48;
                int fourth = (int) (num.charAt(i++)) -48;
                n = first*8 +second*4 + third*2 + fourth;
            } else if(len-i >= 3){
                int first = (int) (num.charAt(i++)) -48;
                int second = (int) (num.charAt(i++)) -48;
                int third = (int) (num.charAt(i++)) -48;
                n = first*8 +second*4 + third*2;
            } else if(len-i == 2){
                int first = (int) (num.charAt(i++)) -48;
                int second = (int) (num.charAt(i++)) -48;
                n = first*8 +second*4;
            } else {
                int first = (int) (num.charAt(i++)) -48;
                n = first*8;
            }
            if(n == 10)
                stringBuffer = stringBuffer.append('A');
            else if(n == 11)
                stringBuffer = stringBuffer.append('B');
            else if(n == 12)
                stringBuffer = stringBuffer.append('C');
            else if(n == 13)
                stringBuffer = stringBuffer.append('D');
            else if(n == 14)
                stringBuffer = stringBuffer.append('E');
            else if(n == 15)
                stringBuffer = stringBuffer.append('F');
            else
                stringBuffer = stringBuffer.append(n);
        }
        return stringBuffer;
    }
    private StringBuffer binaryToDecimal(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        int locPer = num.length();
        for(int i=0; i<num.length(); i++){
            if ( num.charAt(i) == '.'){
                locPer = i;
                break;
            }
        }
        double n =0;
        int c=0;
        for(int i= locPer-1; i>=0; i--){
            int v = (int) num.charAt(i) -48;
            n = n +  v*Math.pow(2, c);
            c++;
        }
        c = -1;
        for(int i= locPer+1; i<num.length(); i++){
            int v = (int) num.charAt(i) -48;
            n = n +  v*Math.pow(2, c);
            c--;
        }
        stringBuffer = stringBuffer.append(n);
        return stringBuffer;
    }

    private StringBuffer octalToBinary(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0; i<num.length(); i++){
            if(num.charAt(i) != '.'){
                String abc = octalInBinary(num.charAt(i));
                stringBuffer = stringBuffer.append(abc);
            } else
                stringBuffer = stringBuffer.append('.');
        }
        return stringBuffer;
    }
    private StringBuffer octalToDecimal(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        int locPer = num.length();
        for(int i=0; i<num.length(); i++){
            if ( num.charAt(i) == '.'){
                locPer = i;
                break;
            }
        }
        double n =0;
        int c=0;
        for(int i= locPer-1; i>=0; i--){
            int v = (int) num.charAt(i) -48;
            n = n +  v*Math.pow(8, c);
            c++;
        }
        c = -1;
        for(int i= locPer+1; i<num.length(); i++){
            int v = (int) num.charAt(i) -48;
            n = n +  v*Math.pow(8, c);
            c--;
        }
        stringBuffer = stringBuffer.append(n);
        return stringBuffer;
    }
    private StringBuffer octalToHexadecimal(StringBuffer num){
        StringBuffer stringBuffer = octalToBinary(num);
        stringBuffer = binaryToHexadecimal(stringBuffer);
        return stringBuffer;
    }

    private StringBuffer hexadecimalToBinary(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0; i<num.length(); i++){
            if(num.charAt(i) != '.'){
                String abc = hexadecimalInBinary(num.charAt(i));
                stringBuffer = stringBuffer.append(abc);
            } else
                stringBuffer = stringBuffer.append('.');
        }
        return stringBuffer;
    }
    private StringBuffer hexadecimalToOctal(StringBuffer num){
        StringBuffer stringBuffer = hexadecimalToBinary(num);
        stringBuffer = binaryToOctal(stringBuffer);
        return stringBuffer;
    }
    private StringBuffer hexadecimalToDecimal(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        int locPer = num.length();
        for(int i=0; i<num.length(); i++){
            if ( num.charAt(i) == '.'){
                locPer = i;
                break;
            }
        }
        double n =0;
        int c=0;
        for(int i= locPer-1; i>=0; i--){
            int v;
            if(num.charAt(i) == 'A')    v = 10;
            else if(num.charAt(i) == 'B')    v = 11;
            else if(num.charAt(i) == 'C')    v = 12;
            else if(num.charAt(i) == 'D')    v = 13;
            else if(num.charAt(i) == 'E')    v = 14;
            else if(num.charAt(i) == 'F')    v = 15;
            else    v = (int) num.charAt(i) -48;
            n = n +  v*Math.pow(16, c);
            c++;
        }
        c = -1;
        for(int i= locPer+1; i<num.length(); i++){
            int v;
            if(num.charAt(i) == 'A')    v = 10;
            else if(num.charAt(i) == 'B')    v = 11;
            else if(num.charAt(i) == 'C')    v = 12;
            else if(num.charAt(i) == 'D')    v = 13;
            else if(num.charAt(i) == 'E')    v = 14;
            else if(num.charAt(i) == 'F')    v = 15;
            else    v = (int) num.charAt(i) -48;
            n = n +  v*Math.pow(16, c);
            c--;
        }
        stringBuffer = stringBuffer.append(n);
        return stringBuffer;
    }

    private StringBuffer decimalToBinary(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        int i=0, a =0, j=1;
        while(i<num.length() && num.charAt(i) != '.' ){
            a =a*10 + (((int) num.charAt(i)) -48);
            i++;
        }
        while (a != 0){
            int b = a % 2;
            a = a / 2;
            stringBuffer = new StringBuffer( b + stringBuffer.toString());
        }
        i++;
        double c =0;
        if(i < num.length())
            stringBuffer = stringBuffer.append('.');
        while (i < num.length()){
            c = c + Math.pow(0.1 , j) * (double)(((int) num.charAt(i)) -48);
            j++; i++;
        }
        j=0;
        while(j <=3 && c != 0){
            c = c * 2;
            stringBuffer = stringBuffer.append((int)c);
            c = c - (int) c;
            j++;
        }
        return stringBuffer;
    }
    private StringBuffer decimalToOctal(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        int i=0, a =0, j=1;
        while(i<num.length() && num.charAt(i) != '.'){
            a =a*10 + (((int) num.charAt(i)) -48);
            i++;
        }
        while (a != 0){
            int b = a % 8;
            a = a / 8;
            stringBuffer = new StringBuffer( b + stringBuffer.toString());
        }
        i++;
        double c =0;
        if(i < num.length())
            stringBuffer = stringBuffer.append('.');
        while (i < num.length()){
            c = c + Math.pow(0.1 , j) * (double)(((int) num.charAt(i)) -48);
            j++; i++;
        }
        j=0;
        while(j <=3 && c != 0){
            c = c * 8;
            stringBuffer = stringBuffer.append((int)c);
            c = c - (int) c;
            j++;
        }
        return stringBuffer;
    }
    private StringBuffer decimalToHexadecimal(StringBuffer num){
        StringBuffer stringBuffer = new StringBuffer();
        int i=0, a =0, j=1;
        while(i<num.length() && num.charAt(i) != '.' ){
            a =a*10 + (((int) num.charAt(i)) -48);
            i++;
        }
        while (a != 0){
            int b = a % 16;
            a = a / 16;
            if(b == 10)
                stringBuffer = new StringBuffer( 'A' + stringBuffer.toString());
            else if(b == 11)
                stringBuffer = new StringBuffer( 'B' + stringBuffer.toString());
            else if(b == 12)
                stringBuffer = new StringBuffer( 'C' + stringBuffer.toString());
            else if(b == 13)
                stringBuffer = new StringBuffer( 'D' + stringBuffer.toString());
            else if(b == 14)
                stringBuffer = new StringBuffer( 'E' + stringBuffer.toString());
            else if(b == 15)
                stringBuffer = new StringBuffer( 'F' + stringBuffer.toString());
            else
                stringBuffer = new StringBuffer( b + stringBuffer.toString());
        }
        i++;
        double c =0;
        if(i < num.length())
            stringBuffer = stringBuffer.append('.');
        while (i < num.length()){
            c = c + Math.pow(0.1 , j) * (double)(((int) num.charAt(i)) -48);
            j++; i++;
        }
        j=0;
        while(j <=3 && c != 0){
            c = c * 16;

            if(c == 10)
                stringBuffer = stringBuffer.append('A');
            else if(c == 11)
                stringBuffer = stringBuffer.append('B');
            else if(c == 12)
                stringBuffer = stringBuffer.append('C');
            else if(c == 13)
                stringBuffer = stringBuffer.append('D');
            else if(c == 14)
                stringBuffer = stringBuffer.append('E');
            else if(c == 15)
                stringBuffer = stringBuffer.append('F');
            else
                stringBuffer = stringBuffer.append((int)c);
            c = c - (int) c;
            j++;
        }
        return stringBuffer;
    }

    private String octalInBinary(char num){
        if(num == '0')
            return "000";
        else if(num == '1')
            return "001";
        else if(num == '2')
            return "010";
        else if(num == '3')
            return "011";
        else if(num == '4')
            return "100";
        else if(num == '5')
            return "101";
        else if(num == '6')
            return "110";
        else
            return "111";
    }
    private String hexadecimalInBinary(char num){
        if(num == '0')
            return "0000";
        else if(num == '1')
            return "0001";
        else if(num == '2')
            return "0010";
        else if(num == '3')
            return "0011";
        else if(num == '4')
            return "0100";
        else if(num == '5')
            return "0101";
        else if(num == '6')
            return "0110";
        else if(num == '7')
            return "0111";
        else if(num == '8')
            return "1000";
        else if(num == '9')
            return "1001";
        else if(num == 'A')
            return "1010";
        else if(num == 'B')
            return "1011";
        else if(num == 'C')
            return "1100";
        else if(num == 'D')
            return "1101";
        else if(num == 'E')
            return "1110";
        else
            return "1111";
    }
    
}
