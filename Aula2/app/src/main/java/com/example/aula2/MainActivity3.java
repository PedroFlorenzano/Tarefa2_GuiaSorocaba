package com.example.aula2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void btnFechar(View view){
        finish();
    }

    public void BtnMapaIgua(View view){
        Uri uri = Uri.parse("geo: 0,0?q=Avenida+Professora+Izoraida+Marques+Peres");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void BtnTelefoneIgua(View view){
        Uri uri = Uri.parse("tel: 1530421400");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        int permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE);
        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CALL_PHONE},1);
        }else{
            startActivity(intent);
        }
    }

    public void BtnNavegadorIgua(View view){
        Uri webpage = Uri.parse("https://iguatemi.com.br/esplanada/");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

}