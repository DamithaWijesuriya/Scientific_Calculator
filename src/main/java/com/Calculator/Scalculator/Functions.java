package com.Calculator.Scalculator;

import javax.swing.*;
import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hsenid on 12/1/16.
 */
public class Functions {
    static double BasicResult;
    static double AdvancedResults,d,c;

    public static final double E= 2.7182818284590452354;
    public static final double PI= 3.14159265358979323846;




    public static double add(double a, double b)
    {
        return BasicResult = a+b;

    }
    public static double substraction(double a,double b)
    {
        return BasicResult =a-b;


    }
    public static double multiplication(double a,double b)
    {
        return BasicResult=a*b;

    }

    public static double divide(double i,double j)
    {
        if(j<0)
        {
            System.out.println("ERROR-Invalid input");
        }
        else
        {
            BasicResult = i / j;
        }
        return BasicResult;

    }
    public  static double percentage(double i,double j)
    {
        double percentage = i*(j/100);

        return BasicResult ;
    }
    public static double sin(double a )
    {
         d=Math.toRadians(a);
         return AdvancedResults=Math.sin(d);

    }
    public static double cos(double a)
    {
        d=Math.toRadians(a);
        return AdvancedResults=Math.cos(d);
    }
    public static double tan(double a)
    {
        d=Math.toRadians(a);
        return AdvancedResults=Math.tan(d);

    }

    public static double aSin(double a)
    {
        d=Math.toRadians(a);
        return AdvancedResults=Math.asin(d);

    }
    public static double aCos(double a)
    {
        d=Math.toRadians(a);
        return AdvancedResults=Math.acos(d);
    }
    public static double aTan(double a)
    {
        d=Math.toRadians(a);
        return AdvancedResults=Math.atan(d);
    }

    public static double factorial(double a)
    {
        double c=1;
        for (int i=1;i<=a;i++)
        {
            c=c*i;
        }
        return c;

    }
    public static double combination(double a,double b)
    {
        return  c=factorial(a)/(factorial(a-b)*factorial(b));
    }

    public static double permutation(double a,double b)
    {
       return c= factorial(a)/(factorial(a-b));

    }

    public static double log10(double a)
    {
        return c=Math.log10(a);
    }
    public static double loge(double a)
    {
        return c=Math.log(a);

    }

    public static double pow10(double a)
    {
        return c=Math.pow(10,a);
    }

    public static double powE(double a)
    {
        return c=Math.pow(E,a);
    }
    public static double xPowY(double x,double y)
    {
        return c=Math.pow(x,y);
    }
    public static double xSquare(double a)
    {
        return c=Math.pow(a,2);
    }
    public static double xSqrt(double x)
    {
        return c=Math.sqrt(x);
    }
    public static double inverse(double x)
    {
        return c=1/x;
    }
    public static double ySqrtX(double y,double x)
    {
      return c=Math.pow(x,1/y);
    }

    public static double xCube(double x)
    {
        return c=Math.pow(x,3);
    }

    public static double evaluate(String expr, int d) {
        expr = expr.replaceAll("x", String.valueOf(d));
        System.out.println(expr);
        char[] tokens = expr.toCharArray();
        Stack<Double> values = new Stack<Double>();
        Stack<Character> ops = new Stack<Character>();


        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.toString()));
            } else if (tokens[i] == '(')
                ops.push(tokens[i]);
            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                if(tokens[i+1] >= '0' && tokens[i+1] <= '9'){
                    StringBuffer collectChars = new StringBuffer();
                    while (i < tokens.length && ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '+' || tokens[i] == '-')) {
                        collectChars.append(tokens[i++]);
                    }
                    values.push(Double.parseDouble(collectChars.toString()));
                } else {
                    while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                        values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                    ops.push(tokens[i]);
                }
            }
        }
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public String convertOperand(String input) {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d*)?+$");
        Matcher match = pattern.matcher(input);
        match.find();
        String output = match.group();
        return output;
    }

    public static String operandConverter(String righOperand) {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d*)?+$");
        Matcher match = pattern.matcher(righOperand);
        boolean x = match.find();
        if (x==true) {
            String output = match.group();
            return output;
        }
        return null;
    }
    static double memory;

    public static double memoryOperation(String operand, String operator){

        if (memory == 0 && operator.equals("M+")) {
            memory = Double.parseDouble(operand);
        } else if (memory == 0 && operator.equals("M-")){
            memory = -1 * Double.parseDouble(operand);
        } else if(operator.equals("M+")){
            memory += Double.parseDouble(operand);
        } else if (operator.equals("M-")){
            memory -= Double.parseDouble(operand);
        } else if(operator.equals("clearM")){
            memory = 0;
        }
        return memory;
    }



}
