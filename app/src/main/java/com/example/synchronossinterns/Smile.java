package com.example.synchronossinterns;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Rating;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

public class Smile extends AppCompatActivity {
    private static final String TAG = "Smile";
    int flag;
private String rating;
    private Button Next;
private TextView question;


    public Smile(){

    }
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        final String username = intent.getStringExtra("U");
        Next = (Button) findViewById(R.id.Next);
     final    TextView question=(TextView)findViewById(R.id.question);
if(flag==0){
        question.setText("How was the Internship program ?");
    question.setTextSize(25);
        emoji();
flag++;}

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getRating().equals(null)) {
                    Toast.makeText(getApplicationContext(), "Please select the emoji", Toast.LENGTH_SHORT).show();
                }
                // View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.smile, null, false);
                else {

                    Snackbar snackbar=Snackbar.make(v,"Next question loading",Snackbar.LENGTH_SHORT);
                    snackbar.show();
//                    Snackbar snackbar1=Snackbar.make(v,"Valid Credential",Snackbar.LENGTH_INDEFINITE).setAction("ACTION"
//                            ,null);
//                    snackbar1.show();
                    switch (flag) {
                        case 1:
                            emoji();
                            question.setText("What do you Rate the organization");
                            question.setTextSize(25);
                            flag++;
                            break;
                        case 2:
                            emoji();
                            question.setText("Was it helpful for your career ?");
                            question.setTextSize(25);
                            flag++;
                            break;
                        case 3:
                            emoji();
                            question.setText("How were your mentors ?");
                            question.setTextSize(25);
                            flag++;
                            break;
                    }
                    save();
                }
              //  Toast.makeText(getBaseContext(), getRating() + "saved", Toast.LENGTH_SHORT).show();
            }
                public void save(){
                    Toast.makeText(getApplicationContext(), getRating() + "saved", Toast.LENGTH_LONG).show();
                SQLiteDatabase sql = getBaseContext().openOrCreateDatabase("credential.db", MODE_PRIVATE, null);

//            sql.execSQL("Create table table5(username,ratings);");
                sql.execSQL("Insert into table5(username,ratings) Values('" + username + "','" + rating + "');");


                Cursor cursor1 = sql.rawQuery("Select ratings from table5 where username LIKE '" +username + "%';", null);
                if (cursor1.moveToFirst()) {

                    String R = cursor1.getString(0);
                  //  Toast.makeText(getApplicationContext(), R, Toast.LENGTH_LONG).show();
                    Log.d(TAG, "final: uuuuuuuuuuuuuuuuuu" + username + R);
                }
            }
        });
    }

public void emoji(){


        SmileRating smileRating=(SmileRating) findViewById(R.id.smile);

    smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
        String Rating = null;

        @Override
        public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
    setRating(null);
            Log.d(TAG, "onSmileySelected: vallllllllllll");
            switch (smiley) {

                case SmileRating.BAD:
                    Rating = "BAD";
                    Log.i(TAG, "Bad");



                    break;
                case SmileRating.GOOD:
                    Log.i(TAG, "Good");
                    Rating = "GOOD";
                    break;
                case SmileRating.GREAT:
                    Log.i(TAG, "Great");
                    Rating = "GREAT";
                    break;
                case SmileRating.OKAY:
                    Log.i(TAG, "Okay");
                    Rating = "OKAY";
                    break;
                case SmileRating.TERRIBLE:
                    Log.i(TAG, "Terrible");
                    Rating = "TERRIBLE";
                    break;
            }
            setRating(Rating);

smiley=-1;
            Log.d(TAG, "onSmileySelected: sssssssssssssss"+smiley);
        }

    });

    }


}

