package com.example.android.miwok;

public class Word {

    private String miwokTransaltion;
    private String defaultTranslation;

    public Word (String defaultTranslation, String miwokTranslation){
        this.defaultTranslation=defaultTranslation;
        this.miwokTransaltion=miwokTranslation;

    }

    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public void setDefaultTranslation(String englishWord) {
        this.defaultTranslation = englishWord;
    }

    public String getMikowTransaltion() {
        return miwokTransaltion;
    }

    public void setMikowTransaltion(String miwokTransaltion) {
        this.miwokTransaltion = miwokTransaltion;
    }
}
