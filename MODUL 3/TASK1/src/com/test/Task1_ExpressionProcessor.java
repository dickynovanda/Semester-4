package com.test;

import java.util.Scanner;
import java.util.Stack;

public class Task1_ExpressionProcessor {

    // Prioritas operator
    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            default: return -1;
        }
    }

    // Cek operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Tambah perkalian implisit (MENGABAIKAN SPASI)
    private static String addImplicitMultiplication(String infix) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            result.append(ch);

            // Cek pola: angka diikuti kurung (boleh ada spasi di antaranya)
            if (Character.isDigit(ch)) {
                // Cari karakter non-spasi berikutnya
                int j = i + 1;
                while (j < infix.length() && infix.charAt(j) == ' ') {
                    j++;
                }
                if (j < infix.length() && infix.charAt(j) == '(') {
                    result.append('*');
                }
            }

            // Cek pola: kurung tutup diikuti angka atau kurung buka (boleh ada spasi)
            if (ch == ')') {
                int j = i + 1;
                while (j < infix.length() && infix.charAt(j) == ' ') {
                    j++;
                }
                if (j < infix.length() && (Character.isDigit(infix.charAt(j)) || infix.charAt(j) == '(')) {
                    result.append('*');
                }
            }
        }

        return result.toString();
    }

    // Konversi Infix ke Postfix
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (ch == ' ') continue;

            // Angka (multi-digit)
            if (Character.isDigit(ch)) {
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    postfix.append(infix.charAt(i));
                    i++;
                }
                postfix.append(" ");
                i--;
            }
            // Kurung buka
            else if (ch == '(') {
                stack.push(ch);
            }
            // Kurung tutup
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop();
            }
            // Operator
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                        getPrecedence(stack.peek()) >= getPrecedence(ch)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    // Evaluasi Postfix
    public static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split(" ");

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                stack.push(Double.parseDouble(token));
            }
            else if (token.length() == 1 && isOperator(token.charAt(0))) {
                double b = stack.pop();
                double a = stack.pop();
                double result;

                switch (token.charAt(0)) {
                    case '+': result = a + b; break;
                    case '-': result = a - b; break;
                    case '*': result = a * b; break;
                    case '/': result = a / b; break;
                    default: throw new IllegalArgumentException();
                }
                stack.push(result);
            }
        }

        return stack.pop();
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ekspresi infix: ");
        String infix = scanner.nextLine();

        // Simpan infix asli untuk ditampilkan
        String originalInfix = infix;

        // Tambah perkalian implisit
        infix = addImplicitMultiplication(infix);

        // Tampilkan infix (setelah ditambah *)
        System.out.println("Infix : " + infix);

        String postfix = infixToPostfix(infix);
        System.out.println("Postfix : " + postfix);

        double result = evaluatePostfix(postfix);

        if (result == (int) result) {
            System.out.println("Result : " + (int) result);
        } else {
            System.out.println("Result : " + result);
        }

        scanner.close();
    }
}