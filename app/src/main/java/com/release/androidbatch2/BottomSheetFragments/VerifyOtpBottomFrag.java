package com.release.androidbatch2.BottomSheetFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.release.androidbatch2.R;

public class VerifyOtpBottomFrag extends BottomSheetDialogFragment {

    Button verify;
    EditText otpText;

    OTPListner mListner;

    public interface OTPListner{
        void onReciveOTP(String otp);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.otp_verify, container, false);
        verify = view.findViewById(R.id.verify);
        otpText = view.findViewById(R.id.edit);


        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (otpText.getText().toString()==null || otpText.getText().toString().trim().equals("")){
                    Toast.makeText(getContext(), "Valid OTP Please!", Toast.LENGTH_SHORT).show();
                }else{
                    mListner.onReciveOTP(otpText.getText().toString());
                    dismiss();
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull  Context context) {
        super.onAttach(context);

        try {
            mListner= (OTPListner) context;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
