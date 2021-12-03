package com.bkacad.menudemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

public abstract class TodoDialog extends Dialog {

    private EditText edtName;
    private Button btnSave, btnExit;
    private Context context;

    public TodoDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public void show() {
        super.show();
        edtName.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_dialog);

        edtName = findViewById(R.id.edtName);
        btnSave = findViewById(R.id.btnSave);
        btnExit = findViewById(R.id.btnExit);

        // Sự kiện khi click vào button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sau
                String name = edtName.getText().toString();
                if(name.isEmpty()) {
                    edtName.setError("Hãy nhập dữ liệu");
                    return;
                }
                passData(name);
                dismiss();
            }

        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Toast.makeText(context, "Thoát",Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected abstract void passData(String name);
}
