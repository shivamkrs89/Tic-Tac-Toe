package com.example.ttt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//0-X
    //1-O
    //2-null
    int active=0;
    boolean gameactive=true;
    int tt=0;
    int [] gamestate={2,2,2,2,2,2,2,2,2};

    int [][] winpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    @SuppressLint("SetTextI18n")
    public void tap(View v)
    {
        ImageView img= (ImageView)v;

    int clicked= Integer.parseInt(String.valueOf(img.getTag()));
    if(gamestate[clicked]==2 && gameactive)
    {
        tt++;
        gamestate[clicked]=active;
        img.setTranslationY(-1000f);
        if(active==0) {
            img.setImageResource(R.drawable.x);
            active = 1;
            TextView status= findViewById(R.id.statusbar);
            status.setText("O's-Turn Tap to PLAY");

        }
        else {
            img.setImageResource(R.drawable.o);
            active = 0;
            TextView status= findViewById(R.id.statusbar);
            status.setText("X's-Turn Tap to PLAY");
        }

        img.animate().translationYBy(1000f).setDuration(350);

    }
    else gamerestart(v);
    //checking if any won
        for(int[] winposition : winpos)
        {
            if (gamestate[winposition[0]]==gamestate[winposition[1]] && gamestate[winposition[1]]==gamestate[winposition[2]] && gamestate[winposition[0]]==1)
            {
                TextView status= findViewById(R.id.statusbar);
                status.setText("O has won!");
                gameactive=false;
            }
            else if (gamestate[winposition[0]]==gamestate[winposition[1]] && gamestate[winposition[1]]==gamestate[winposition[2]] && gamestate[winposition[0]] == 0)
            {
                TextView status= findViewById(R.id.statusbar);
                status.setText("X has won!");
                gameactive=false;
            }
            else if(tt==9)
            {
                TextView status= findViewById(R.id.statusbar);
                status.setText("Game Tied :< Tap again to play");
                gameactive=false;
            }
        }

    }


public void gamerestart(View V)
{
    gameactive=true;
    active=0;
    for(int i=0;i<gamestate.length;i++)
    {
        gamestate[i]=2;
    }

    ((ImageView)findViewById(R.id.cc0)).setImageResource(0);
    ((ImageView)findViewById(R.id.cc1)).setImageResource(0);
    ((ImageView)findViewById(R.id.cc2)).setImageResource(0);
    ((ImageView)findViewById(R.id.cc3)).setImageResource(0);
    ((ImageView)findViewById(R.id.cc4)).setImageResource(0);
    ((ImageView)findViewById(R.id.cc5)).setImageResource(0);
    ((ImageView)findViewById(R.id.cc6)).setImageResource(0);
    ((ImageView)findViewById(R.id.cc7)).setImageResource(0);
    ((ImageView)findViewById(R.id.cc8)).setImageResource(0);

    TextView status= findViewById(R.id.statusbar);
    status.setText("X's-Turn Tap to PLAY");
  tt=0;
}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
