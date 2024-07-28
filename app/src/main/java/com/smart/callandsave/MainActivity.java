package com.smart.callandsave;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnh, btns;
    Button delbtn, savebtn, callbtn;
    EditText phonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        btn0 = findViewById(R.id.button0);
        btnh = findViewById(R.id.buttonstar);
        btns = findViewById(R.id.buttonhash);
        delbtn = findViewById(R.id.deletebtn);
        savebtn = findViewById(R.id.buttonsave);
        callbtn = findViewById(R.id.buttoncall);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnh.setOnClickListener(this);
        btns.setOnClickListener(this);
        delbtn.setOnClickListener(this);
        savebtn.setOnClickListener(this);
        callbtn.setOnClickListener(this);

        phonenumber = findViewById(R.id.phone_number_id);
        phonenumber.setText("");
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        if (v.equals(delbtn)){
            String phno = phonenumber.getText().toString();
            if (phno.length()>0){
                phonenumber.setText(phno.substring(0,phno.length()-1));
                phonenumber.setSelection(phno.length()-1);
            }
            else {
                phonenumber.setText("");
            }

        }
        else if (v.equals(savebtn)){
            String phno = phonenumber.getText().toString();
            Intent i = new Intent(ContactsContract.Intents.Insert.ACTION);
            i.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            i.putExtra(ContactsContract.Intents.Insert.NAME,"Unknown");
            i.putExtra(ContactsContract.Intents.Insert.PHONE,phno);
            startActivity(i);
        }
        else if (v.equals(callbtn)){
            String phno = phonenumber.getText().toString();
            Intent in = new Intent(Intent.ACTION_DIAL);
            in.setData(Uri.parse("tel:"+phno));
            startActivity(in);
        }
        else {
            phonenumber.append(btn.getText());
        }
    }
}