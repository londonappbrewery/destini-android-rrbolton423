package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;

    /*
    You will need to keep track of where the user is in the story since we have more
    than one path that the player can take. Similar to how we were tracking which quiz
    question the user was on in Quizzler, we will use a dedicated variable to track the
    app’s state. To help accomplish this, define a variable of type integer (int) below
    the corresponding Call this variable mStoryIndex. Initialise it with the value 1
    (i.e., make mStoryIndex equal to 1 to start).
     */

    private int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) { // If the top button was clicked first ...
                    // Show the 3rd story
                    mStoryTextView.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                    mStoryIndex = 2; // Change the index so that either the bottom button or top button can react after it
                } else if (mStoryIndex == 2) { // If the top button was clicked 2 times in a row ...
                    // Show the 6th ending
                    mStoryTextView.setText(R.string.T6_End);
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);
                    // GAME OVER
                } else if (mStoryIndex == 3) { // If the top button was clicked after the bottom button was clicked ...
                    // Show the 3rd story
                    mStoryTextView.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                    mStoryIndex = 4; // Change the index so that either the bottom button or top button can react after it
                } else if (mStoryIndex == 4) { // If the top button was clicked after the bottom button, and after the top button was clicked ...
                    // Show the 6th ending
                    mStoryTextView.setText(R.string.T6_End);
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);
                    // GAME OVER
                }

            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) { // If the bottom button is the first button clicked ...
                    // Show the 2nd story
                    mStoryTextView.setText(R.string.T2_Story);
                    mButtonTop.setText(R.string.T2_Ans1);
                    mButtonBottom.setText(R.string.T2_Ans2);
                    mStoryIndex = 3; // Change the index so that either the bottom button or top button can react after it
                } else if (mStoryIndex == 3) { // If the bottom button is clicked 2 times in a row ...
                    // Show the 4th ending
                    mStoryTextView.setText(R.string.T4_End);
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);
                    // GAME OVER
                } else if (mStoryIndex == 2) { // If the bottom button is clicked after the top button was clicked ...
                    // Show the 5th ending
                    mStoryTextView.setText(R.string.T5_End);
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);
                    // GAME OVER
                } else if (mStoryIndex == 4) { // If the bottom button is clicked after the bottom button, and after the top button was clicked ...
                    // Show the 5th ending
                    mStoryTextView.setText(R.string.T5_End);
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);
                    // GAME OVER
                }


            }
        });

    }

}
