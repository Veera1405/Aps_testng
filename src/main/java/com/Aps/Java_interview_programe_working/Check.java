package com.Aps.Java_interview_programe_working;

import java.util.Scanner;

public class Check implements Interface_for_method {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void using_stringbuilder() {
        System.out.print("Enter the Letter want to reverse : ");
        String line = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder(line).reverse();
        System.out.println(stringBuilder);
    }

    @Override
    public void using_forloop() {
        System.out.print("Enter the Letter want to reverse : ");
        String line = scanner.nextLine();
        for (int i = line.length() - 1; i >= 0; i--) {
            char Reverce = line.charAt(i);
            System.out.print(Reverce);
        }
    }

    @Override
    public void Fibonacci_series() {
        int num, a = 0, b = 0, c = 1;
        scanner = new Scanner(System.in);
        System.out.print("Enter the number of times :  ");
        num = scanner.nextInt();
        System.out.print("Fibonacci Series of the number is: ");
        for (int i = 0; i < num; i++) {
            a = b;
            b = c;
            c = a + b;
            System.out.print(a + "   ");
        }


    }
}
