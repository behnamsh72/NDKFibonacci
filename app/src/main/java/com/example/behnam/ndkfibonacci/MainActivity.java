package com.example.behnam.ndkfibonacci;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText input;
    private RadioGroup type;
    private TextView output;
    private Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.input = findViewById(R.id.edtInput);
        type = findViewById(R.id.type_radio_goup);
        output = findViewById(R.id.output);
        mButton = findViewById(R.id.button);

        mButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String s = input.getText().toString();
        if (TextUtils.isEmpty(s))
            return;
        final ProgressDialog dialog=ProgressDialog.show(this,"","Calculating...",true);
        final long n = Long.parseLong(s);new AsyncTask<Void,Void,String>(){

            @Override
            protected String doInBackground(Void... voids) {
                long result = 0;
                long t = System.currentTimeMillis();
                switch (MainActivity.this.type.getCheckedRadioButtonId()) {
                    case R.id.type_fib_ji:
                        result = FibLib.fibJI(n);
                        break;

                    case R.id.type_fib_jr:
                        result = FibLib.fibJR(n);
                        break;
                    case R.id.type_fib_ni:
                        result = FibLib.fibNI(n);
                        break;
                    case R.id.type_fib_nr:
                        result = FibLib.fibNR(n);
                        break;

                }
                t = System.currentTimeMillis() - t;
                return String.format("fib(%d)=%d in  %d ms", n, result, t);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                dialog.dismiss();
                output.setText(s);
            }
        }.execute();

    }
}