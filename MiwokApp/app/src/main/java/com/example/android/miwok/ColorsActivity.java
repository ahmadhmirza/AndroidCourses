package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("red","weṭeṭṭi",R.drawable.color_red));
        words.add(new Word("green","chokokki",R.drawable.color_green));
        words.add(new Word("brown","ṭakaakki",R.drawable.color_brown));
        words.add(new Word("gray","ṭopoppi",R.drawable.color_gray));
        words.add(new Word("black","kululli",R.drawable.color_black));
        words.add(new Word("white","kelelli",R.drawable.color_white));
        words.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow));
        words.add(new Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow));

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
                new WordAdapter(this, words,R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // words_listayout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);
    }
}
