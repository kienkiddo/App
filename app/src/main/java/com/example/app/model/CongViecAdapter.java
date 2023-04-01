package com.example.app.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app.R;

import java.util.List;

public class CongViecAdapter extends ArrayAdapter<CongViec> {

    private Context context;

    private List<CongViec> listCV;

    public CongViecAdapter(@NonNull Context context, List<CongViec> mList) {
        super(context, R.layout.item);
        this.context = context;
        this.listCV = mList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, null, true);
        ImageView img = view.findViewById(R.id.idImg);

    }
}
