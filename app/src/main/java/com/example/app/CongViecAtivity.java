package com.example.app;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app.model.CongViec;
import com.example.app.model.CongViecAdapter;

import java.util.ArrayList;
import java.util.List;

public class CongViecAtivity extends AppCompatActivity {

    private ListView listView;

    CongViecAdapter adapter;

    public static List<CongViec> listCV = new ArrayList<CongViec>();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void init(){

    }
}
