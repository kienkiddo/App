package com.example.app;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app.model.CongViec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnThem, btnXoa, btnSua;
    private EditText inputName, inputContent;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private ListView listView;

    private ArrayAdapter adapters;
    public static List<CongViec> listCV = new ArrayList<CongViec>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        inputName = findViewById(R.id.inputTenCV);
        inputContent = findViewById(R.id.inputNoiDungCV);
        radioGroup = findViewById(R.id.radioGroup);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);

        adapters = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listCV);
        listView.setAdapter(adapters);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = inputName.getText().toString();
                String content = inputContent.getText().toString();
                int selectId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectId);

                CongViec cv = new CongViec();
                cv.setName(name);
                cv.setContent(content);
                cv.setGender(radioButton.getText().toString());
                listCV.add(cv);
                adapters.notifyDataSetChanged();

                notifyScreen("Them thanh cong !!!");

            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.item);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CongViec cv = (CongViec) adapters.getItem(i);
                System.out.println(cv.getName());

            }
        });
    }


    private void notifyScreen(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }


    protected  void showCalandar(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        final Calendar newCalendar = Calendar.getInstance();
        final DatePickerDialog StartTime = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
               // editText.setText(dateFormat.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        StartTime.show();
    }


}
