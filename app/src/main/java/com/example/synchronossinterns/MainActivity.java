package com.example.synchronossinterns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Cred";
   private Boolean flag = false;
    private EditText Username;
    private EditText Password;
    private Button Login;
    private Button Next;
    //private String Usernamefinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Login = (Button) findViewById(R.id.login);
Compare();
    }
    public void Compare(){
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Inside Compareeeeeeeeeeeeeeee: ");
                String Usernamefinal = Username.getText().toString();
                String Passwordfinal = Password.getText().toString();
                One o = new One(Usernamefinal, Passwordfinal);
                String U;

                SQLiteDatabase sql = getBaseContext().openOrCreateDatabase("credential.db", MODE_PRIVATE, null);
                
//               sql.execSQL("Create table credential4(username,password);");
                sql.execSQL("Insert into credential4(username,password) Values('nithin','nithin');");
                sql.execSQL("Insert into credential4(username,password) Values('jeevan','jeevan');");
                Cursor cursor = sql.rawQuery("Select * from credential4 where username LIKE '" + Usernamefinal + "%';", null);
                if (cursor.moveToFirst()) {
                    // Log.d(TAG, "onClick: aaaaaa" + Username.getText().toString());
                     U = cursor.getString(0);
                    String P = cursor.getString(1);

                  if (Usernamefinal.equals(U) && (Passwordfinal.equals(P))) {
                        Log.d(TAG, "Compare: ppppppppppppppppppppppppppppppp" + U);
                      Snackbar snackbar=Snackbar.make(v,"Valid Credential",Snackbar.LENGTH_SHORT);
                      snackbar.show();
                      Snackbar snackbar1=Snackbar.make(v,"Valid Credential",Snackbar.LENGTH_INDEFINITE).setAction("ACTION"
                              ,null);
                      snackbar1.show();
                        Intent i = new Intent(MainActivity.this, Smile.class);
                        i.putExtra("U", Usernamefinal);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "INVALID CREDENTIAL", Toast.LENGTH_SHORT).show();
                        flag = false;
                    }
                }
                cursor.close();


            }


        });


    }

}