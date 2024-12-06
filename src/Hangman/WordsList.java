package Hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordsList {
    private static final List<String> WORDS = Arrays.asList("ТБАНК", "КЛАВИАТУРА", "МЫШКА", "КОМПЬЮТЕР", "НОУТБУК", "АЛГОРИТМ", "ИНДЕКС", "ПРОГРАММИРОВАНИЕ");
    private Random random;

    public WordsList() {
        this.random = new Random();
    }

    public String getRandomWord() {
        return WORDS.get(random.nextInt(WORDS.size()));
    }
}