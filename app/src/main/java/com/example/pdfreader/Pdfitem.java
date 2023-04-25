package com.example.pdfreader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.File;
import java.net.URI;
import java.util.Date;

public class Pdfitem {
    String file_name;
    String file_path;
    Date file_date;

    public Pdfitem() {
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public Date getFile_date() {
        return file_date;
    }

    public void setFile_date(Date file_date) {
        this.file_date = file_date;
    }
}
