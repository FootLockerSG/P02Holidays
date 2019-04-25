package sg.edu.rp.c346.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {
    private ArrayList<Holiday> holiday;
    private TextView textView1;
    private TextView textView2;
    private ImageView imageView;
    private Context context;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        textView1 = rowView.findViewById(R.id.textView);
        textView2 = rowView.findViewById(R.id.textView2);
        // Get the ImageView object
        imageView = rowView.findViewById(R.id.imageView);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday currentFood = holiday.get(position);
        // Set the TextView to show the food

        textView1.setText(currentFood.getText1());
        textView2.setText(currentFood.getText2());

        // Set the image to star or nostar accordingly

        if (currentFood.getText1().equals("New Year's Day")) {
            imageView.setImageResource(R.drawable.newyear);
        }
        else if (currentFood.getText1().equals("Labour Day")){
            imageView.setImageResource(R.drawable.labour);
        }
        else if (currentFood.getText1().equals("Chinese New Year")){
            imageView.setImageResource(R.drawable.cny);
        }
        else if (currentFood.getText1().equals("Good Friday")){
            imageView.setImageResource(R.drawable.goodfriday);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
