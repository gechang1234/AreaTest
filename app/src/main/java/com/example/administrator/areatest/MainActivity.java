package com.example.administrator.areatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private EditText mPolygon;
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.confirm);
        mPolygon = (EditText) findViewById(R.id.my_polygon);
        mResult = (TextView) findViewById(R.id.my_area);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit = mPolygon.getText().toString();
                if (edit.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.edit_coordinate,
                            Toast.LENGTH_SHORT).show();
                } else {
                    if (edit.contains("；")) {
                        String[] str = edit.split("；");
                        int length = str.length;
                        Float result = caculateArea
                                .caculate(caculateArea.parserCoor(edit), length);
                        Float lastResult = Math.abs(result);
                        mResult.setText(lastResult.toString());
                    } else {
                        Toast.makeText(MainActivity.this, R.string.check_the_format,
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
