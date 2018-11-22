package com.example.android.miwok;

public class Word {

    private String miwokTransaltion;
    private String defaultTranslation;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;  //member variable

    public Word (String defaultTranslation, String miwokTranslation){
        this.defaultTranslation=defaultTranslation;
        this.miwokTransaltion=miwokTranslation;

    }

    public Word (String defaultTranslation, String miwokTranslation,int ImageResourceId){
        this.defaultTranslation=defaultTranslation;
        this.miwokTransaltion=miwokTranslation;
        this.mImageResourceId = ImageResourceId;

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

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.mImageResourceId = imageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId!=NO_IMAGE_PROVIDED;

    }
}
