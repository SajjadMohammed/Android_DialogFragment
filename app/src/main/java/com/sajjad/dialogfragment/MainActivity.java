package com.sajjad.dialogfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Toolbar mainToolbar;
    public TextView userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainToolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);

        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);

    }

    public void showDialogFragment(View view) {
        LogInFragment logInFragment = new LogInFragment();

        Bundle bundle = new Bundle();
        bundle.putString("userName", userName.getText().toString());
        bundle.putString("password", password.getText().toString());

        logInFragment.setArguments(bundle);

        logInFragment.show(getSupportFragmentManager(), null);
    }
}