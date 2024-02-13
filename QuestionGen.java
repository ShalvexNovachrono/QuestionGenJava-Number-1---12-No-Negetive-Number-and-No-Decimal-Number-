/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package questiongen;

import java.util.Arrays;
/**
 *
 * @author Shalvex Novachrono (Nava Majumdar)
 */
public class QuestionGen {

    static void print(String message, int mode) {
        switch (mode) {
            case 0:
                System.out.println(message);
                break;
            case 1:
                System.out.print(message);
                break;
            default:
                System.out.println("error mode has to be 0 or 1");
        }
    }
    
    static int randomNumber(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
    static int xp = 70;
    static int points_for_this_question = 0;
    
    public static String get_random_symbol_based_on_xp() {
        char[] Symbols = {'÷', '×', '+', '-'};
        if (xp < 49) {
            return String.valueOf(Symbols[randomNumber(2, Symbols.length - 1)]);
        } else if (xp < 69) {
            return String.valueOf(Symbols[randomNumber(1, Symbols.length - 1)]);
        } else {
            return String.valueOf(Symbols[randomNumber(0, Symbols.length - 1)]);
        }
    }
    

    

    static int[] returnDivisionNumbers(int number) {
        int[] divisors = new int[0]; 

        for (int i = 1; i < 13; i++) {
            if (number % i == 0) {
                divisors = Arrays.copyOf(divisors, divisors.length + 1);
                divisors[divisors.length - 1] = i;
            }
        }

        return divisors;
    }
    
    
    static int[] returnSubtractionNumbers(int number) {
        int[] numbers = new int[0]; 

        for (int i = 1; i < 13; i++) {
            if (!((number - i) < 0)) {
                numbers = Arrays.copyOf(numbers, numbers.length + 1);
                numbers[numbers.length - 1] = i;
            }
        }

        return numbers;
    }
    
    
    static String DivisionQMaker(int number, int[] numbers) {
        return String.valueOf(number + "÷" + numbers[randomNumber(0, numbers.length -1)]);
    }
    
    static String MultiplicationQMaker(int number) {
        return String.valueOf(number + "×" + get_random_number_based_on_xp());
    }
    
    static String AdditionQMaker(int number) {
        return String.valueOf(number + "+" + get_random_number_based_on_xp());
    }
    
    static String SubtractionQMaker(int number, int[] numbers) {
        return String.valueOf(number + "-" + numbers[randomNumber(0, numbers.length -1)]);
    }
    
    
    public static int get_random_number_based_on_xp() {
        if (xp < 5) {
            return randomNumber(1, 3);
        } else if (xp < 10) {
            return randomNumber(1, 5);
        } else if (xp < 20) {
            return randomNumber(1, 7);
        } else if (xp < 25) {
            return randomNumber(6, 8);
        } else {
            return randomNumber(1, 12);
        }
    }
    
    

    static String qMaker() {
        points_for_this_question = 0;
        String currentSymbol = get_random_symbol_based_on_xp();
        int number = get_random_number_based_on_xp();
        
        String question = "";
        switch (currentSymbol) {
            case "÷":
                int[] numbers1 = returnDivisionNumbers(number);
                question = DivisionQMaker(number, numbers1);
                points_for_this_question += 32;
                numbers1 = null;
                break;
            case "×":
                question = MultiplicationQMaker(number);
                points_for_this_question += 20;
                break;
            case "+":
                question = AdditionQMaker(number);
                points_for_this_question += 5;
                break;
            case "-":
                int[] numbers2 = returnSubtractionNumbers(number);
                question = SubtractionQMaker(number, numbers2);
                points_for_this_question += 10;
                numbers2 = null;
                break;
        }
        
        return question;
    }
    
    public static void main(String[] args) {
        print(qMaker(), 0);
    }
    
}
