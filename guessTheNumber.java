package ru.geekbrains.HomeWork_3;

import java.util.Scanner;

//Написать программу, которая загадывает случайное число от 1 до 9, и пользователю дается 3 попытки угадать это число.
//При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
//После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
class guessGame{
    void question (){
        System.out.println("Угадайте целое число от 1 до 9");
    }
    void correctAnswer (){
        System.out.println("Поздравляю, вы угадали!");
        System.out.println("Хотите начать игру заново? 1 - да, 2 - нет");
    }
    void wrongAnswerBiggerThanQuestion(){
        System.out.println("Ваше число больше чем загаданное");
        System.out.println("Попробуйте ещё раз");
    }
    void wrongAnswerLessThanQuestion(){
        System.out.println("Ваше число меньше чем загаданное");
        System.out.println("Попробуйте ещё раз");
    }
    void repeat(){
        System.out.println("Перезапустите игру");
    }
}
class TestGuessGame{
    public static void main(String[] args){
        guessGame g = new guessGame();
        int [] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        g.question();
        Scanner scanner = new Scanner(System.in);
        int rand = (int) (Math.random() * array.length);

        for(int i = 0; i < 3; i++){
            int guess = scanner.nextInt();
            if (guess == rand){
                g.correctAnswer();
                Scanner scanner1 = new Scanner(System.in);
                int answer = scanner1.nextInt();
                if (answer == 1){
                    g.repeat();
                }else if (answer == 2){
                    System.out.println("Игра закончена! Спасибо за участие.");
                }
            }else if (guess <  rand){
                g.wrongAnswerLessThanQuestion();
            }else if (guess > rand){
                g.wrongAnswerBiggerThanQuestion();
            }else if (guess != rand && i >= 3){
                System.out.println("Вы проиграли. Загаданное число " + rand);
            }
        }
    }
}