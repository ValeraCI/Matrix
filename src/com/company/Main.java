package com.company;

import java.util.Scanner;

public class Main {

    static int input() {
        int x;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                x = scanner.nextInt();
                return x;
            } catch (Exception exception) {
                System.out.println("Ведите число");
            }
        }
    }


    static void output(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void inputMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.println("Укажите элемент [" + (i+1) + "][" + (j+1) + "]");
                matrix[i][j] = input();
            }
        }
    }

    static void multiplyingAString(int matrix[][]){
        int x; int y;
        System.out.println("Укажите строку");
        do{
            x = input();
        }while(x < 1 || x > matrix.length);
        x--;

        System.out.println("На какое число умножаем?");
        y = input();
        for(int i = 0; i < matrix[0].length; i++){
            matrix[x][i] *= y;
        }
    }

    static void divAString(int matrix[][]){
        int x; int y;
        System.out.println("Укажите строку");
        do{
            x = input();
        }while(x < 1 || x > matrix.length);
        x--;

        System.out.println("На какое число делим?");
        y = input();
        for(int i = 0; i < matrix[0].length; i++){
            matrix[x][i] = matrix[x][i] / y;
        }
    }

    static void addingStrings(int matrix[][]){
        int x, y, z;
        System.out.println("Укажите строку, которая будет умножена");
        do{
            x = input();
            if(x < 1 || x > matrix.length) System.out.println("Неверный номер строки");
        }while(x < 1 || x > matrix.length);
        x--;
        System.out.println("На какое число умножаем?");
        y = input();

        System.out.println("С какой строкой складываем?");
        do{
            z = input();
            if(z == (x+1) || z < 1 || z > matrix.length) System.out.println("Невырный индекс или попытка сложение строки с собой же");
        }while(z == (x+1) || z < 1 || z > matrix.length);
        z--;
        for(int i = 0; i < matrix[0].length; i++){
            matrix[z][i] += matrix[x][i] * y;
        }
    }

    static void exchangeOfLines(int matrix[][]){
       int x, y, z;
        System.out.println("Укажите первую строку");
        do{
            x = input();
            if(x < 1 || x > matrix.length) System.out.println("Неверный номер строки");
        }while(x < 1 || x > matrix.length);
        x --;
        System.out.println("Укажите вторую строку");
        do{
            y = input();
            if(y < 1 || y > matrix.length) System.out.println("Неверный номер строки");
            y--;
        }while(y < 1 || y > matrix.length);
        for(int i = 0; i < matrix[0].length; i++){
            z = matrix[x][i];
            matrix[x][i] = matrix[y][i];
            matrix[y][i] = z;
        }
    }

    static void replacinANumber(int array[][]){
        int x, y;
        System.out.println("Введите номер строки");
        do{
            x = input();
            if(x < 1 || x > array.length) System.out.println("Неверный номер строки");
        }while(x < 1 || x > array.length);
        System.out.println("Введите номер столбца");
        do{
            y = input();
            if(y < 1 || y > array.length) System.out.println("Неверный номер столбца");
        }while(y < 1 || y > array.length);

        System.out.println("На какое число хотите сменить?");
        array[x-1][y-1] = input();
    }

    static int[][] matrixMultiply(int array [][])
    {
        int x, y, res = 0;
        System.out.println("Укажите количество строк новой матрицы");
        do{
            x = input();
            if(x < 1) System.out.println("Количество строк - натуральное число");
        }while (x < 1);
        if(array[0].length != x){
            System.out.println("Количество столбцов первой матрицы не совподает с количеством строк второй. Умножение не возможно");
            throw new java.lang.Error("this is very bad");
        }
        System.out.println("Укажите количество стролбцов новой матрицы");
        do{
            y = input();
            if(y < 1) System.out.println("Количество стролбцов - натуральное число");
        }while (y < 1);
        int[][] newMatrix = new int[x][y];
        int[][] resultMatrix = new int[array.length][y];
        inputMatrix(newMatrix);
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < y; j++){
                for(int k = 0; k < array.length; k++){
                        res += array[i][k] * newMatrix[k][j];
                }
                resultMatrix[i][j] = res;
                res = 0;
            }
        }
        return resultMatrix;
    }

    public static void main(String[] args) {
            int x, y;
            boolean work = true;
            int[][] matrix;
            System.out.println("Укажите размерность матрицы:");
            System.out.print("Cтрок: ");
            x = input();
            System.out.print("Cтолбцов: ");
            y = input();
            matrix = new int[x][y];
            inputMatrix(matrix);
            output(matrix);
        while(work){
            System.out.println("Выбирите действие: \n1.Домножить строку на число\n2.Домножить строку на число и сложить с другой\n3.Поменять строки местами\n4.Заменить какой-то элемент матрицы(при неверном вводе)\n5.Поделить строку на число\n6.Умножить на другую матрицу\n0.Завершить работу");
            do{
                x = input();
                if(x < 0 || x > 6) System.out.println("Неверный индекс, повторите ввод");
            }while(x < 0 || x > 6);
            switch (x){
                case 1 ->{
                    multiplyingAString(matrix);
                    output(matrix);
                }
                case 2 ->{
                    addingStrings(matrix);
                    output(matrix);
                }
                case 3 ->{
                    exchangeOfLines(matrix);
                    output(matrix);
                }
                case 4 ->{
                    replacinANumber(matrix);
                    output(matrix);
                }
                case 5 ->{
                    divAString(matrix);
                    output(matrix);
                }
                case 6 ->{
                    try{
                        matrix = matrixMultiply(matrix);
                        output(matrix);
                    }catch (Error error){
                    }
                }
                case 0->{
                    System.out.println("Точно хотите завершить программу? Нажмите 1 если да");
                    x = input();
                    if (x == 1) work = false;
                }

            }


        }
    }
}
