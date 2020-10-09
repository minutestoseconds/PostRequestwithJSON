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

public class DeleteMembersActivity extends AppCompatActivity {


    private RadioGroup radioGroup;
    private EditText title, comment, author;
    private Button send;

    private DeleteMembersRepository DeleteMembersRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        title = findViewById(R.id.activity_comments_title);
        comment = findViewById(R.id.activity_comments_comment);
        author = findViewById(R.id.activity_comments_author);
        radioGroup = findViewById(R.id.activity_comments_post_type);
        send = findViewById(R.id.activity_comments_send);

        DeleteMembersRepository= DeleteMembersRepository.getInstance();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteMembers dm = new DeleteMembers(
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
                        author.getText().toString()

                );

                switch(radioGroup.getCheckedRadioButtonId()) {
                    case -1:
                        return;

                    case R.id.activity_comments_post_type_json_body:
                        DeleteMembersRepository.getDeleteMembersService().createDeleteMembers(dm).enqueue(new Callback<DeleteMembers>() {
                            @Override
                            public void onResponse(Call<DeleteMembers> call, Response<DeleteMembers> r) {
                                Toast.makeText(getApplicationContext(), "Delete Members " + r.body().getPhone()+ " submited", Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onFailure(Call<DeleteMembers> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Error Submitting Feedback: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        return;

/*         "phone": "+91 8335833350",
"fname": "Prithwish",
"sname": "Das",
"address": "Hyderabad",
"subscr_type": "Yearly",
"subscr_expiry": "10/2021",
"opted_notification": "Yes",
"subscription_status": "active",
"family_members_count": "05",
"digital_coupons": ["astami_food_coupon1", "astami_food_coupon2", "astami_food_coupon3", "astami_food_coupon4"],
"subscribed_events": "Yearly"
*/

                    case R.id.activity_comments_post_type_form_encoded_fields:
                        DeleteMembersRepository.getDeleteMembersService().createDeleteMembers(dm.getPhone(), dm.getFname(),dm.getSname(),
                                dm.getAddress(),dm.getSubscr_type(),dm.getSubscr_expiry(),dm.getOpted_notification(),
                                dm.getSubscription_status(),dm.getFamily_members_count(),dm.getDigital_coupons(),dm.getSubscribed_events()).enqueue(new Callback<DeleteMembers>() {
                            @Override
                            public void onResponse(Call<DeleteMembers> call, Response<DeleteMembers> r) {
                                Toast.makeText(getApplicationContext(), "Delete Members " + r.body().getFname()+ "Successful", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<DeleteMembers> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Error Creating Comment: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        return;
/*         "phone": "+91 8335833350",
"fname": "Prithwish",
"sname": "Das",
"address": "Hyderabad",
"subscr_type": "Yearly",
"subscr_expiry": "10/2021",
"opted_notification": "Yes",
"subscription_status": "active",
"family_members_count": "05",
"digital_coupons": ["astami_food_coupon1", "astami_food_coupon2", "astami_food_coupon3", "astami_food_coupon4"],
"subscribed_events": "Yearly"
*/

                    case R.id.activity_comments_post_type_form_encoded_field_set:
                        HashMap<String, String> fields = new HashMap<>();
                        fields.put("phone", dm.getPhone());
                        fields.put("fname", dm.getFname());
                        fields.put("sname", dm.getSname());
                        fields.put("address", dm.getAddress());
                        fields.put("subscr_type", dm.getSubscr_type());
                        fields.put("subscr_expiry", dm.getSubscr_expiry());
                        fields.put("opted_notification", dm.getOpted_notification());



                        fields.put("subscr_status", dm.getSubscription_status());
                        fields.put("family_members_count", dm.getFamily_members_count());

                        fields.put("digital_coupons", dm.getDigital_coupons());
                        fields.put("subscr_events", dm.getSubscribed_events());

                        DeleteMembersRepository.getDeleteMembersService().createDeleteMembers(fields).enqueue(new Callback<DeleteMembers>() {
                            @Override
                            public void onResponse(Call<DeleteMembers> call, Response<DeleteMembers> r) {
                                Toast.makeText(getApplicationContext(), "Deleted Members" + r.body().getFname() + " submitted", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<DeleteMembers> call, Throwable t) {
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
