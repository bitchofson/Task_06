package com.metanit;

import java.util.Scanner;

/*
 Формула вида: ln(x+sqrt(x^2 + 1)) = x - 1/2 * x^3 / 3 + 1 * 3 / 2 * 4  * x^5 / 5 .....
 */

public class Main {

    public static double sum1(double x, int n) {
        return sum2(x, 0, n);
    } // Сумма n слагаемых

    public static double sum2(double x, double e, int n) {

        double sum = x;
        double an = x;

        for (int i = 2; i <= n; i++) {
           an = (-(2*i - 3) * Math.pow(x, 2)) / (2*i-2)*(2*i-1) * an;
           sum += (an > e) ? an : 0;
        }

        return sum;
    } // Сумма слагаемых > e

    public static double sum3(double x, double e, int n) {
        return sum2(x, e / 10, n);
    } // Сумма слагаемых > e / 10

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Введите x: ");
        double x = input.nextDouble();
        System.out.print("Введите n: ");
        int n = input.nextInt();
        System.out.print("Введите e: ");
        double e = input.nextDouble();

        System.out.println("1.Сумма n слагаемых: " + sum1(x, n));
        System.out.println("2.Сумма слагаемых > e: " + sum2(x, e, n));
        System.out.println("3.Сумма слагаемых > e / 10: " + sum3(x, e, n));
        
        double an = x + Math.sqrt(Math.pow(x, 2) + 1);
        System.out.println("4.ln(x+sqrt(x^2 + 1)) = " + Math.exp(an));

    }
}
