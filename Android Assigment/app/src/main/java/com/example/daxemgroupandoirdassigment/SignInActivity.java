package com.example.daxemgroupandoirdassigment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.daxemgroupandoirdassigment.Class.Users;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {
    private LinearLayout layoutSignUp;

    private EditText Email, Password;
    private Button btnLogin;
    Switch active;

    private Users users;
    private FirebaseAuth auth;
    DatabaseReference database = FirebaseDatabase.getInstance("https://daxemgroupandroidassigment-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        iniUi();
        iniListener();

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        active = findViewById(R.id.active);

        users = new Users();
        auth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String txtEmail = Email.getText().toString();
                        String txtPassword = Password.getText().toString();
                        String[] keyId = txtEmail.split("@");

                        if(snapshot.child(String.valueOf(keyId[0])).exists()){
                                if (snapshot.child(String.valueOf(keyId[0])).child("password").getValue(String.class).equals(String.valueOf(txtPassword))) {
                                    if (active.isChecked()) {
                                        if (snapshot.child(String.valueOf(keyId[0])).child("roll").getValue(String.class).equals("admin")) {
                                            preferences.setDataLogin(SignInActivity.this, true);
                                            preferences.setDataAs(SignInActivity.this, "admin");
                                            startActivity(new Intent(SignInActivity.this, AdminActivity.class));
                                        } else if (snapshot.child(String.valueOf(keyId[0])).child("roll").getValue(String.class).equals("user")){
                                            preferences.setDataLogin(SignInActivity.this, true);
                                            preferences.setDataAs(SignInActivity.this, "user");
                                            startActivity(new Intent(SignInActivity.this, UsersActivity.class));
                                        }
                                    } else {
                                        if (snapshot.child(String.valueOf(keyId[0])).child("roll").getValue(String.class).equals("admin")) {
                                            preferences.setDataLogin(SignInActivity.this, false);
                                            startActivity(new Intent(SignInActivity.this, AdminActivity.class));

                                        } else if (snapshot.child(String.valueOf(keyId[0])).child("roll").getValue(String.class).equals("user")){
                                            preferences.setDataLogin(SignInActivity.this, false);
                                            startActivity(new Intent(SignInActivity.this, UsersActivity.class));
                                        }
                                    }

                                } else {
                                    Toast.makeText(SignInActivity.this, "Password Or Username False!! Please Try Again Late!! ", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(SignInActivity.this, "User not exist in system!! ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String txtEmail = Email.getText().toString();
//                String txtPassword = Password.getText().toString();
//
//
//                if(TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)){
//                    Toast.makeText(SignInActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
//
//                }else {
//                    login(txtEmail,txtPassword);
//                }
//            }
//        });
//    }

//    private void login(String txtEmail, String txtPassword) {
//        auth.signInWithEmailAndPassword(txtEmail,txtPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    Intent intent = new Intent(SignInActivity.this, UsersActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(intent);
//                    finish();
//                }else {
//                    Toast.makeText(SignInActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }

    protected void onStart() {
        super.onStart();
        if (preferences.getDataLogin(this)) {
            if (preferences.getDataAs(this).equals("admin")) {
                startActivity(new Intent(this, AdminActivity.class));
                finish();
            } else {
                startActivity(new Intent(this, UsersActivity.class));
                finish();
            }
        }
    }

    public void iniUi(){
        layoutSignUp = findViewById(R.id.layout_sign_up);
    }

    public void iniListener(){
        layoutSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }



}
