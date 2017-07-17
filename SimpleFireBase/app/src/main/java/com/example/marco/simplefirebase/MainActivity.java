package com.example.marco.simplefirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private String FIREBASE_URL = "https://proteco20171.firebaseio.com/";
    private String FIREBASE_CHILD = "test";
    @Bind(R.id.editText)
    EditText editText;
    Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Firebase.setAndroidContext(this);
        firebase = new Firebase(FIREBASE_URL).child(FIREBASE_CHILD);
    }
    @OnClick(R.id.button)
    public void writeToFirebase() {
        firebase.setValue(editText.getText().toString());
        editText.setText("");
    }
}
