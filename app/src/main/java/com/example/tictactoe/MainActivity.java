package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //0=X
    //1=O
    //2=BLANK
    int activePlayer=0;
    int winPositions[][]={
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };
    int gameState[]={2,2,2,2,2,2,2,2,2};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onImgClick(View view)
    {
        ImageView img=(ImageView)view;
        int clickedBox=Integer.parseInt(img.getTag().toString());
        TextView status=findViewById(R.id.status);
        if(gameState[clickedBox]==2 )
        {
            gameState[clickedBox]=activePlayer;
            img.setTranslationY(-1000f);
          if(activePlayer==0)
          {
              img.setImageResource(R.drawable.x);
              status.setText("O's Turn -Tap to Play");
              activePlayer=1;

          }
          else
          {
              img.setImageResource(R.drawable.o);
              status.setText("X's Turn -Tap to Play");
              activePlayer=0;
          }
            img.animate().translationYBy(1000f).setDuration(300);
        }


        for(int[] winPos:winPositions)
        {
            if((gameState[winPos[0]]==gameState[winPos[1]])&&(gameState[winPos[1]]==gameState[winPos[2]])&&(gameState[winPos[0]]==gameState[winPos[2]])&&gameState[winPos[0]]!=2)
            {
                if(gameState[winPos[0]]==0)
                {
                    status.setText("X has Won");
                }
                else
                {
                    status.setText("O has Won");
                }
            }
        }
    }
    //Check if any Player Won

}