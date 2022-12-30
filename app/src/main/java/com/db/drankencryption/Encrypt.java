package com.db.drankencryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Encrypt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);
    }

    public void encryptSentence(View v){
        TextInputEditText sentenceToEncrypt = (TextInputEditText) findViewById(R.id.sentenceToEncrypt);
        String sentence = sentenceToEncrypt.getText().toString();

        Logic enc = new Logic(sentence);
        String encryptedCode = enc.encrypt();

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        String label = "Encrypted data";
        ClipData clip = ClipData.newPlainText(label, encryptedCode);
        clipboard.setPrimaryClip(clip);

        Toast.makeText(this, "Encrypted text copied to clipboard", Toast.LENGTH_SHORT).show();

    }
}