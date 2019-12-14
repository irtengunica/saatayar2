package com.example.okul.saatayar2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {
    Button saatButton,tarihButton;
    TextView saatTextView,tarihTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saatButton = (Button) findViewById(R.id.button1);
        tarihButton = (Button) findViewById(R.id.button2);
        saatTextView = (TextView) findViewById(R.id.textView1);
        tarihTextView = (TextView) findViewById(R.id.textView2);
        saatButton.setOnClickListener(new View.OnClickListener() {//saatButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();//
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);//G�ncel saati ald�k
                int minute = mcurrentTime.get(Calendar.MINUTE);//G�ncel dakikay� ald�k
                TimePickerDialog timePicker; //Time Picker referans�m�z� olu�turduk

                //TimePicker objemizi olu�turuyor ve click listener ekliyoruz
                timePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        saatTextView.setText( selectedHour + ":" + selectedMinute);//Ayarla butonu t�kland���nda textview'a yazd�r�yoruz
                    }
                }, hour, minute, true);//true 24 saatli sistem i�in
                timePicker.setTitle("Saat Se�iniz");
                timePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", timePicker);
                timePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "�ptal", timePicker);

                timePicker.show();
            }
        });
        tarihButton.setOnClickListener(new View.OnClickListener() {//tarihButona Click Listener ekliyoruz

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int year = mcurrentTime.get(Calendar.YEAR);//G�ncel Y�l� al�yoruz
                int month = mcurrentTime.get(Calendar.MONTH);//G�ncel Ay� al�yoruz
                int day = mcurrentTime.get(Calendar.DAY_OF_MONTH);//G�ncel G�n� al�yoruz

                DatePickerDialog datePicker;//Datepicker objemiz
                datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        tarihTextView.setText( dayOfMonth + "/" + monthOfYear+ "/"+year);//Ayarla butonu t�kland���nda textview'a yazd�r�yoruz

                    }
                },year,month,day);//ba�larken set edilcek de�erlerimizi at�yoruz
                datePicker.setTitle("Tarih Se�iniz");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ayarla", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "�ptal", datePicker);

                datePicker.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
