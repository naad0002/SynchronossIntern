package com.example.synchronossinterns;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

import static android.content.Context.MODE_PRIVATE;

public class One  {

    private static final String TAG = "One";
    private String Username;
    private String Password;
    private Boolean flag = true;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public One(String Usernamefinal, String Password) {
        this.Username = Usernamefinal;
        Log.d(TAG, "constrct: x1" + getUsername());
        this.Password = Password;
    }

    public One() {


    }
}