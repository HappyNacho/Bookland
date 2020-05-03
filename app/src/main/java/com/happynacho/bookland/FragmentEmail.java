package com.happynacho.bookland;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FragmentEmail extends Fragment {

    EditText email_destination, email_subject, email_message;
    Button button_send;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_email, container, false);
    }



    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        //setContentView(R.layout.frag_email);

        email_destination = (EditText)view.findViewById(R.id.txtTo);
        email_subject = (EditText)view.findViewById(R.id.txtSub);
        email_message = (EditText)view.findViewById(R.id.txtMsg);

        button_send = (Button)view.findViewById(R.id.btnSend);

        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{email_destination.getText().toString()});
                it.putExtra(Intent.EXTRA_SUBJECT,email_subject.getText().toString());
                it.putExtra(Intent.EXTRA_TEXT,email_message.getText());
                it.setType("message/rfc822");
                startActivity(Intent.createChooser(it,"Choose Mail App"));
            }
        });
    }
}
