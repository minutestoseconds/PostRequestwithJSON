package com.learntodroid.postrequestwithjson;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditMembersActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private EditText title, comment, author;
    private Button send;

    private EditMembersRepository EditMembersRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        title = findViewById(R.id.activity_comments_title);
        comment = findViewById(R.id.activity_comments_comment);
        author = findViewById(R.id.activity_comments_author);
        radioGroup = findViewById(R.id.activity_comments_post_type);
        send = findViewById(R.id.activity_comments_send);

        EditMembersRepository = EditMembersRepository.getInstance();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditMembers em = new EditMembers(
                        title.getText().toString(),
                        author.getText().toString(),
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
                        EditMembersRepository.getEditMembersService().createEditMembers(em).enqueue(new Callback<EditMembers>() {
                            @Override
                            public void onResponse(Call<EditMembers> call, Response<EditMembers> r) {
                                Toast.makeText(getApplicationContext(), "Edit Members " + r.body().getPhone()+ " submited", Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onFailure(Call<EditMembers> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Error Submitting Feedback: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        return;

/*       "phone": "+91 8335833389",
        "email": "xyz@melba.au.org",
        "fname": "Bhaskar + Gargi",
        "sname": "Das",
        "member_type": "Member",
        "address": "Melbourne",
        "opted_notification": "Yes",
        "subscr_type": "Yearly",
        "subscr_expiry": "10/2019",
        "subscr_events": ["Durgapuja", "laxmi-puja", "kali-puja", "Saraswati-puja"],
        "subscr_status": "member-dormant",
        "family_members_count": "05",
        "digital_coupons": ["astami_food_coupon11", "astami_food_coupon22", "astami_food_coupon33", "astami_food_coupon44"]*/




                    case R.id.activity_comments_post_type_form_encoded_fields:
                        EditMembersRepository.getEditMembersService().createEditMembers(em.getPhone(),em.getEmail(), em.getFname(),em.getSname(),
                                em.getMember_type(),em.getAddress(),em.getOpted_notification(),
                                em.getSubscr_type(),em.getSubscr_expiry(),em.getSubscr_events(),
                                em.getSubscr_status(),em.getFamily_members_count(),em.getDigital_coupons()).enqueue(new Callback<EditMembers>() {
                            @Override
                            public void onResponse(Call<EditMembers> call, Response<EditMembers> r) {
                                Toast.makeText(getApplicationContext(), "Edit Members " + r.body().getFname() + "Successful", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<EditMembers> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Error Creating Comment: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        return;
/*       "phone": "+91 8335833389",
        "email": "xyz@melba.au.org",
        "fname": "Bhaskar + Gargi",
        "sname": "Das",
        "member_type": "Member",
        "address": "Melbourne",
        "opted_notification": "Yes",
        "subscr_type": "Yearly",
        "subscr_expiry": "10/2019",
        "subscr_events": ["Durgapuja", "laxmi-puja", "kali-puja", "Saraswati-puja"],
        "subscr_status": "member-dormant",
        "family_members_count": "05",
        "digital_coupons": ["astami_food_coupon11", "astami_food_coupon22", "astami_food_coupon33", "astami_food_coupon44"]*/

                    case R.id.activity_comments_post_type_form_encoded_field_set:
                        HashMap<String, String> fields = new HashMap<>();
                        fields.put("phone", em.getPhone());
                        fields.put("email", em.getEmail());
                        fields.put("fname", em.getFname());
                        fields.put("sname", em.getSname());
                        fields.put("member_type", em.getMember_type());
                        fields.put("address", em.getAddress());
                        fields.put("opted_notification", em.getOpted_notification());
                        fields.put("subscr_type", em.getSubscr_type());
                        fields.put("subscr_expiry", em.getSubscr_expiry());
                        fields.put("subscr_events", em.getSubscr_events());
                        fields.put("subscr_status", em.getSubscr_status());
                        fields.put("family_members_count", em.getFamily_members_count());

                        fields.put("digital_coupons", em.getDigital_coupons());

                        EditMembersRepository.getEditMembersService().createEditMembers(fields).enqueue(new Callback<EditMembers>() {
                            @Override
                            public void onResponse(Call<EditMembers> call, Response<EditMembers> r) {
                                Toast.makeText(getApplicationContext(), "Edit members " + r.body().getFname() + " submitted", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<EditMembers> call, Throwable t) {
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
