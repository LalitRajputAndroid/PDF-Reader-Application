package com.example.pdfreader.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pdfreader.R;
import com.github.barteksc.pdfviewer.PDFView;

public class View_holder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView pdfname, pdfdate;
    CardView cardView;

    public View_holder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img_id);
        pdfname = itemView.findViewById(R.id.pdfname_id);
        pdfdate = itemView.findViewById(R.id.pdfdate_id);
        cardView = itemView.findViewById(R.id.single_carduid);
    }
}
