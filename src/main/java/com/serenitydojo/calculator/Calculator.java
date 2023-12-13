package com.serenitydojo.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {
    public int evaluate(String expression) throws IllegalMathsOperatorException {
        expression = expression.trim().replaceAll("\\s+","");
        String regex = "^[0-9+\\-*/]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        int result = 0;

        if(expression.equals(""))
        {
            return 0;
        }
        if(matcher.matches())
        {
            String[] splittedByCharacter = expression.trim().split("[-+*/]");
            String[] characters = expression.trim().split("[0-9]+");
            int numbersAvailable = splittedByCharacter.length;
            int count = 1;
            result = Integer.parseInt(splittedByCharacter[0]);
            while(count <= numbersAvailable-1)
            {
                int value = Integer.parseInt(splittedByCharacter[count]);
                if(characters[count].equals("+"))
                {
                    result = result + value;
                }
                else if (characters[count].equals("-"))
                {
                    result = result - value;
                }
                else if (characters[count].equals("*"))
                {
                    result = result * value;
                }
                else if (characters[count].equals("/"))
                {
                    result = result / value;
                }
                count++;
            }
        }
        else
        {
            throw new IllegalMathsOperatorException("Invalid Operator");
        }
        return result;
    }

    public class IllegalMathsOperatorException extends Exception{
        public IllegalMathsOperatorException(String message){
            super(message);
        }
    }
}
