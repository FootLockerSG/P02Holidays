package sg.edu.rp.c346.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter aa;
    ArrayList<Holiday> holiday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.listview_firstpage);

        Intent i = getIntent();
        int selected = i.getIntExtra("selected",0);
        holiday = new ArrayList<Holiday>();

        if(selected == 1) {
            holiday = new ArrayList<Holiday>();
            holiday.add(new Holiday("New Year's Day", "1 Jan 2017"));
            holiday.add(new Holiday("Labour Day", "1 May 2017"));
            aa = new HolidayAdapter(this, R.layout.row, holiday);
            lv.setAdapter(aa);
        }
        else {
            holiday = new ArrayList<Holiday>();
            holiday.add(new Holiday("Chinese New Year", "28-29 Jan 2017"));
            holiday.add(new Holiday("Good Friday", "14 April 2017"));
            aa = new HolidayAdapter(this, R.layout.row, holiday);
            lv.setAdapter(aa);
        }

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedFood = holiday.get(position);

                Toast.makeText(MainActivity.this, selectedFood.getText1()
                                + " Date: " + selectedFood.getText2(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

}
