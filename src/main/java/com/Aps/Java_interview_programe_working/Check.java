package com.Aps.Java_interview_programe_working;

import java.util.*;

public class Check implements Interface_for_method {
    protected Scanner scanner = new Scanner(System.in);

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

    @Override
    public void arry() {
        List<String> arrayStrings = new ArrayList<>();
        System.out.print("Enter the name: ");
        for (int i = 0; i <= 4; i++) {
            String name = scanner.nextLine();
            arrayStrings.add(name);

        }

        for (String name : arrayStrings) {
            System.out.print(name);

        }
    }

    @Override
    public void dulipcate() {
        Set<String> uniqueNames = new HashSet<>();
        Set<String> duplicateNames = new HashSet<>();


        System.out.println("Enter the name: ");

        List<String> strings = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            String name = scanner.nextLine();
            strings.add(name);
        }

        for (String na : strings)

            if (!uniqueNames.add(na)) {
                duplicateNames.add(na);
            }
        System.out.print("duplicateNames " + duplicateNames);
    }

    @Override
    public void CountDuplicateNames() {
        Map<String, Integer> namecounts = new HashMap<>();
        List<String> list = new ArrayList<>();
        System.out.print("Enter the names");
        for (int i = 0; i <= 3; i++) {

            String name = scanner.nextLine();
            list.add(name);
        }
        for (String on : list) {
            if (!namecounts.containsKey(on)) {
                namecounts.put(on, 1);
            } else {
                namecounts.put(on, namecounts.get(on) + 1);
            }
        }
        System.out.print("Duplicate names and counts:");
        for (Map.Entry<String, Integer> entry : namecounts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print(entry.getKey() + ":" + entry.getValue());
            }
        }

    }


}
