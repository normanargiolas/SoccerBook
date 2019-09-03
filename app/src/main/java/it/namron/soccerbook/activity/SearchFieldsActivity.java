package it.namron.soccerbook.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import it.namron.soccerbook.R;

import static it.namron.soccerbook.constant.Constant.WELCOME_USER_REQUEST;

public class SearchFieldsActivity extends AppCompatActivity {

    private ImageView mCercaComune;
    private ImageView mCercaNome;
    private ImageView mCercaDistanza;

    private Toast mToast;

    private int mYear, mMonth, mDay, mHour, mMinute;
    EditText txtDate, txtTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_layout);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mCercaNome = (ImageView) findViewById(R.id.lente_nome_image_view);
        mCercaComune = (ImageView) findViewById(R.id.lente_comune_image_view);
        mCercaDistanza = (ImageView) findViewById(R.id.lente_distanza_image_view);


        mCercaNome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("result", "Tutto ok");
//                setResult(Activity.RESULT_OK, returnIntent);
//                finish();
//                Toast.makeText(SearchFieldsActivity.this, "You clicked on Cerca Per Nome", Toast.LENGTH_LONG).show();
                showFieldsActivity();
            }
        });

        mCercaComune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("result", "Tutto ok");
//                setResult(Activity.RESULT_OK, returnIntent);
//                finish();
                Toast.makeText(SearchFieldsActivity.this, "You clicked on Cerca Per Comune", Toast.LENGTH_LONG).show();


                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

//                                txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);


                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });

        mCercaDistanza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("result", "Tutto ok");
//                setResult(Activity.RESULT_OK, returnIntent);
//                finish();
//                Toast.makeText(SearchFieldsActivity.this, "You clicked on Cerca Per Distanza", Toast.LENGTH_LONG).show();
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);



                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(view.getContext(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

//                                txtTime.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, true);



                timePickerDialog.show();
            }
        });
    }

    private Intent makeFieldsIntent() {
        Class destinationActivity = FieldsActivity.class;
        Intent intent = new Intent(getApplicationContext(), destinationActivity);
        return intent;
    }

    private void showFieldsActivity() {
        try {
            Intent appInfoIntent = makeFieldsIntent();
            if (appInfoIntent != null)
                startActivityForResult(appInfoIntent, WELCOME_USER_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
