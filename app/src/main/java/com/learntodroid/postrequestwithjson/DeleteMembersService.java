package com.learntodroid.postrequestwithjson;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DeleteMembersService {


/*          "phone": "+91 8335833350",
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




    @POST("deleteMembers/:id")
    Call<DeleteMembers> createDeleteMembers(@Body DeleteMembers DeleteMembers);

    @FormUrlEncoded
    @POST("deleteMembers/:id")
    Call<DeleteMembers> createDeleteMembers(@Field("phone") String phone,
                                        @Field("fname") String fname,
                                        @Field("sname") String sname,
                                        @Field("address") String address,
                                        @Field("subscr_type") String subscr_type,
                                        @Field("subscr_expiry") String subscr_expiry,
                                        @Field("opted_notification") String opted_notification,
                                        @Field("subscription_status") String subscription_status,
                                        @Field("family_members_count") String family_members_count,
                                        @Field("digital_coupons") String digital_coupons,
                                        @Field("subscribed_events") String subscribed_events





    );

    @FormUrlEncoded
    @POST("deleteMembers/:id")
    Call<DeleteMembers> createDeleteMembers(@FieldMap Map<String, String> fields);




}

