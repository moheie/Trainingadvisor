package entity.course.material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;

public class MCQ extends Question {
    private static char[] choiceCharacters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private String question;
    private List<String> choices = new ArrayList<>();
    private int correctChoiceIndex;

    public MCQ(String question) {
        this.question = question;
    }

    private static int getCharIndex(char character) {
        return character - choiceCharacters[0];
    }

    public void addChoice(String choice) {
        choices.add(choice);
    }

    public int getCorrectChoiceIndex() {
        return correctChoiceIndex;
    }

    public void setCorrectChoiceIndex(int index) {
        this.correctChoiceIndex = index;
    }

    @Override
    public void display() {
        System.out.println(question);

        int counter = 0;

        for (String choice: choices) {
            System.out.printf("%c) %s\n", choiceCharacters[counter++], choice);
        }
    }

    @Override
    public void displayPreview() {
        System.out.printf("[MCQ] %s\n", question);
    }

    // verifies a choice is between a-z
    @Override
    public boolean validateAnswer(char answer) {
        answer = Character.toLowerCase(answer);

        return !(answer < choiceCharacters[0] || answer > choiceCharacters[choices.size() - 1]);
    }

    @Override
    public boolean checkAnswer(char answer) {
        answer = Character.toLowerCase(answer);
        int index = getCharIndex(answer);

        return getCorrectChoiceIndex() == index;
    }
}
