package it.namron.soccerbook.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.DialogInterface;


import it.namron.soccerbook.R;

import static it.namron.soccerbook.constant.Constant.WELCOME_USER_REQUEST;

public class SearchFieldsActivity extends AppCompatActivity {

    private ImageView mCercaPerData;
    private ImageView mCercaNome;
    private ImageView mCercaPerOrario;
    private Button mCercaCampo;


    private TextView mDataText;
    private TextView mOrarioText;


    private Toast mToast;

    private int mYear, mMonth, mDay, mHour, mMinute;
    EditText txtDate, txtTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_layout);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mCercaNome = (ImageView) findViewById(R.id.lente_nome_image_view);
        mCercaPerData = (ImageView) findViewById(R.id.lente_comune_image_view);
        mCercaPerOrario = (ImageView) findViewById(R.id.lente_distanza_image_view);

        mDataText = (TextView) findViewById(R.id.cerca_per_data_text);
        mOrarioText = (TextView) findViewById(R.id.cerca_per_orario_text);

        mCercaCampo = (Button) findViewById(R.id.cerca_campo_btn);


//        mCercaNome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showFieldsActivity();
//            }
//        });

        mCercaCampo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                showFieldsActivity();
            }
        });

        mCercaPerData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("result", "Tutto ok");
//                setResult(Activity.RESULT_OK, returnIntent);
//                finish();
                //Toast.makeText(SearchFieldsActivity.this, "You clicked on Cerca Per Comune", Toast.LENGTH_LONG).show();


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

                                mDataText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });

        mCercaPerOrario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowAlertDialogWithListview();
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


    public void ShowAlertDialogWithListview() {
        List<String> timeTables = new ArrayList<String>();
        timeTables.add("07:00");
        timeTables.add("08:00");
        timeTables.add("09:00");
        timeTables.add("10:00");
        timeTables.add("11:00");
        timeTables.add("12:00");
        timeTables.add("13:00");
        timeTables.add("14:00");
        timeTables.add("15:00");
        timeTables.add("16:00");
        timeTables.add("17:00");
        timeTables.add("18:00");
        timeTables.add("19:00");
        timeTables.add("20:00");
        timeTables.add("21:00");
        timeTables.add("22:00");
        timeTables.add("23:00");
        timeTables.add("24:00");
        //Create sequence of items
        final CharSequence[] TimeTables = timeTables.toArray(new String[timeTables.size()]);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Ora");
        dialogBuilder.setItems(TimeTables, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                mOrarioText.setText(TimeTables[item].toString());  //Selected item in listview
            }
        });

        dialogBuilder.setPositiveButton("OK", null);
        dialogBuilder.setNegativeButton("Cancel", null);

        //Create alert dialog object via builder
        AlertDialog alertDialogObject = dialogBuilder.create();
        //Show the dialog
        alertDialogObject.show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
