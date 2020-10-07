package com.learntodroid.postrequestwithjson;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FeedbackService {
    //    email_id           : req.body.email_id,
//    event_name         : req.body.event_name,  // list drop down
//    event_food         : req.body.event_food,
//    event_decoration   : req.body.event_decoration,
//    event_lightnsound  : req.body.event_lightnsound,
//    event_ceremony     : req.body.event_ceremony,
//    event_mgmt         : req.body.event_mgmt,
//    event_improvement  : req.body.event_improvement  // free edit text box

    @POST("saveFeedbackDetails")
    Call<Feedback> createFeedback(@Body Feedback feedback);

    @FormUrlEncoded
    @POST("saveFeedbackDetails")
    Call<Feedback> createFeedback(@Field("email_id") String email_id, @Field("event_name") String event_name, @Field("event_food") String event_food,
                                @Field("event_decoration") String event_decoration, @Field("event_lightnsound") String event_lightnsound,
                                @Field("event_ceremony") String event_ceremony,
                                @Field("event_mgmt") String event_mgmt,  @Field("event_improvement") String event_improvement);

    @FormUrlEncoded
    @POST("saveFeedbackDetails")
    Call<Feedback> createFeedback(@FieldMap Map<String, String> fields);




}
