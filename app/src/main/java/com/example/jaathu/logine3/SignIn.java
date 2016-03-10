package com.example.jaathu.logine3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.techblogon.loginexample.R;

import java.io.IOException;

/**
 * Created by pri on 3/9/2016.
 */
public class SignIn extends Activity {

    LoginDataBaseAdapter loginDataBaseAdapter ;

   /* EditText editTextUserName=(EditText)findViewById(R.id.editTextUserNameToLogin);
    EditText editTextPassword=(EditText)findViewById(R.id.editTextPasswordToLogin);
*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

       final EditText editTextUserName=(EditText)findViewById(R.id.editTextUserNameToLogin);
       final EditText editTextPassword=(EditText)findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn=(Button)findViewById(R.id.buttonSignIn);

        Button btnForgotPassword = (Button)findViewById(R.id.buttonForgotPassword);



        btnSignIn.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {

                                             //LoginDataBaseAdapter loginDataBaseAdapter ;
                                             //final EditText editTextUserName=(EditText)findViewById(R.id.editTextUserNameToLogin);
                                             //final  EditText editTextPassword=(EditText)findViewById(R.id.editTextPasswordToLogin);
                                            // save(editTextUserName, editTextPassword);
                                             // get The User name and Password
                                          /*   String userName = editTextUserName.getText().toString();
                                             String password = editTextPassword.getText().toString();

                                             // fetch the Password form database for respective user name
                                            // try {
                                                 String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

                                                 // check if the Stored password matches with  Password entered by user
                                                 if (password.equals(storedPassword)) {
                                                     Toast.makeText(SignIn.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                                                     setContentView(R.layout.welcome);

                                                 //    Button btnUserProfile = (Button) findViewById(R.id.buttonUserProfile);

                /*   btnUserProfile.setOnClickListener(new View.OnClickListener() {
                       public void onClick(View v) {
                           // TODO Auto-generated method stub

                           /// Create Intent for SignUpActivity  abd Start The Activity
                           Intent intentUpdate=new Intent(getApplicationContext(),updateActivity.class);
                           startActivity(intentUpdate);
                       }
                   });*/    //go to user profile interface


                              //                   } else {
                                     //                Toast.makeText(SignIn.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                                     //            }
                                           /*  }
                                             catch (Throwable e){
                                                 //e.printStackTrace();
                                                 //Toast.makeText(SignIn.this,"err", Toast.LENGTH_SHORT).show();
                                                 //Log.e("MYAPP", "exception", e);


                                             }*/






                                          //   Intent intentchk=new Intent(getApplicationContext(),CheckPassword.class);
                                            // startActivity(intentchk);

                                             String userName = editTextUserName.getText().toString();
                                             String password = editTextPassword.getText().toString();

                                             CheckPassword cp = new CheckPassword();
                                            String result = cp.chkPass(userName, password);

                                             Toast.makeText(SignIn.this, result, Toast.LENGTH_LONG).show();





                                         }
                                     }

        );

       btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ForgotPasswordlogin.class);
                startActivity(i);
            }
        });///////////////////****** Forget password




    }

   /* private  void save(EditText un, EditText pw){

        LoginDataBaseAdapter loginDataBaseAdapter = null;
        // get The User name and Password
        String userName = un.getText().toString();
        String password = pw.getText().toString();

        // fetch the Password form database for respective user name
        String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

        // check if the Stored password matches with  Password entered by user
        if (password.equals(storedPassword)) {
            Toast.makeText(SignIn.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
            setContentView(R.layout.welcome);

            Button btnUserProfile = (Button)findViewById(R.id.buttonUserProfile);

                /*   btnUserProfile.setOnClickListener(new View.OnClickListener() {
                       public void onClick(View v) {
                           // TODO Auto-generated method stub

                           /// Create Intent for SignUpActivity  abd Start The Activity
                           Intent intentUpdate=new Intent(getApplicationContext(),updateActivity.class);
                           startActivity(intentUpdate);
                       }
                   });*/    //go to user profile interface


      /*  } else {
            Toast.makeText(SignIn.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
        }
    }*/

    }

