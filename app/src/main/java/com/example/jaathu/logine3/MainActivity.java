package com.example.jaathu.logine3;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.techblogon.loginexample.R;

public class MainActivity extends Activity
{
    Button btnSignIn,btnSignUp;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        // Get The Refference Of Buttons
        btnSignIn=(Button)findViewById(R.id.buttonSignIN);
        btnSignUp=(Button)findViewById(R.id.buttonSignUP);

        // Set OnClick Listener on SignUp button
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                Intent intentSignUP=new Intent(getApplicationContext(),SignUPActivity.class);
                startActivity(intentSignUP);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentSignIn=new Intent(getApplicationContext(),SignIn.class);
                startActivity(intentSignIn);
            }
        });



    }
    // Methos to handleClick Event of Sign In Button
    public void signIn()
    {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.login);
        dialog.setTitle("Login");

        // get the Refferences of views
        final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
        final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);

        Button btnForgotPassword = (Button)findViewById(R.id.buttonForgotPassword);






           // Set On ClickListener
           btnSignIn.setOnClickListener(new View.OnClickListener()
            {

               public void onClick (View v){
               // get The User name and Password
               String userName = editTextUserName.getText().toString();
               String password = editTextPassword.getText().toString();

               // fetch the Password form database for respective user name
               String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

               // check if the Stored password matches with  Password entered by user
               if (password.equals(storedPassword)) {
                   Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                   setContentView(R.layout.welcome);

                   Button btnUserProfile=(Button)dialog.findViewById(R.id.buttonUserProfile);

                /*   btnUserProfile.setOnClickListener(new View.OnClickListener() {
                       public void onClick(View v) {
                           // TODO Auto-generated method stub

                           /// Create Intent for SignUpActivity  abd Start The Activity
                           Intent intentUpdate=new Intent(getApplicationContext(),updateActivity.class);
                           startActivity(intentUpdate);
                       }
                   });*/    //go to user profile interface

                   dialog.dismiss();
               } else {
                   Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
               }
           }
           }

           );

      btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ForgotPasswordlogin.class);
                startActivity(i);
            }
        });///////////////////****** Forget password


        dialog.show();
       }

        @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }
}