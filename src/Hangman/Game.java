package Hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final int MaxTries = 6;
    private String WordToGuess;
    private char[] GuessedWord;
    private int tries;
    private List<Character> Letters;
    private Scanner scanner;

    public Game(String wordToGuess) {
        this.WordToGuess = wordToGuess;
        this.GuessedWord = new char[wordToGuess.length()];
        Arrays.fill(this.GuessedWord, '*');
        this.tries = 0;
        this.Letters = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Добро пожаловать в игру Виселица!");
        System.out.println("Вы можете сдаться, введя 'exit'.");
        System.out.println("Компьютер будет загадывать рандомное слово на русском, и вы должны будете его отгадывать, вводя по 1 букве.");
        System.out.println("Нужно вводить заглавные буквы");

        while (tries < MaxTries && !isWordGuessed()) {
            System.out.println("Слово: " + new String(GuessedWord));
            System.out.print("Введите букву: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("EXIT")) {
                System.out.println("Вы сдались! Загаданным словом было: " + WordToGuess);
                return;
            }

            char Letter = input.charAt(0);

            Letters.add(Letter);

            if (WordToGuess.indexOf(Letter) >= 0) {
                for (int i = 0; i < WordToGuess.length(); i++) {
                    if (WordToGuess.charAt(i) == Letter) {
                        GuessedWord[i] = Letter;
                    }
                }
                System.out.println("Правильно!");
            } else {
                tries++;
                System.out.println("Неправильно! Осталось попыток: " + (MaxTries - tries));
            }
        }

        if (isWordGuessed()) {
            System.out.println("Победа! Вы угадали слово: " + WordToGuess);
        } else {
            System.out.println("Вы проиграли! Загаданное слово было: " + WordToGuess);
        }

        scanner.close();
    }

    private boolean isWordGuessed() {
        for (char c : GuessedWord) {
            if (c == '*') {
                return false;
            }
        }
        return true;
    }
}