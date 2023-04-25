package com.example.pdfreader.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pdfreader.Adapter.FIle_Adapter;
import com.example.pdfreader.MainActivity;
import com.example.pdfreader.OnpdffileSelectListener;
import com.example.pdfreader.Pdfitem;
import com.example.pdfreader.R;
import com.example.pdfreader.pdfview_activity;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class file_fragment extends Fragment implements OnpdffileSelectListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView;
    Context context;

    ArrayList<Pdfitem> pdfitems = new ArrayList<>();

    public file_fragment() {
    }

    public static file_fragment newInstance(String param1, String param2) {
        file_fragment fragment = new file_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_file, container, false);

        recyclerView = view.findViewById(R.id.recyclerview_id);
        runtimePermisssion();

        File docdir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File downloaddir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        getpdffile(downloaddir);
        getpdffile(docdir);


        return view;
    }

    private void runtimePermisssion() {
        Dexter.withContext(getContext()).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                        display();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();
    }

    private void getpdffile(File pdfdir) {

//        Pdfitem pdf_item = new Pdfitem();
        ArrayList<File> list = new ArrayList<>();
        String file_ext = ".pdf";

        try {

            File listpdffile[] = pdfdir.listFiles();

            if (listpdffile != null) {
                for (int i = 0; i < listpdffile.length; i++) {
                    File pdf_file = listpdffile[i];

                    if (pdf_file.getName().endsWith(file_ext)) {

                        Pdfitem itemlist = new Pdfitem();

                        itemlist.setFile_name(pdf_file.getName());
                        itemlist.setFile_path(pdf_file.getAbsolutePath());
                        itemlist.setFile_date(new Date(pdf_file.lastModified()));
                        pdfitems.add(itemlist);

//                        list.add(new File(pdf_file.getName()));
//                        list.add(new File(pdf_file.getAbsolutePath()));

                    }
                }
            }

        } catch (Exception e) {
            Toast.makeText(context, "Error" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void display() {

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
//        pdfList = new ArrayList<>();
//        pdfList.addAll(fileArrayList(Environment.getExternalStorageDirectory()));

        FIle_Adapter fIle_adapter = new FIle_Adapter(pdfitems, context,this);
        recyclerView.setAdapter(fIle_adapter);
    }

    @Override
    public void onpdfSelected(Pdfitem file) {
        Intent intent = new Intent(getActivity(), pdfview_activity.class);
        intent.putExtra("path",file.getFile_path());
        startActivity(intent);
    }
}


