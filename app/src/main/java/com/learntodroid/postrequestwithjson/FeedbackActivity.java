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

public class FeedbackActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private EditText title, comment, author;
    private Button send;

    private FeedbackRepository feedbackRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        title = findViewById(R.id.activity_comments_title);
        comment = findViewById(R.id.activity_comments_comment);
        author = findViewById(R.id.activity_comments_author);
        radioGroup = findViewById(R.id.activity_comments_post_type);
        send = findViewById(R.id.activity_comments_send);

        feedbackRepository = feedbackRepository.getInstance();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Feedback fb = new Feedback(
                        title.getText().toString(),
                        comment.getText().toString(),
                        author.getText().toString(),
                        title.getText().toString(),
                        comment.getText().toString(),
                        author.getText().toString(),
                        title.getText().toString(),
                        comment.getText().toString()
                );

                switch(radioGroup.getCheckedRadioButtonId()) {
                    case -1:
                        return;

                    case R.id.activity_comments_post_type_json_body:
                        feedbackRepository.getFeedbackService().createFeedback(fb).enqueue(new Callback<Feedback>() {
                            @Override
                            public void onResponse(Call<Feedback> call, Response<Feedback> r) {
                                Toast.makeText(getApplicationContext(), "Event Feedback " + r.body().getEvent_name() + " submited", Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onFailure(Call<Feedback> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Error Submitting Feedback: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        return;


//    event_food         : req.body.event_food,
//    event_decoration   : req.body.event_decoration,
//    event_lightnsound  : req.body.event_lightnsound,
//    event_ceremony     : req.body.event_ceremony,
//    event_mgmt         : req.body.event_mgmt,
//    event_improvement  : req.body.event_improvement  // free edit text box
                    case R.id.activity_comments_post_type_form_encoded_fields:
                        feedbackRepository.getFeedbackService().createFeedback(fb.getEmail_id(), fb.getEvent_name(),fb.getEvent_food(),
                                fb.getEvent_decoration(),fb.getEvent_lightnsound(),
                                fb.getEvent_ceremony(),fb.getEvent_mgmt(),fb.getEvent_improvement()).enqueue(new Callback<Feedback>() {
                            @Override
                            public void onResponse(Call<Feedback> call, Response<Feedback> r) {
                                Toast.makeText(getApplicationContext(), "Event Feedback " + r.body().getEvent_name() + " submitted", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Feedback> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Error Creating Comment: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        return;

                    case R.id.activity_comments_post_type_form_encoded_field_set:
                        HashMap<String, String> fields = new HashMap<>();
                        fields.put("email_id", fb.getEmail_id());
                        fields.put("event_name", fb.getEvent_name());
                        fields.put("event_food", fb.getEvent_food());
                        fields.put("event_decoration", fb.getEvent_decoration());
                        fields.put("event_lightnsound", fb.getEvent_lightnsound());
                        fields.put("event_ceremony", fb.getEvent_ceremony());
                        fields.put("event_mgmt", fb.getEvent_mgmt());
                        fields.put("event_improvement", fb.getEvent_improvement());

                        feedbackRepository.getFeedbackService().createFeedback(fields).enqueue(new Callback<Feedback>() {
                            @Override
                            public void onResponse(Call<Feedback> call, Response<Feedback> r) {
                                Toast.makeText(getApplicationContext(), "Event Feedback " + r.body().getEvent_name() + " submitted", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<Feedback> call, Throwable t) {
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
