package com.example.geektech01urok;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import com.bumptech.glide.Glide;
import com.example.geektech01urok.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Boolean isNotEmptyPassword = true;
    private Boolean isNotEmptyUsername = false;
    private Boolean isNotEmptyPhoneNumber = false;

   /* ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    binding.imageCars.setImageURI(uri);
                }
            });*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //activityGalleryCamera();
        glidesImages();
        initListener();
    }

    protected void glidesImages() {
        Glide.with(this).load("https://seeklogo.com/images/A/AMG-logo-E67BBF3237-seeklogo.com.png").into(binding.imageCars);
    }

//    private void activityGalleryCamera() {
//        binding.btnBlackGO.setOnClickListener(v -> {
//            mGetContent.launch("image/*");
//
//        });
      /*  binding.btnBlackGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{binding.etGmailCom.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT, binding.etThemes.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, binding.etMessage.getText());
                startActivity(intent);
            }
        });
//    }*/

    private void initListener() {
        binding.etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() < 6) {
                    isNotEmptyPassword = false;
                } else {
                    isNotEmptyPassword = true;
                }
            }
        });
        binding.etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty()) {
                    isNotEmptyUsername = true;
                } else {
                    isNotEmptyUsername = false;
                }
            }
        });
        binding.etPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty()) {
                    isNotEmptyPhoneNumber = true;
                } else {
                    isNotEmptyPhoneNumber = false;
                }
            }
        });
        binding.btnBlackGO.setOnClickListener(view -> {
            if (isNotEmptyPassword) {
                if (isNotEmptyUsername) {
                    if (isNotEmptyPhoneNumber) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                    } else {
                        binding.etPhoneNumber.setError("");
                    }
                } else {
                    binding.etUsername.setError("");
                }
            } else {
                binding.etPassword.setError("");
            }
        });

    }
}