package com.example.leetoxavi.bms;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //addListenerOnButton();

        Button book = (Button) findViewById(R.id.book_button);
        Button menu = (Button) findViewById(R.id.menu_button);
        Button order = (Button) findViewById(R.id.order_button);


        book.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent BookIntent = new Intent(view.getContext(), BookActivity.class);
                startActivity(BookIntent);
            }
        });

        menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent MenuIntent = new Intent(view.getContext(), BookActivity.class);
                startActivity(MenuIntent);
            }
        });

        order.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent OrderIntent = new Intent(view.getContext(), BookActivity.class);
                startActivity(OrderIntent);
            }
        });

    }



}
