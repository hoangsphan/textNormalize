/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.Scanner;

public class ConsoleView {
    public String getInputFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input file path: ");
        return scanner.nextLine();
    }

    public String getOutputFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the output file path: ");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
