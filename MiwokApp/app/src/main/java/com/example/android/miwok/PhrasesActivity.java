package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    private  MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Where are you going?","minto wuksus",
                R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?","tinnә oyaase'nә",
                R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...","oyaaset...",
                R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?","michәksәs?",
                R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I’m feeling good.","kuchi achit",
                R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","әәnәs'aa?",
                R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I’m coming.","hәә’ әәnәm",
                R.raw.phrase_yes_im_coming));
        words.add(new Word("I’m coming.","әәnәm",
                R.raw.phrase_im_coming));
        words.add(new Word("Let’s go.","yoowutis",
                R.raw.phrase_lets_go));
        words.add(new Word("Come here.","әnni'nem",
                R.raw.phrase_come_here));

        /*
         * Refer to the RootView linear Layout view programmatically
         * Create new Text views to display the data using java instead of xml
         */

        /*LinearLayout rootView = (LinearLayout)findViewById(R.id.root_view);
        for(int i =0;i<words.size(); i++){
            TextView wordView = new TextView(this);
            wordView.setText(words.get(i));
            rootView.addView(wordView);
        }*/

        /*View recycling****
         * List view and array adapter structure
         * Views not being displayed are put in Scrap Views.
         * Create more rows on demand bz reusing views in the scrap pile
         *   memory monitor
         *   tools - android - enable adb integration
         */

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        ArrayAdapter<Word> itemsAdapter =
                new WordAdapter(this, words,R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // words_listayout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceID());
                mMediaPlayer.start(); // no need to call prepare(); create() does that for you
                //On completion listener to release the mediaplayer resources
                //efficient resource handling
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
