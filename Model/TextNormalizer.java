/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextNormalizer {
    public void normalizeText(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                // Normalize the line
                String normalizedLine = normalizeLine(line, isFirstLine);

                // Write the normalized line to the output file
                writer.write(normalizedLine);
                writer.newLine();

                isFirstLine = false;
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private String normalizeLine(String line, boolean isFirstLine) {
    line = line.trim(); // Remove leading and trailing spaces
    line = line.replaceAll("\\s+", " "); // Replace multiple spaces with a single space
    line = line.replaceAll("(\\.|,|:)(?!\\s)", "$1 "); // Add a space after dot, comma, or colon if not followed by a space

    if (isFirstLine) {
        line = capitalizeFirstCharacter(line); // Capitalize the first character of the first line
    }

    line = fixQuotes(line); // Remove spaces before and after sentence or word phrases in quotes
    line = fixSpacingBeforeCommaAndDot(line); // Remove space between comma or dot and the word in front of it
    line = fixCapitalizationAfterDot(line); // Capitalize the first character of a word after a dot

    line = line.replaceAll("\\s*\n\\s*", "\n"); // Remove blank lines between lines
    line = line.replaceAll("\\s*([,.:])\\s*", "$1"); // Remove spaces before and after comma, dot, or colon
    line = line.replaceAll("\\s*$", "."); // Add a dot at the end of text if it's missing

    return line;
}

private String capitalizeFirstCharacter(String line) {
    if (line.isEmpty()) {
        return line;
    }

    char firstChar = line.charAt(0);
    if (Character.isLowerCase(firstChar)) {
        line = Character.toUpperCase(firstChar) + line.substring(1);
    }

    return line;
}

private String fixQuotes(String line) {
    return line.replaceAll("\\s*\"(.*?)\"\\s*", " \"$1\" ");
}

private String fixSpacingBeforeCommaAndDot(String line) {
    return line.replaceAll("\\s*([,.])\\s*", "$1 ");
}

private String fixCapitalizationAfterDot(String line) {
    StringBuilder stringBuilder = new StringBuilder(line);

    boolean capitalizeNext = false;
    for (int i = 0; i < stringBuilder.length(); i++) {
        char currentChar = stringBuilder.charAt(i);

        if (currentChar == '.') {
            capitalizeNext = true;
        } else if (Character.isLetter(currentChar)) {
            if (capitalizeNext && Character.isLowerCase(currentChar)) {
                stringBuilder.setCharAt(i, Character.toUpperCase(currentChar));
                capitalizeNext = false;
            } else {
                capitalizeNext = false;
            }
        }
    }

    return stringBuilder.toString();
}
}