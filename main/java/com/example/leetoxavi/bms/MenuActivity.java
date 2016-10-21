package com.example.leetoxavi.bms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TabHost;

public class MenuActivity extends AppCompatActivity {


    List<List<MealMenuItem>> MenuScrollViewImages = new MenuScrollViewData().getData();
    GridView[] MenuScrollView = new GridView[MenuScrollViewImages.size()];
    View[] SelectionIndicators;
    View[] SelectionCount;
    ArrayList<MealMenuItem> SelectedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TabHost MenuTabHost = (TabHost) findViewById(R.id.menu_tab_host);
        MenuTabHost.setup();

        TabHost.TabSpec MenuSpec = MenuTabHost.newTabSpec("Meals");
        MenuSpec.setContent(R.id.meal_grid_view);
        MenuSpec.setIndicator("Meals");
        MenuTabHost.addTab(MenuSpec);

        MenuSpec = MenuTabHost.newTabSpec("Drinks");
        MenuSpec.setContent(R.id.drink_grid_view);
        MenuSpec.setIndicator("Drinks");
        MenuTabHost.addTab(MenuSpec);

        MenuSpec = MenuTabHost.newTabSpec("Desserts");
        MenuSpec.setContent(R.id.dessert_grid_view);
        MenuSpec.setIndicator("Desserts");
        MenuTabHost.addTab(MenuSpec);

        //MenuTabHost.setCurrentTab(1);

        Button order = (Button) findViewById(R.id.order_button);


        MenuScrollView[0] = (GridView) findViewById(R.id.meal_grid_view);
        MenuScrollView[1] = (GridView) findViewById(R.id.drink_grid_view);
        MenuScrollView[2] = (GridView) findViewById(R.id.dessert_grid_view);

        SelectionIndicators = new View[]{(View)findViewById(R.id.selected_meal),
                                               (View)findViewById(R.id.selected_drink),
                                               (View)findViewById(R.id.selected_dessert)};


        SelectedItems = new ArrayList<>();

        for(int i = 0; i < MenuScrollView.length; i++){

            final MenuScrollViewAdapter menuScrollViewAdapter = new MenuScrollViewAdapter(this, MenuScrollViewImages.get(i));
            MenuScrollView[i].setAdapter(menuScrollViewAdapter);

            final int finalI = i;
            MenuScrollView[i].setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    view.setBackgroundColor(getResources().getColor(R.color.colorPrimary,null));
                    SelectionIndicators[finalI].setBackgroundColor(getResources().getColor(R.color.colorPrimary, null));


                    SelectedItems.add(menuScrollViewAdapter.getItem(position));


                    //SelectedItems.add(view.getResources().getResourceEntryName((int)id));

                    System.out.println(menuScrollViewAdapter.getItem(position).menuItemPrice);
                    System.out.println(view.getResources().getResourceEntryName((int)id));
                }
            });
        }

        order.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent OrderIntent = new Intent(view.getContext(), OrderActivity.class);
                OrderIntent.putExtra("MenuSelectedItems", SelectedItems);
                startActivity(OrderIntent);
            }
        });
    }
}
