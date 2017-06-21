package com.andro.indieschool.myfunapp.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.andro.indieschool.myfunapp.BR;

/**
 * Created by herisulistiyanto on 6/21/17.
 */

public class MainViewModel extends BaseObservable {

    private String firstWord;
    private String secondWord;
    private String result;
    private String longWords;
    private String shortWords;

    public MainViewModel() {
    }

    @Bindable
    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
        notifyPropertyChanged(BR.firstWord);
        notifyPropertyChanged(BR.buttonEnabled);
    }

    @Bindable
    public String getSecondWord() {
        return secondWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
        notifyPropertyChanged(BR.secondWord);
        notifyPropertyChanged(BR.buttonEnabled);
    }

    public void updateTextResult(boolean result) {
        this.result = (result) ? "ANAGRAM" : "NOT ANAGRAM";
        notifyPropertyChanged(BR.textResult);
    }

    @Bindable
    public String getTextResult() {
        return result;
    }

    @Bindable
    public boolean getButtonEnabled() {
        return (!TextUtils.isEmpty(firstWord) && !TextUtils.isEmpty(secondWord));
    }

    @Bindable
    public String getLongWords() {
        return longWords;
    }

    public void setLongWords(String longWords) {
        this.longWords = longWords;
        notifyPropertyChanged(BR.longWords);
        notifyPropertyChanged(BR.shortWords);
        setShortWords(shortingWords(longWords));
    }

    @Bindable
    public String getShortWords() {
        return shortWords;
    }

    public void setShortWords(String shortWords) {
        this.shortWords = shortWords;
        notifyPropertyChanged(BR.shortWords);
    }

    private String shortingWords(String longWords) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < longWords.length(); i++) {
            while (i + 1 < longWords.length() && longWords.charAt(i) == longWords.charAt(i + 1)) {
                i++;
            }
            result.append(longWords.charAt(i));
        }
        return result.toString();
    }
}
