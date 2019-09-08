package it.namron.soccerbook.activity;

import android.content.Context;
import android.support.v7.app.AlertDialog;
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

    AlertDialog.Builder builder;


    private ImageView mCercaPerData;
    private ImageView mCercaNome;
    private ImageView mCercaPerOrario;
    private Button mCercaCampo;


    private TextView mDataText;
    private TextView mOrarioText;
    private TextView mCercaPerNome;


    private Toast mToast;

    private int mYear, mMonth, mDay, mHour, mMinute;
    EditText txtDate, txtTime;

    DatePickerDialog mDatePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_layout);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

//        mCercaNome = (ImageView) findViewById(R.id.lente_nome_image_view);
        mCercaPerData = (ImageView) findViewById(R.id.lente_comune_image_view);
        mCercaPerOrario = (ImageView) findViewById(R.id.lente_distanza_image_view);

        mDataText = (TextView) findViewById(R.id.cerca_per_data_text);
        mOrarioText = (TextView) findViewById(R.id.cerca_per_orario_text);
        mCercaPerNome = (TextView) findViewById(R.id.cerca_per_nome_text);

        mCercaCampo = (Button) findViewById(R.id.cerca_campo_btn);


//        mCercaNome.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showFieldsActivity();
//            }
//        });

        mOrarioText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowAlertDialogWithListview();
            }
        });

        mDataText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selezionaDataCampo(SearchFieldsActivity.this);
            }
        });

        mCercaCampo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCercaPerNome.getText().toString().equals("")) {
                    showdialogBox("Selezionare il campo", view);
                } else {
                    if (mDataText.getText().toString().equals("")) {
                        showdialogBox("Selezionare la data", view);
                    } else {
                        if (mOrarioText.getText().toString().equals("")) {
                            showdialogBox("Selezionare l'orario", view);
                        } else {
                            showFieldsActivity();
                        }
                    }
                }
            }

            private void showdialogBox(String infoText, View view) {
                builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage(infoText)
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Attenzione");
                alert.show();
            }
        });

        mCercaPerData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selezionaDataCampo(view.getContext());
            }
        });

        mCercaPerOrario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowAlertDialogWithListview();
            }
        });
    }

    private void selezionaDataCampo(Context context) {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        mDatePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        mDataText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);


        mDatePickerDialog.show();
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
