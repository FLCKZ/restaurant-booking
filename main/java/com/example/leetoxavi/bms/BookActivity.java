package com.example.leetoxavi.bms;

import android.support.annotation.DrawableRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;



public class BookActivity extends AppCompatActivity {


    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ExpandableListData.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, final View v,
                                        int groupPosition, int childPosition, long id) {

                String selection = expandableListDetail.get(expandableListTitle.get(groupPosition)).get(childPosition);
                System.out.println("Here we're "+selection);
                //v.setBackgroundColor(getResources().getColor(R.color.colorPrimary,null));

                // Connect to database (in database -> IDB)
                // Check if selected table is available( 'selection'_table_booking => 1) for booking (IDB)
                // If yes decrement 'selection'_table_booking by 1 and toast ('selection' booked)  (IDB)
                /// Then transition to order page or prompt ETA page

                AlertDialog alertDialog = new AlertDialog.Builder(BookActivity.this).create();
                alertDialog.setTitle("BOOKING");
                alertDialog.setMessage("You booked a "+selection+"\nYour booking will be valid for 1 hour \nProceed to menu");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent MenuIntent = new Intent(v.getContext(), MenuActivity.class);
                                startActivity(MenuIntent);
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                //Increment 'selection'_table_booking by 1 (IDB)
                            }
                        });
                alertDialog.show();


                // If not toast ('selection' out booked. try a different table)
                // set item color to red (v.setBackgroundColor(getResources().getColor(R.color.colorPrimary,null));)
                /// Then remain on the current page



                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });

    }

}
