package com.example.geektech01urok;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
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
        //  glidesImagesSecond();
         activityGalleryCamera();
        binding.etEditPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, CAMERA_ACTION_CODE);
                } else {
                    Toast.makeText(SecondActivity.this, "Not support", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_ACTION_CODE && resultCode == RESULT_OK && data != null) {
            Bundle bundle = data.getExtras();
            Bitmap finalPhoto = (Bitmap) bundle.get("data");
            binding.imageProfil.setImageBitmap(finalPhoto);
        }
    }
    /*   protected void glidesImagesSecond() {
        Glide.with(SecondActivity.this).load("https://seeklogo.com/images/A/AMG-logo-E67BBF3237-seeklogo.com.png")
                .into(binding.imageProfil);
    }*/


 ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
         new ActivityResultCallback<Uri>() {
             @Override
             public void onActivityResult(Uri uri) {
                 binding.imageProfil.setImageURI(uri);
             }
         });


       private void activityGalleryCamera() {
           binding.etEditPhoto.setOnClickListener(v -> {
               mGetContent.launch("image/*");
           });

       }


}