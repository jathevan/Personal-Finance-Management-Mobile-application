package com.example.jaathu.logine3;

import android.app.Activity;
import android.widget.Toast;

import com.techblogon.loginexample.R;

/**
 * Created by Jaathu on 3/10/2016.
 */
public class CheckPassword {
    LoginDataBaseAdapter loginDataBaseAdapter;
    String storedPassword;

    public String chkPass(String userName,String password) {

        //LoginDataBaseAdapter loginDataBaseAdapter ;
        //final EditText editTextUserName=(EditText)findViewById(R.id.editTextUserNameToLogin);
        //final  EditText editTextPassword=(EditText)findViewById(R.id.editTextPasswordToLogin);
        // save(editTextUserName, editTextPassword);
        // get The User name and Password


        // fetch the Password form database for respective user name
        // try {
        storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);


        String status;

        // check if the Stored password matches with  Password entered by user
        if (password.equals(storedPassword)) {
           // Toast.makeText(CheckPassword.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();

            status = "Success";
        return status;

            //    Button btnUserProfile = (Button) findViewById(R.id.buttonUserProfile);

                /*   btnUserProfile.setOnClickListener(new View.OnClickListener() {
                       public void onClick(View v) {
                           // TODO Auto-generated method stub

                           /// Create Intent for SignUpActivity  abd Start The Activity
                           Intent intentUpdate=new Intent(getApplicationContext(),updateActivity.class);
                           startActivity(intentUpdate);
                       }
                   });*/    //go to user profile interface


        } else {
           // Toast.makeText(CheckPassword.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();


            status = "User Name or Password does not match";
            return status;


        }
                                           /*  }
                                             catch (Throwable e){
                                                 //e.printStackTrace();
                                                 //Toast.makeText(SignIn.this,"err", Toast.LENGTH_SHORT).show();
                                                 //Log.e("MYAPP", "exception", e);


                                      }*/

    }
}