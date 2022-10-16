package com.ewoo.cameranotemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ewoo.cameranotemanager.util.FirebaseManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText etCode, etPw;
    private Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCode = (EditText) findViewById(R.id.a_main_et_code);
        etPw = (EditText) findViewById(R.id.a_main_et_pw);

        btnChange = (Button) findViewById(R.id.a_main_btn_change);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputKey = etCode.getText().toString();
                String inputPw = etPw.getText().toString();

                if (inputKey.equals("")) {
                    Toast.makeText(MainActivity.this, "관리자 코드를 입력해 주십시오.", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseManager.adminKeyRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String key = snapshot.getValue(String.class);
                            if (inputKey.equals(key)) {
                                if (inputPw.equals("")) {
                                    Toast.makeText(MainActivity.this, "변경할 비밀번호를 입력해 주십시오.", Toast.LENGTH_SHORT).show();
                                } else {
                                    if (inputPw.length() != 6) {
                                        Toast.makeText(MainActivity.this, "6자리를 입력해 주십시오.", Toast.LENGTH_SHORT).show();
                                    } else {
                                        FirebaseManager.passwordRef.setValue(Integer.parseInt(inputPw));
                                        Toast.makeText(MainActivity.this, "비밀번호를 변경하였습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "관리자 코드가 맞지 않습니다.", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }
}