/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.TextNormalizer;
import View.ConsoleView;

public class TextNormalizerController {
    private TextNormalizer textNormalizer;
    private ConsoleView consoleView;

    public TextNormalizerController(TextNormalizer textNormalizer, ConsoleView consoleView) {
        this.textNormalizer = textNormalizer;
        this.consoleView = consoleView;
    }

    public void start() {
        String inputFile = consoleView.getInputFilePath();
        String outputFile = consoleView.getOutputFilePath();

        textNormalizer.normalizeText(inputFile, outputFile);

        consoleView.displayMessage("Text normalization completed.");
    }
}