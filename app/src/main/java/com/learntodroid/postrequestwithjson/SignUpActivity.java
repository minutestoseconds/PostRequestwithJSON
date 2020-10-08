package com.learntodroid.postrequestwithjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private EditText title, comment, author;
    private Button send;

    private SignUpRepository SignUpRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        title = findViewById(R.id.activity_comments_title);
        comment = findViewById(R.id.activity_comments_comment);
        author = findViewById(R.id.activity_comments_author);
        radioGroup = findViewById(R.id.activity_comments_post_type);
        send = findViewById(R.id.activity_comments_send);

       SignUpRepository = SignUpRepository.getInstance();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp su = new SignUp(
                        title.getText().toString(),
                        comment.getText().toString(),
                        author.getText().toString(),
                        title.getText().toString(),
                        comment.getText().toString(),
                        author.getText().toString(),
                        title.getText().toString(),
                        comment.getText().toString(),
                        comment.getText().toString(),
                        author.getText().toString(),
                        title.getText().toString(),
                        comment.getText().toString()
                );

                switch(radioGroup.getCheckedRadioButtonId()) {
                    case -1:
                        return;

                    case R.id.activity_comments_post_type_json_body:
                        SignUpRepository.getSignUpService().createSignUp(su).enqueue(new Callback<SignUp>() {
                            @Override
                            public void onResponse(Call<SignUp> call, Response<SignUp> r) {
                                Toast.makeText(getApplicationContext(), "Event SignUp " + r.body().getFname() + " submited", Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onFailure(Call<SignUp> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Error Submitting Feedback: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        return;




                    case R.id.activity_comments_post_type_form_encoded_fields:
                        SignUpRepository.getSignUpService().createSignUp(su.getPhone(), su.getFname(),su.getSname(),
                                su.getMember_type(),su.getAddress(),
                                su.getSubscr_type(),su.getSubscr_expiry(),su.getOpted_notification(),
                                su.getSubscr_status(),su.getFamily_members_count(),su.getSubscr_events(),su.getDigital_coupons()).enqueue(new Callback<SignUp>() {
                            @Override
                            public void onResponse(Call<SignUp> call, Response<SignUp> r) {
                                Toast.makeText(getApplicationContext(), "SignUp " + r.body().getFname() + "Successful", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<SignUp> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Error Creating Comment: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        return;
//    phone                 : req.body.phone,
//    fname                 : req.body.fname,
//    sname                 : req.body.sname,
//    member_type           : req.body.member_type,
//    address               : req.body.address,
//    subscr_type           : req.body.subscr_type,
//    subscr_expiry         : req.body.subscr_expiry,
//    opted_notification    : req.body.opted_notification,
//    subscr_status         : req.body.subscr_status,
//    family_members_count  : req.body.family_members_count,
//    subscr_events         : req.body.subscr_events,
//    digital_coupons       : req.body.digital_coupons
                    case R.id.activity_comments_post_type_form_encoded_field_set:
                        HashMap<String, String> fields = new HashMap<>();
                        fields.put("phone", su.getPhone());
                        fields.put("fname", su.getFname());
                        fields.put("sname", su.getSname());
                        fields.put("member_type", su.getMember_type());
                        fields.put("address", su.getAddress());
                        fields.put("subscr_type", su.getSubscr_type());
                        fields.put("subscr_expiry", su.getSubscr_expiry());
                        fields.put("opted_notification", su.getOpted_notification());
                        fields.put("subscr_status", su.getSubscr_status());
                        fields.put("family_members_count", su.getFamily_members_count());
                        fields.put("subscr_events", su.getSubscr_events());
                        fields.put("digital_coupons", su.getDigital_coupons());

                        SignUpRepository.getSignUpService().createSignUp(fields).enqueue(new Callback<SignUp>() {
                            @Override
                            public void onResponse(Call<SignUp> call, Response<SignUp> r) {
                                Toast.makeText(getApplicationContext(), "SignUp " + r.body().getFname() + " submitted", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<SignUp> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Error submitting Feedback: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        return;

                    default:
                        throw new IllegalStateException("Unexpected value: " + radioGroup.getCheckedRadioButtonId());
                }
            }
        });
    }
}
