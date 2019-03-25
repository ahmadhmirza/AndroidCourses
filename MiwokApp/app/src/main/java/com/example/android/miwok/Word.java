package com.example.android.miwok;

public class Word {

    private String miwokTransaltion;
    private String defaultTranslation;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;  //member variable
    private int mAudioResourceID;

    public Word (String defaultTranslation, String miwokTranslation, int audioResourceID){
        this.defaultTranslation=defaultTranslation;
        this.miwokTransaltion=miwokTranslation;
        this.mAudioResourceID = audioResourceID;

    }

    public Word (String defaultTranslation, String miwokTranslation,int ImageResourceId, int audioResourceID){
        this.defaultTranslation=defaultTranslation;
        this.miwokTransaltion=miwokTranslation;
        this.mImageResourceId = ImageResourceId;
        this.mAudioResourceID = audioResourceID;

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

    public int getAudioResourceID() {
        return mAudioResourceID;
    }

    public void setAudioResourceID(int mResourceID) {
        this.mAudioResourceID = mResourceID;
    }
}
