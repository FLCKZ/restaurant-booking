package com.example.leetoxavi.bms;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.Gallery;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class OrderActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ProgressBar barTimer;
    TextView textTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        startTimer(2);

        ListView selectedItems = (ListView)findViewById(R.id.items);

        List<MealMenuItem> OrderItems = (List<MealMenuItem>)getIntent().getSerializableExtra("MenuSelectedItems");

        if(OrderItems != null){
            selectedItems.setAdapter(new OrderListViewAdapter(this, OrderItems));
            double billTotal = 0;
            for(int i = 0; i < OrderItems.size(); i++){
                billTotal += OrderItems.get(i).menuItemPrice;
            }
            TextView billTotalView = (TextView)findViewById(R.id.bill_total_view);
            billTotalView.setText("Your bill total is R"+billTotal);
        }


    }
    private void startTimer(final int minuti) {
        CountDownTimer countDownTimer = new CountDownTimer(60 * minuti * 1000, 500) {
            // 500 means, onTick function will be called at every 500 milliseconds

            @Override
            public void onTick(long leftTimeInMilliseconds) {

                long seconds = leftTimeInMilliseconds / 1000;
                //progressBar = ((ProgressBar)findViewById(R.id.progress_bar));
                textTimer = ((TextView)findViewById(R.id.textTimer));

                //progressBar.setProgress((int)seconds);
                textTimer.setText(String.format("%02d", seconds/60) + ":" + String.format("%02d", seconds%60));
                // format the textview to show the easily readable format

            }
            @Override
            public void onFinish() {
                if(textTimer.getText().equals("00:00")){
                    textTimer.setText("STOP");
                }
                else{
                    textTimer.setText("2:00");
                    //barTimer.setProgress(60*minuti);
                }
            }
        }.start();

    }

}
