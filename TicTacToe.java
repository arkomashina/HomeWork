package ru.geekbrains.HomeWork_4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static final int SIZE = 5;
    public static final char[][] map = new char[SIZE][SIZE];

    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        initializeGame();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkEndGame(DOT_X)){
                break;
            }

            computerTurn();
            printMap();
            if (checkEndGame(DOT_O)) {
                break;
            }
        }
    }

    private static boolean checkEndGame(char symbol) {
        if (checkDiagonals(symbol) || checkRowsAndColumns(symbol)){
            System.out.println(isHumanTurn(symbol) ? "Человек победил!" : "Компьютер победил!");
            return true;
        }
        if(isMapFull()){
            System.out.println("Ничья!");
            return true;
        }
        return false;
    }

    private static boolean isMapFull(){
        for (char[] rows : map) {
            for (char cellValue : rows) {
                if (cellValue == DOT_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }
        private static boolean checkDiagonals (char symbol) {
            boolean toRight, toLeft;
            toRight = true;
            toLeft = true;
            for (int i = 0; i < SIZE; i++) {
                toRight = (map[i][i] == symbol) || (map[i][i + 1] == symbol) || (map[i + 1][i] == symbol);
                toLeft = (map[i][4 - i] == symbol) || (map[i][3 - i] == symbol) || (map[i + 1][5 - i] == symbol);
            }
            return toRight || toLeft;
        }
        private static boolean checkRowsAndColumns (char symbol){
            boolean goRows, goColumns;
            for (int col = 0; col < SIZE; col++){
                goColumns = true;
                goRows = true;
                for (int row = 0; row < SIZE; row++){
                    goColumns &= (map[col][row] == symbol);
                    goRows &= (map[row][col] == symbol);
                }
                if (goColumns || goRows) return true;
            }
            return false;
        // private static boolean checkWin (char symbol){
        //    //проверка по горизонтали
        //    if (map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol && map[0][3] == symbol) return true;
        //    if (map[0][1] == symbol && map[0][2] == symbol && map[0][3] == symbol && map[0][4] == symbol) return true;
        //    if (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol && map[1][3] == symbol) return true;
        //    if (map[1][1] == symbol && map[1][2] == symbol && map[1][3] == symbol && map[1][4] == symbol) return true;
        //    if (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol && map[2][3] == symbol) return true;
        //    if (map[2][1] == symbol && map[2][2] == symbol && map[2][3] == symbol && map[2][4] == symbol) return true;
        //    if (map[3][0] == symbol && map[3][1] == symbol && map[3][2] == symbol && map[3][3] == symbol) return true;
        //    if (map[3][1] == symbol && map[3][2] == symbol && map[3][3] == symbol && map[3][4] == symbol) return true;
        //    if (map[4][0] == symbol && map[4][1] == symbol && map[4][2] == symbol && map[4][3] == symbol) return true;
        //    if (map[4][1] == symbol && map[4][2] == symbol && map[4][3] == symbol && map[4][4] == symbol) return true;
        //    //проверка по вертикали
        //    if (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol && map[3][0] == symbol) return true;
        //    if (map[1][0] == symbol && map[2][0] == symbol && map[3][0] == symbol && map[4][0] == symbol) return true;
        //    if (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol && map[3][1] == symbol) return true;
        //    if (map[1][1] == symbol && map[2][1] == symbol && map[3][1] == symbol && map[4][1] == symbol) return true;
        //    if (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol && map[3][2] == symbol) return true;
        //    if (map[1][2] == symbol && map[2][2] == symbol && map[3][2] == symbol && map[4][2] == symbol) return true;
        //    if (map[0][3] == symbol && map[1][3] == symbol && map[2][3] == symbol && map[2][4] == symbol) return true;
        //    if (map[1][3] == symbol && map[2][3] == symbol && map[3][3] == symbol && map[4][3] == symbol) return true;
        //    if (map[0][4] == symbol && map[1][4] == symbol && map[2][4] == symbol && map[3][4] == symbol) return true;
        //    if (map[1][4] == symbol && map[2][4] == symbol && map[3][4] == symbol && map[4][4] == symbol) return true;
        //    //проверка по диагоналям
        //    if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol && map[3][3] == symbol) return true;
        //    if (map[1][1] == symbol && map[2][2] == symbol && map[3][3] == symbol && map[4][4] == symbol) return true;
        //    if (map[4][0] == symbol && map[3][1] == symbol && map[2][2] == symbol && map[1][3] == symbol) return true;
        //    if (map[3][1] == symbol && map[2][2] == symbol && map[1][3] == symbol && map[0][4] == symbol) return true;
        //    return false;
        //}
    }
    private static void humanTurn() {
        int rowIndex = -1;
        int colIndex = -1;
        do {
            System.out.print("Введите номер строки: ");
            if (!SCANNER.hasNextInt()){
                SCANNER.nextLine();
                System.out.println("Введите число!");
                continue;
            }
            rowIndex = SCANNER.nextInt() - 1;

            System.out.print("Введите номер столбца: ");
            if (!SCANNER.hasNextInt()) {
                SCANNER.nextLine();
                System.out.println("Введите число!");
                continue;
            }
            colIndex = SCANNER.nextInt() - 1;
        } while (!isCellValid(rowIndex, colIndex, DOT_X));

        map[rowIndex][colIndex] = DOT_X;
    }

    private static void computerTurn() {
        int rowIndex;
        int colIndex;
        Random rand = new Random();
        do {
            rowIndex = rand.nextInt(SIZE);
            colIndex = rand.nextInt(SIZE);
        } while (!isCellValid(rowIndex, colIndex, DOT_O));

        map[rowIndex][colIndex] = DOT_O;
    }

    private static boolean isCellValid(int rowIndex, int colIndex, char symbol) {
        if (!isArrayIndexValid(rowIndex) || !isArrayIndexValid(colIndex)) {
            System.out.println("Индексы строки и столбцов должны быть в диапазоне от 1 до " + SIZE);
            return false;
        }
        if (map[rowIndex][colIndex] != DOT_EMPTY) {
            if (isHumanTurn(symbol)) {
                System.out.println("Данная ячейка уже занята!");
            }
            return false;
        }
        return true;
    }

    private static boolean isHumanTurn(char symbol) {
        return symbol == DOT_X;
    }

    private static boolean isArrayIndexValid(int index) {
        return index >= 0 && index < SIZE;
    }

    private static void printMap() {
        printHeader();
        printStateMap();
        System.out.println();
    }

    private static void printStateMap() {
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            System.out.print((rowIndex + 1) + " ");
            for (int colIndex = 0; colIndex < SIZE; colIndex++) {
                System.out.print(map[rowIndex][colIndex] + " ");
            }
            System.out.println();
        }
    }

    private static void printHeader() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void initializeGame() {
        for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
            for (int colIndex = 0; colIndex < SIZE; colIndex++) {
                map[rowIndex][colIndex] = DOT_EMPTY;
            }
        }
    }
}