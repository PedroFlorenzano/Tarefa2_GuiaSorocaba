package com.example.aula2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Chamar outra tela por botão
    public void BtnTelaZoo(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void BtnTelefone(View view){
        Uri uri = Uri.parse("tel: 02115988349888");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        int permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE);
        if(permissionCheck != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.CALL_PHONE},1);
        }else{
            startActivity(intent);
        }
    }

    public void BtnCompartilhar(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "TEXTO");
        intent.setType("text/plain");
        startActivity(intent);
    }

    public void BtnMApa(View view){
        Uri uri = Uri.parse("geo: 0,0?q=Rua+Angelina+Pelizari+Costa+336");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void BtnNavegacao(View view){
        Uri uri = Uri.parse("google.navigation:q=Rua+Angelina+Pelizari+Costa+336");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


}