package com.example.ruangkelas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout);
    }

    public void PindahHome(View view) {
        Intent intent3 = new Intent(SignUpActivity.this, HomeActivity.class);
        startActivity(intent3);
    }
}