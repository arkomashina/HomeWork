package ru.geekbrains.HomeWork_2;
public class Main {
    public static void main(String[] args) {
        //Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int i;
        for (i = 0; array.length > i; i++) {
            if (array[i] == 1) {
                System.out.print("0");
            } else System.out.print("1");
        }
        fillsArray();
        changeArray();
        diagonalArray();
    }
    public static void fillsArray(){
       //Задать пустой целочисленный массив размером 8.
       //С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
        int[] array = new int[8];
        int i;
        for (i = 0; i <= 21; i = i + 3){
            if(i == 0);{
                System.out.println(i);
            }

        }
    }
    public static void changeArray(){
        //Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        // пройти по нему циклом, и числа меньшие 6 умножить на 2
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int i;
        int j = 1;
        for (i = array[0]; i < 12; i = array[j++]){
            if(i < 6) {
                System.out.println(i * 2);
            }else{
                System.out.println(i);
            }
        }
    }
    public static void diagonalArray(){
        //Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами
        int[][] SquareArray = new int[5][5];
        for(int i = 0;i < SquareArray.length; i++)
        {
            for(int j = 0;j < SquareArray.length; j++)
            {
                if(i == j)
                {
                    SquareArray[i][j] = 1;
                }
                System.out.print(SquareArray[i][j]);
            }
            System.out.println();
        }
    }



}
