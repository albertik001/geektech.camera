package com.example.geektech01urok;

import static com.example.geektech01urok.MainActivity.PASSWORD;
import static com.example.geektech01urok.MainActivity.PHONENUMBER;
import static com.example.geektech01urok.MainActivity.USERNAME;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.geektech01urok.databinding.ActivitySecondBinding;


public class
SecondActivity extends AppCompatActivity {

    private static final int CAMERA_ACTION_CODE = 1;
    private ActivitySecondBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Prefs prefs =  new Prefs(SecondActivity.this);
        datasince(prefs);
        activityresultlauncher(prefs);

        if (!prefs.getImageUser().equals("")){
            Glide.with(binding.imageProfil).load(prefs.getImageUser()).circleCrop().into(binding.imageProfil);
        }
        if(!prefs.getUserName().equals("null")){
            binding.etUsername.setText(prefs.getUserName());
        }
        binding.btnBoolean.setOnClickListener(v->{
            prefs.saveMainCreate2();
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void activityresultlauncher(Prefs prefs) {
        ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    public void onActivityResult(Uri uri) {
                        Glide.with(binding.imageProfil).load(uri).circleCrop().into(binding.imageProfil);
                        prefs.setImageProfil(uri);
                    }
                });
        binding.etEditPhoto.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
            builder.setNeutralButton("Галерея", ((dialog, which) -> {
                mGetContent.launch("image/*");

            }));
            builder.setNegativeButton("Камера", ((dialog, which) -> {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, CAMERA_ACTION_CODE);
                } else {
                    Toast.makeText(SecondActivity.this, "Not support", Toast.LENGTH_SHORT).show();
                }
            }));
            @SuppressLint("InflateParams") LinearLayout linearLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.item_alert_dialog_2, null);
            builder.setView(linearLayout);
            AlertDialog dialog = builder.create();
            dialog.show();
        });

    }

    private void datasince(Prefs prefs) {
        String password = getIntent().getStringExtra(PASSWORD);
        String phoneNumber = getIntent().getStringExtra(PHONENUMBER);
        binding.etPassword.setText(password);
        binding.etPhoneNumber.setText(phoneNumber);
        prefs.saveMainCreate();
    }



    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_ACTION_CODE && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            Bitmap finalPhoto = (Bitmap) bundle.get("data");
            Glide.with(binding.imageProfil).load(finalPhoto).circleCrop().into(binding.imageProfil);
        }
    }

    /*   protected void glidesImagesSecond() {
        Glide.with(SecondActivity.this).load("https://seeklogo.com/images/A/AMG-logo-E67BBF3237-seeklogo.com.png")
                .into(binding.imageProfil);
    }*/




}