package com.db.drankencryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Decrypt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
    }

    public void decryptCode(View v){
        TextInputEditText codeToDecrypt = (TextInputEditText) findViewById(R.id.codeToDecrypt);
        String code = codeToDecrypt.getText().toString();

        Logic dec = new Logic(code);
        String decryptedSentence = dec.decrypt();

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        String label = "Decrypted Sentence";
        ClipData clip = ClipData.newPlainText(label, decryptedSentence);
        clipboard.setPrimaryClip(clip);

        Toast.makeText(this, "Decrypted Text copied to clipboard", Toast.LENGTH_SHORT).show();

    }
}