//Vitaly Belkin 17385402
//159.336 Assignment 1, 2019 S2

package com.mobileapps.a336_assignment_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//******Setting UP Variables********
    TextView number;
    String phonenumber = "";

    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button hashtag;
    Button zero;
    Button star;
    Button backspace;
    Button callPhone;

//********dialup function*********
    private void dialup() {

        one =  findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven =findViewById(R.id.button7);
        eight =findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        hashtag =findViewById(R.id.buttonHash);
        zero = findViewById(R.id.button0);
        star = findViewById(R.id.buttonStar);
        backspace = findViewById(R.id.buttonBacksp);
        callPhone = findViewById(R.id.buttonCall);

        number = findViewById(R.id.TextView);

        number.setText(phonenumber);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = phonenumber + "1";
                number.setText(phonenumber);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = phonenumber + "2";
                number.setText(phonenumber);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = phonenumber + "3";
                number.setText(phonenumber);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = phonenumber + "4";
                number.setText(phonenumber);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = phonenumber + "5";
                number.setText(phonenumber);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = phonenumber + "6";
                number.setText(phonenumber);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = phonenumber + "7";
                number.setText(phonenumber);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = phonenumber + "8";
                number.setText(phonenumber);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = phonenumber + "9";
                number.setText(phonenumber);
            }
        });
        hashtag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = phonenumber + "#";
                number.setText(phonenumber);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = phonenumber + "0";
                number.setText(phonenumber);
            }
        });
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = phonenumber + "*";
                number.setText(phonenumber);
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phonenumber = "";
                number.setText(phonenumber);
            }
        });
        callPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phonenumber));
                startActivity(intent);
            }
        });

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       super.onRequestPermissionsResult(requestCode,permissions,grantResults);
       if (requestCode ==1 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            dialup();
       } else { finish();
       }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {  //initialising activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //***granting permission else calling the dialup() function***
        if(Build.VERSION.SDK_INT>=23 && checkSelfPermission(Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED ) {
            requestPermissions(new String []{Manifest.permission.CALL_PHONE},1);
        } else {

            dialup();

        }

    }

}
