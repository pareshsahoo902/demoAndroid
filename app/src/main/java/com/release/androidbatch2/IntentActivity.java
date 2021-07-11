package com.release.androidbatch2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.DialogOnDeniedPermissionListener;
import com.karumi.dexter.listener.single.PermissionListener;
import com.release.androidbatch2.BottomSheetFragments.ImagePickerSheet;
import com.release.androidbatch2.BottomSheetFragments.VerifyOtpBottomFrag;

import java.util.List;

public class IntentActivity extends AppCompatActivity implements VerifyOtpBottomFrag.OTPListner {

    ImageView image;
    Button clickImage, chooseImage, send;
    EditText editText;
    TextView otpText;
    private Uri imageUri;
    private Bitmap imageBitmap;
    private static int CHOOSE_FROM_GALLERY_CODE = 101;
    private static int CLICK_IMAGE_CODE = 102;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);


        Dexter.withContext(this)
                .withPermission(Manifest.permission.CAMERA
                )
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        DialogOnDeniedPermissionListener.Builder
                                .withContext(getApplicationContext())
                                .withTitle("Camera permission")
                                .withMessage("Camera permission is needed to take pictures of your cat")
                                .withButtonText(android.R.string.ok)
                                .build();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                })
                .check();


        image = findViewById(R.id.image);
        clickImage = findViewById(R.id.click);
        chooseImage = findViewById(R.id.choose);
        send = findViewById(R.id.send);
        editText = findViewById(R.id.edit);
        otpText = findViewById(R.id.otpText);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new AlertDialog.Builder(IntentActivity.this)
                        .setTitle(Html.fromHtml("<font color='#12B878'>Delete Image ?</font>"))
                        .setMessage("Are your sure you want to delete the message?")
                        .setIcon(R.drawable.ic_baseline_save_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(IntentActivity.this, "Image Deleted!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No",null)
                        .show();

//                String message = editText.getText().toString();
//                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
//                whatsappIntent.setType("text/plain");
//                whatsappIntent.setPackage("com.whatsapp");
//                whatsappIntent.putExtra(Intent.EXTRA_TEXT, message);
//
//                try {
//                    startActivity(whatsappIntent);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Log.d("paresh", e.toString());
//                }
            }
        });

        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImagePickerSheet frag = new ImagePickerSheet();
                frag.show(getSupportFragmentManager(), "Select Image");


//                Intent pickImageIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(pickImageIntent, CHOOSE_FROM_GALLERY_CODE);

            }
        });

        clickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent captureImageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(captureImageIntent, CLICK_IMAGE_CODE);
                VerifyOtpBottomFrag verifyOtpBottomFrag = new VerifyOtpBottomFrag();
                verifyOtpBottomFrag.show(getSupportFragmentManager(),"get OTP");

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == CHOOSE_FROM_GALLERY_CODE) {

                imageUri = data.getData();
                image.setImageURI(imageUri);
                return;
            }

            if (requestCode == CLICK_IMAGE_CODE) {

                imageBitmap = (Bitmap) data.getExtras().get("data");
                image.setImageBitmap(imageBitmap);
            }


        }


    }

    @Override
    public void onReciveOTP(String otp) {
        if (otp != null)

            otpText.setText("OTP:- " + otp);
    }
}