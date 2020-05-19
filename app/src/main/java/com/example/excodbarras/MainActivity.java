package com.example.excodbarras;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewAnimator;

import org.w3c.dom.Text;
public class MainActivity extends AppCompatActivity {
Button btLeitura;
TextView txCodigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lerCodigo();
    }
    private void lerCodigo(){
        btLeitura = (Button)findViewById(R.id.btnLerCodBarras);
        txCodigo = (TextView)findViewById(R.id.txtCodigo);
        btLeitura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                startActivityForResult(intent,0);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 0){
            txCodigo.setText(intent.getStringExtra("SCAN_RESULT"));
        }
    }
}
