package ru.geekbrains.HomeWork_1;

public class Main {

    public static void main(String[] args) {
        // Написать метод вычисляющий выражение a * (b + (c / d))
        // и возвращающий результат,где a, b, c, d – входные параметры этого метода
        float a = 12;
        float b = 31;
        float c = 18.5f;
        float d = 6;
        float result = calculation (a, b, c, d);
        System.out.println("Результат вычислений " + result);

        //Написать метод, принимающий на вход два числа,
        // и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
        // если да – вернуть true, в противном случае – false;
        int q = 13;
        int w = 8;
        System.out.println(isNumberBetween10And20(q, w));

        //Написать метод, которому в качестве параметра передается целое число,
        // метод должен напечатать в консоль положительное ли число передали,
        // или отрицательное; Замечание: ноль считаем положительным числом.
        int number = 14;
        System.out.println("Является ли число " + number + " Положительным или отрицательным?");
        System.out.println(isNumberPositiveOrNot(number));

        //Написать метод, которому в качестве параметра передается целое число,
        // метод должен вернуть true, если число отрицательное;
        int y = -15;
        System.out.println("Является ли число " + y + " отрицательным?");
        System.out.println(isYNegative(y));

        //Написать метод, которому в качестве параметра передается строка,
        // обозначающая имя, метод должен вывести в консоль сообщение "Привет, указанное_имя!"
        String name = "Аркадий";
        System.out.println(printName("Аркадий"));

        //Написать метод, который определяет является ли год високосным,
        // и выводит сообщение в консоль.
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        int year = 2021;
        System.out.println(ifYearLeapOrNot(year));



    }
    public static float calculation(float a, float b, float c, float d){
        return  a * (b + (c / d));
    }
    public static boolean isNumberBetween10And20(int q, int w){
        int sum = q + w;
        boolean end = sum >= 10 && sum <= 20;
        return end;
    }
    public static int isNumberPositiveOrNot(int number){
        if  (number >= 0){
            System.out.println("Число положительное");
        } else{
            System.out.println("Число отрицательное");
        }
        return number;
    }
    public static int isYNegative(int y){
        if (y < 0){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        return y;
    }
    public static String printName(String name){
        System.out.println("Привет, " + name);
        return name;
    }
    public static int ifYearLeapOrNot(int year){
        if (year % 4 == 0 && year % 100 != 0){
            System.out.println(year + " год является високосным");
        } else if (year % 400 == 0){
            System.out.println(year + " год является високосным");
        } else {
            System.out.println(year + " год не является високосным");
        }
        return year;
    }

}