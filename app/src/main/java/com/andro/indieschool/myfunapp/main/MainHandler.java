package com.andro.indieschool.myfunapp.main;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by herisulistiyanto on 6/21/17.
 */

public class MainHandler {

    private MainViewModel viewModel;
    private MainView view;

    public MainHandler(MainViewModel viewModel, MainView view) {
        this.viewModel = viewModel;
        this.view = view;
    }

    public void onClickCheck() {
        viewModel.updateTextResult(
                checkWords(viewModel.getFirstWord(), viewModel.getSecondWord())
        );
    }

    private boolean checkWords(String firstWord, String secondWord) {
        if (firstWord.length() <= 0 || secondWord.length() <= 0) {
            return false;
        }
        if (firstWord.length() != secondWord.length()) {
            return false;
        }
        char[] targetOne = firstWord.toLowerCase().toCharArray();
        char[] targetTwo = secondWord.toLowerCase().toCharArray();

        Map<Character, Integer> mapWord = new HashMap<Character, Integer>();
        for (char c : targetOne) {
            int count = 1;
            if (mapWord.containsKey(c)) {
                count = mapWord.get(c) + 1;
            }
            mapWord.put(c, count);
        }

        for (char c : targetTwo) {
            int count = -1;
            if (mapWord.containsKey(c)) {
                count = mapWord.get(c) - 1;
            }
            mapWord.put(c, count);
        }

        for (char c : mapWord.keySet()) {
            if (mapWord.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

    public void onClickStart() {
        view.launchSecondActivity();
    }

}
