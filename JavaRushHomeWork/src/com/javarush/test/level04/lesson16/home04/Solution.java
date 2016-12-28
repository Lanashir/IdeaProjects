package com.javarush.test.level04.lesson16.home04;

import java.io.*;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] name = new String[4];
        for(int i=0; i<4; i++){
            name[i] = reader.readLine();
        }
        System.out.println("Меня зовут " + name[0]);
        System.out.println("Я родился " + name[3] + "." + name[2] + "." + name[1]);
    }
}
