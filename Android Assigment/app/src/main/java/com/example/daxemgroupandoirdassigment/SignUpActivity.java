package com.example.daxemgroupandoirdassigment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daxemgroupandoirdassigment.Class.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUpActivity extends AppCompatActivity {
    private EditText password;
    private EditText conpassword;
    private EditText fullname;
    private EditText email;
    private EditText phone;
    private Button btnRegister;
    private String roll = "admin";
    private static final String USERS = "Users";
    private static final String TAG = "SignUpActivity";

    //Create object of DatabaseReferences class to access Firebase database Realtime
    //DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://daxemgroupandroidassigment-default-rtdb.asia-southeast1.firebasedatabase.app/");
    private FirebaseDatabase firebaseDatabase;
    DatabaseReference database = FirebaseDatabase.getInstance("https://daxemgroupandroidassigment-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference(USERS);
    private FirebaseAuth auth;
    private Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        password = findViewById(R.id.password);
        conpassword = findViewById(R.id.conpassword);
        fullname  = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        btnRegister = findViewById(R.id.btnRegister);

//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference(USERS);
        auth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get data from EditText int to Variable
                final String txtPassword = password.getText().toString();
                final String txtConPassword = conpassword.getText().toString();
                final String txtFullName = fullname.getText().toString();
                final String txtEmail = email.getText().toString();
                final String txtPhone = phone.getText().toString();

                //check null validate form
                if(txtEmail.isEmpty() || txtPassword.isEmpty() || txtConPassword.isEmpty() || txtFullName.isEmpty() || txtPhone.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Please Fill All Fields!!", Toast.LENGTH_SHORT).show();
                }else if(!txtPassword.equals(txtConPassword)){
                    Toast.makeText(SignUpActivity.this, "Password And Confirm Password are not match!!", Toast.LENGTH_SHORT).show();

                }
                    //Sending data to firebase
                    users = new Users(txtEmail,txtPassword,txtFullName,txtPhone,roll);
                    RegisterUser(txtEmail,txtPassword);
            }
        });
    }

    public void RegisterUser(String email, String password){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "Create User With Email: success!!");
                    FirebaseUser user = auth.getCurrentUser();
                    UpdateUI(user);
                } else {
                    Log.d(TAG, "Create User With Email: failure!!", task.getException());
                    // If sign in fails, display a message to the user.
                    Toast.makeText(SignUpActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void UpdateUI(FirebaseUser currentuser){
        String txtemail = email.getText().toString();
        String[] keyId = txtemail.split("@");
        database.child(keyId[0]).setValue(users);
        Intent loginIntent = new Intent(this,SignInActivity.class);
        startActivity(loginIntent);
    }
}