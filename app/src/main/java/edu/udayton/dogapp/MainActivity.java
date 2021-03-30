package edu.udayton.dogapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.os.Build.VERSION_CODES.N;

public class MainActivity extends AppCompatActivity {

    private TextView   resTextView; //output TextView

    private static final Calendar cal=Calendar.getInstance();
    private static final DateFormat fmtDate =DateFormat.getDateInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         resTextView=(TextView)findViewById(R.id.resTextView);
        Button  btndate=(Button)findViewById(R.id.btnDate);

        btndate.setOnClickListener(btnDateListener);

    }//end on create method

    DatePickerDialog.OnDateSetListener dateSetListener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            // set date and time in calander

            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, monthOfYear);
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            // get the selected date from ther calender and show it to user

            Date reservedDate= cal.getTime();
            resTextView.setText("Your reservation is set for: "+fmtDate.format(reservedDate));

        }
    };

    // setup listener for btnDate button

    Button.OnClickListener btnDateListener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            //get the selected date from the calender
            //if not selected show the current date
            int year= cal.get(Calendar.YEAR);
            int monthOfYear=cal.get(Calendar.MONTH);
            int dayOfMonth= cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, dateSetListener,year, monthOfYear,dayOfMonth);
            datePickerDialog.show();
        }
    };

}//end main activity method
