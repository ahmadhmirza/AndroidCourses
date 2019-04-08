package com.example.android.miwok;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
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

        /*String[] words = new String[10];
        words[0]= "zero";
        words[1]= "one";
        words[2]= "two";
        Log.v("NumbersActivity","words at index 0: " + words[0]);*/

       final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("One","lutti",R.drawable.number_one,
                R.raw.number_one));
        words.add(new Word("Two","otiiko",R.drawable.number_two,
                R.raw.number_two));
        words.add(new Word("Three","tolookosu",R.drawable.number_three,
                R.raw.number_three));
        words.add(new Word("Four","oyyisa",R.drawable.number_four,
                R.raw.number_four));
        words.add(new Word("Five","massokka",R.drawable.number_five,
                R.raw.number_five));
        words.add(new Word("Six","temmokka",R.drawable.number_six,
                R.raw.number_six));
        words.add(new Word("Seven","kenekaku",R.drawable.number_seven,
                R.raw.number_seven));
        words.add(new Word("Eight","kawinta",R.drawable.number_eight,
                R.raw.number_eight));
        words.add(new Word("Nine","wo’e",R.drawable.number_nine,
                R.raw.number_nine));
        words.add(new Word("Ten","na’aacha",R.drawable.number_ten,
                R.raw.number_ten));

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
                new WordAdapter(this, words,R.color.category_numbers);

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
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceID());
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
