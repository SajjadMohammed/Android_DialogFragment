package com.sajjad.dialogfragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LogInFragment extends DialogFragment {

    private TextInputEditText userName,userPassword;
   private TextInputLayout passwordInputLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button logIn = view.findViewById(R.id.logIn);
        Button cancel = view.findViewById(R.id.Cancel);

         userName = view.findViewById(R.id.userName);
         userPassword = view.findViewById(R.id.userPassword);
         passwordInputLayout = view.findViewById(R.id.passwordInputLayout);

        Bundle bundle = getArguments();
        userName.setText(bundle.getString("userName"));
        userPassword.setText(bundle.getString("password"));

        userPassword.addTextChangedListener(passwordWatcher);
        logIn.setOnClickListener(logInListener);

    }

    private View.OnClickListener logInListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((MainActivity)getActivity()).userName.setText(userName.getText().toString());
            ((MainActivity)getActivity()).password.setText(userPassword.getText().toString());
            dismiss();
        }
    };

    private TextWatcher passwordWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length()>passwordInputLayout.getCounterMaxLength()){
                passwordInputLayout.setError("Password is too long");
            }else{
                passwordInputLayout.setError(null);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
