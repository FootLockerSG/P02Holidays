package sg.edu.rp.c346.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<String> Years;
    ArrayAdapter<String> aaYears;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ListView lvfirst = findViewById(R.id.listview_first);

        Years = new ArrayList<>();
        Years.add("secular");
        Years.add("Ethnic & Religion");

        aaYears = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, Years);
        lvfirst.setAdapter(aaYears);

        lvfirst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.putExtra("selected", i+1);
                startActivity(intent);
            }
        });

    }
}
