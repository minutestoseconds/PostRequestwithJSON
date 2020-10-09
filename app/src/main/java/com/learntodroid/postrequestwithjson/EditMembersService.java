package com.learntodroid.postrequestwithjson;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EditMembersService {

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




        @POST("editMembers/:id")
        Call<EditMembers> createEditMembers(@Body EditMembers EditMembers);

        @FormUrlEncoded
        @POST("editMembers/:id")
        Call<EditMembers> createEditMembers(@Field("phone") String phone,
                                            @Field("email") String email,
                                            @Field("fname") String fname,
                                            @Field("sname") String sname,
                                            @Field("member_type") String member_type,
                                            @Field("address") String address,
                                            @Field("opted_notification") String opted_notification,
                                            @Field("subscr_type") String subscr_type,
                                            @Field("subscr_expiry") String subscr_expiry,
                                            @Field("subscr_events") String subscr_events,
                                            @Field("subscr_status") String subscr_status,
                                            @Field("family_members_count") String family_members_count,
                                            @Field("digital_coupons") String digital_coupons


        );

        @FormUrlEncoded
        @POST("editMembers/:id")
        Call<EditMembers> createEditMembers(@FieldMap Map<String, String> fields);




    }

