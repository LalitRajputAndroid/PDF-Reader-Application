package com.example.pdfreader.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pdfreader.OnpdffileSelectListener;
import com.example.pdfreader.Pdfitem;
import com.example.pdfreader.R;

import java.util.ArrayList;

public class FIle_Adapter extends RecyclerView.Adapter<View_holder> {

    ArrayList<Pdfitem> pdflist;
    Context context;

    OnpdffileSelectListener listener ;

    public FIle_Adapter(ArrayList<Pdfitem> pdflist, Context context,OnpdffileSelectListener listener) {
        this.pdflist = pdflist;
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public View_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.allfiles_single_row, parent, false);

        return new View_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View_holder holder, @SuppressLint("RecyclerView") int position) {

//        Pdfitem pdfitem = new Pdfitem();

        holder.pdfname.setText(pdflist.get(position).getFile_name());
        holder.pdfdate.setText(pdflist.get(position).getFile_date().toString());
        holder.pdfname.setSelected(true);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                pdflist.get(position).getFile_path();
                listener.onpdfSelected(pdflist.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return pdflist.size();
    }
}

