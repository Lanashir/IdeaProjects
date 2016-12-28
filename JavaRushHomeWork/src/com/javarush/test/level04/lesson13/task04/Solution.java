package com.javarush.test.level04.lesson13.task04;

/* Рисуем линии
Используя цикл for вывести на экран:
- горизонтальную линию из 10 восьмёрок
- вертикальную линию из 10 восьмёрок.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        print("8");
        print("8\n");

    }
    public static void print(String s){
        for(int i=0; i<10; i++){
            System.out.print(s);
        }
        System.out.print("\n");
    }
}
