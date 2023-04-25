package com.example.pdfreader;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.util.ArrayList;

public class pdfview_activity extends AppCompatActivity {
    PDFView pdfView;
    String filepath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview);

        pdfView = findViewById(R.id.pdfview_id);
        filepath = getIntent().getStringExtra("path");

        Uri uri = Uri.fromFile(new File(filepath));
        pdfView.fromUri(uri).load();

    }
}