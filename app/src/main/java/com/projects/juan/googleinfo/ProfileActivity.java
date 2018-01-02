package com.projects.juan.googleinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    GoogleSignInAccount account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        account = GoogleSignIn.getLastSignedInAccount(this);

        setTitle(account.getDisplayName());

        TextView text_email = (TextView) findViewById(R.id.text_email);
        ImageView image_profile = (ImageView) findViewById(R.id.image_profile);

        text_email.setText(account.getEmail());

        String url = account.getPhotoUrl().toString().replace("96", "500");

        Picasso.with(this).load(url)
                .into(image_profile);
        findViewById(R.id.sign_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.signOut();
                returnMainActivity();
            }
        });
    }

    private void returnMainActivity(){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }

}
