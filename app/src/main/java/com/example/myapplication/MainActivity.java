package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    public static final String MYPREFS = "myprefs";
    public static final String NAMEKEY = "namekey";
    public static final String PWDKEY = "pwdkey";
    EditText nameEditText, pwdEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");
        nameEditText = findViewById(R.id.editTextName);
        pwdEditText = findViewById(R.id.editTextPassword);
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onpause");
        //saveData();
    }*/

    /**
     * this method will save data from edittexts into a sharedprefs
     */
   /* private void saveData() {
        Log.i(TAG,"saveData");

        //get the data from the edittext
        String name = nameEditText.getText().toString();
        String pwd = pwdEditText.getText().toString();
        //create a file names myprefs
        SharedPreferences preferences = getSharedPreferences(MYPREFS,MODE_PRIVATE);
        //open the file
        SharedPreferences.Editor editor = preferences.edit();
        //write to the file
        editor.putString(NAMEKEY,name);
        editor.putString(PWDKEY,pwd);
        //save the file
        editor.apply();
    }
*/
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onresume");
        restoreData();
    }

    private void restoreData(){
        Log.i(TAG,"restoreData");

        //open the file
        SharedPreferences preferences = getSharedPreferences(MYPREFS,MODE_PRIVATE);
        //read the file
        String name = preferences.getString(NAMEKEY,"");
        String pwd = preferences.getString(PWDKEY,"");
        //set the data in edittexts
        nameEditText.setText(name);
        pwdEditText.setText(pwd);
    }



    public void clickHandler(View view) {
        Log.i(TAG,"saveData");

        //get the data from the edittext
        String name = nameEditText.getText().toString();
        String pwd = pwdEditText.getText().toString();
        //create a file names myprefs
        SharedPreferences preferences = getSharedPreferences(MYPREFS,MODE_PRIVATE);
        //open the file
        SharedPreferences.Editor editor = preferences.edit();
        //write to the file
        editor.putString(NAMEKEY,name);
        editor.putString(PWDKEY,pwd);
        //save the file
        editor.apply();
    }

    public boolean validateLogin(View view) {
        boolean valid = true;

        String name = nameEditText.getText().toString();
        String pwd = pwdEditText.getText().toString();

        if (name.isEmpty() || name.length()>20 ||name.length()<3 ) {
            nameEditText.setError("enter a valid email address");
            valid = false;
        } else {
            nameEditText.setError(null);
        }

        if (pwd.isEmpty() || pwd.length() < 4 || pwd.length() > 10) {
            pwdEditText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            pwdEditText.setError(null);
        }
        if(nameEditText.equals("admin")&&pwdEditText.equals("admin@123"))
        {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Login UnSuccessful", Toast.LENGTH_SHORT).show();
        }

        return valid;
    }
}