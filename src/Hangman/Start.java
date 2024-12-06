package Hangman;

public class Start {
    public static void main(String[] args) {
        WordsList wordsList = new WordsList();
        String wordToGuess = wordsList.getRandomWord();

        Game game = new Game(wordToGuess);
        game.start();
    }
}
