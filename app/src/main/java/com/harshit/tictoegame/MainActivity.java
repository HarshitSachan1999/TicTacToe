package com.harshit.tictoegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean status = true;
    int[] pressed = {3,3,3,3,3,3,3,3,3};
    int[][] winningPos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int player = 1;
    public void insert (View view){

        ImageView image = (ImageView)view;
        if(pressed[Integer.parseInt(image.getTag().toString())]==3&&status) {
            image.setAlpha(0f);
            if (player == 1) {
                image.setImageResource(R.drawable.o);
                pressed[Integer.parseInt(image.getTag().toString())] = player;
                player = 2;
            } else {
                image.setImageResource(R.drawable.x);
                pressed[Integer.parseInt(image.getTag().toString())] = player;
                player = 1;
            }
            image.animate().alpha(1f).setDuration(100);
        }
        for(int[] result : winningPos){
            if(pressed[result[0]]==pressed[result[1]]&&pressed[result[1]]==pressed[result[2]]&&pressed[result[0]]!=3&&status) {
                String winner = "1";
                if(pressed[result[0]]==2)
                    winner = "2" ;
                TextView textView = findViewById(R.id.textView4);
                textView.setVisibility(View.VISIBLE);
                textView.setText("player " + winner + " has WON");
                status = false;
            }
        }
    }

    public void playAgain (View view){

        TextView textView = findViewById(R.id.textView4);
        GridLayout r = findViewById(R.id.gridLayout);
        for(int i=0;i<9;i++)
            pressed[i]=3;
        (findViewById(R.id.imageView0)).setAlpha(0f);
        (findViewById(R.id.imageView1)).setAlpha(0f);
        (findViewById(R.id.imageView2)).setAlpha(0f);
        (findViewById(R.id.imageView3)).setAlpha(0f);
        (findViewById(R.id.imageView4)).setAlpha(0f);
        (findViewById(R.id.imageView5)).setAlpha(0f);
        (findViewById(R.id.imageView6)).setAlpha(0f);
        (findViewById(R.id.imageView7)).setAlpha(0f);
        (findViewById(R.id.imageView8)).setAlpha(0f);
        textView.setVisibility(View.INVISIBLE);
        player = 1;
        status = true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
