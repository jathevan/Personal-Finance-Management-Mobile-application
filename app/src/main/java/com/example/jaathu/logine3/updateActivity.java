package com.example.jaathu.logine3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;



import com.techblogon.loginexample.R;

/**
 * Created by Jaathu on 2/5/2016.
 */
public class updateActivity extends Activity {
    EditText editTextName,editTextPhone,editTextPassword,editTextConfirmPassword,editTextCurrency;
    Button updatebtn;

    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        // get Instance  of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        // Get Refferences of Views
        editTextName=(EditText)findViewById(R.id.editTextName);
        editTextPhone=(EditText)findViewById(R.id.editTextPhone);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);
        editTextCurrency=(EditText)findViewById(R.id.editTextCurrency);



        updatebtn=(Button)findViewById(R.id.buttonCreateAccount);
        updatebtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                String Name=editTextName.getText().toString();
                String password=editTextPassword.getText().toString();
                String confirmPassword=editTextConfirmPassword.getText().toString();
                String phone=editTextPhone.getText().toString();
                String currency=editTextCurrency.getText().toString();
              //*********  String check=checkBoxChange.getText();


                // check if any of the fields are vaccant
                if(Name.equals("")||phone.equals("")||currency.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please enter the details", Toast.LENGTH_LONG).show();
                    return;
                }


                if(((CheckBox) v).isChecked()) {

               //****     Toast.makeText(checkBoxChange.this, "Selected", Toast.LENGTH_SHORT).show();
                    editTextPassword.setFocusable(true);
                    //checkbox.setChecked(false);

                }


                // check if both password matches
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(Name, password);
                    Toast.makeText(getApplicationContext(), "Your account sucessfully updated ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}
