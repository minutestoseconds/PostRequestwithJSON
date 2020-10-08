package com.learntodroid.postrequestwithjson;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface SignUpService {


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


    @POST("signupUser")
    Call<SignUp> createSignUp(@Body SignUp Signup);

    @FormUrlEncoded
    @POST("signupUser")
    Call<SignUp> createSignUp(@Field("phone") String phone, @Field("fname") String fname, @Field("sname") String sname,
                                  @Field("member_type") String member_type, @Field("address") String address,
                                  @Field("subscr_type") String subscr_type,
                                  @Field("subscr_expiry") String subscr_expiry, @Field("opted_notification") String opted_notification,
                                @Field("subscr_status") String subscr_status, @Field("family_members_count") String family_members_count,@Field("subscr_events") String subscr_events,
                                @Field("digital_coupons") String digital_coupons


                                );

    @FormUrlEncoded
    @POST("signupUser")
    Call<SignUp> createSignUp(@FieldMap Map<String, String> fields);




}

