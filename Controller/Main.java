/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import Model.TextNormalizer;
import View.ConsoleView;

/**
 *
 * @author macbookpro
 */
public class Main {
    public static void main(String[] args) {
        TextNormalizer textNormalizer = new TextNormalizer();
        ConsoleView consoleView = new ConsoleView();
        TextNormalizerController controller = new TextNormalizerController(textNormalizer, consoleView);

        controller.start();
    }
}
