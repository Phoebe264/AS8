/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Integer> userPos = new ArrayList<Integer>();
    private static ArrayList<Integer> cpuPos = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] gameBoard = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        while (true) {
            printGameBoard(gameBoard);
            System.out.println("\nPLAYER TURN\n");
            System.out.println("Enter you placement (1 - 9) ");
            int choice = scan.nextInt();
            while (checkCorrectPosition(gameBoard, (int) choice) == false) {
                System.out.println("Invalid Choice");
                System.out.println("Enter you placement (1 - 9) ");
                choice = scan.nextInt();
            }
            placePiece(gameBoard, choice, "player");
            if (!"".equals(checkWinner())) {
                break;
            }

            printGameBoard(gameBoard);

            System.out.println("\nCPU TURN\n");
            choice = rand.nextInt(9) + 1;
            while (checkCorrectPosition(gameBoard, (int) choice) == false) {

                choice = rand.nextInt(9) + 1;
            }
            placePiece(gameBoard, choice, "cpu");
            if (!"".equals(checkWinner())) {
                break;
            }
        }
        printGameBoard(gameBoard);

        String status = checkWinner();
        if (status.compareTo("Draw") == 0) {
            System.out.println("CAT!");
        } else if (status.compareTo("Player") == 0) {
            System.out.println("Congratulations You won!");
        } else {
            System.out.println("CPU wins!Sorry:(");
        }

    }

    public static boolean checkCorrectPosition(char[][] gameBoard, int pos) {
        if (pos < 1 || pos > 9) {
            return false;
        }
        pos--;
        return gameBoard[pos / 3][pos % 3] == ' ';
    }

    public static void printGameBoard(char[][] gameBoard) {
        System.out.println(gameBoard[0][0] + "|" + gameBoard[0][1] + "|" + gameBoard[0][2]);
        System.out.println("-+-+-");
        System.out.println(gameBoard[1][0] + "|" + gameBoard[1][1] + "|" + gameBoard[1][2]);
        System.out.println("-+-+-");
        System.out.println(gameBoard[2][0] + "|" + gameBoard[2][1] + "|" + gameBoard[2][2]);
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
        pos--;

        if (user.equals("player")) {
            gameBoard[pos / 3][pos % 3] = 'X';
            userPos.add(++pos);
        } else {
            gameBoard[pos / 3][pos % 3] = 'O';
            cpuPos.add(++pos);

        }
    }

    public static String checkWinner() {
        if (userPos.contains(1) && userPos.contains(2) && userPos.contains(3)
                || userPos.contains(4) && userPos.contains(5) && userPos.contains(6)
                || userPos.contains(7) && userPos.contains(8) && userPos.contains(9)
                || userPos.contains(1) && userPos.contains(4) && userPos.contains(7)
                || userPos.contains(2) && userPos.contains(5) && userPos.contains(8)
                || userPos.contains(3) && userPos.contains(6) && userPos.contains(9)
                || userPos.contains(1) && userPos.contains(5) && userPos.contains(9)
                || userPos.contains(7) && userPos.contains(5) && userPos.contains(3)) {
            return "Player";
        } else if (cpuPos.contains(1) && cpuPos.contains(2) && cpuPos.contains(3)
                || cpuPos.contains(4) && cpuPos.contains(5) && cpuPos.contains(6)
                || cpuPos.contains(7) && cpuPos.contains(8) && cpuPos.contains(9)
                || cpuPos.contains(1) && cpuPos.contains(4) && cpuPos.contains(7)
                || cpuPos.contains(2) && cpuPos.contains(5) && cpuPos.contains(8)
                || cpuPos.contains(3) && cpuPos.contains(6) && cpuPos.contains(9)
                || cpuPos.contains(1) && cpuPos.contains(5) && cpuPos.contains(9)
                || cpuPos.contains(7) && cpuPos.contains(5) && cpuPos.contains(3)) {
            return "CPU";
        } else if (cpuPos.size() + userPos.size() == 9) {
            return "Draw";
        } else {
            return "";
        }
    }

}
