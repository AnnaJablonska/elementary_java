package vocabulator_app.controller;

import vocabulator_app.domain.dictionary.model.Dictionary;
import vocabulator_app.domain.dictionary.model.GameDictionary;
import vocabulator_app.domain.word.GameWord;
import vocabulator_app.domain.word.Word;
import vocabulator_app.gui.SimpleGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class VocabulatorController implements ActionListener {

    private Dictionary dictionary;
    private SimpleGUI gui;
    private Word currentWord;
    private static final int POSTIVE_INCREMENT = 1;
    private static final int NEGATIVE_INCREMENT = -2;
    private static final int MAX_SCORE = 5;
    private boolean learningComplete;


    public VocabulatorController(){
        Set<Word> demoWords = new HashSet<>();
        //tworzymy kilka przykładowych słówek krótką drogą.
        demoWords.add(new GameWord("dog", new HashSet<>(Arrays.asList("pies", "piesek"))));
        demoWords.add(new GameWord("cat", new HashSet<>(Arrays.asList("kot", "kotek"))));
        demoWords.add(new GameWord("bird", new HashSet<>(Arrays.asList("ptak", "ptaszek"))));
        //as list sama z parametrów robi listę. <wyżej>
        dictionary = new GameDictionary(demoWords);

    }

    public void setGui(SimpleGUI gui){
        this.gui = gui;
        reloadWordToTranslate();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Jestem Vocabulator Controller");


        String userTransaltion = gui.getTranslationFiledText();
        System.out.println("----" + userTransaltion);
        boolean translationCorrect = currentWord.checkTranslation(userTransaltion);
        if (translationCorrect){
            gui.setInfoLabel("SUKCES " + currentWord.translations());
            currentWord.incrementScore(POSTIVE_INCREMENT);
        } else {
            gui.setInfoLabel("TRY AGAIN "+ currentWord.translations());
            currentWord.incrementScore(NEGATIVE_INCREMENT);
        }

        gui.resetTranslationField();
        reloadWordToTranslate();
    }

    private void reloadWordToTranslate(){
       currentWord = nextWord();
       gui.setOriginLabel(currentWord.origin());

    }

    private Word nextWord(){
        //tworze liste na podstawie kolekcji slowek ze słownika
        List<Word> words = new ArrayList<>(dictionary.getWords());



        //szykuje liste slowek ktorych musze sie nauczyc
        List<Word> wordLeftToGuess = new ArrayList<>();
        for (Word word:words){
            if (word.score()<MAX_SCORE){
                wordLeftToGuess.add(word);
            }
        }

        //szykuje liste slowek, ktorych musze sie nauczyc

        return null;
    }
}
