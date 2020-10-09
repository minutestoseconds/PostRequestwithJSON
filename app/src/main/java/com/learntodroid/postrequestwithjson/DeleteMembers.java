package com.learntodroid.postrequestwithjson;

import com.google.gson.annotations.SerializedName;

public class DeleteMembers {


/*       "phone": "+91 8335833350",
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


    @SerializedName("phone")
    private String phone;


    @SerializedName("fname")
    private String fname;

    @SerializedName("sname")
    private String sname;


    @SerializedName("address")
    private String address;

    @SerializedName("subscr_type")
    private String subscr_type;

    @SerializedName("subscr_expiry")
    private String subscr_expiry;

    @SerializedName("opted_notification")
    private String opted_notification;

    @SerializedName("subscription_status")
    private String subscription_status;

    @SerializedName("family_members_count")
    private String family_members_count;

    @SerializedName("digital_coupons")
    private String digital_coupons;

    @SerializedName("subscribed_events")
    private String subscribed_events;






/*       "phone": "+91 8335833350",
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



    public DeleteMembers(String phone,String fname, String sname, String address , String subscr_type , String subscr_expiry ,
                         String opted_notification,String subscription_status ,String family_members_count ,String digital_coupons,
                         String subscribed_events) {
        this.phone = phone;
        this.fname = fname;
        this.sname = sname;
        this.address = address;
        this.subscr_type = subscr_type;
        this.subscr_expiry = subscr_expiry;
        this.opted_notification = opted_notification;
        this.subscription_status = subscription_status;
        this.family_members_count = family_members_count;
        this.digital_coupons = digital_coupons;
        this.subscribed_events = subscribed_events;



    }

    public String getPhone() {
        return phone;
    }


    public String getFname() {
        return fname;
    }

    public String getSname() {
        return sname;
    }


    public String getAddress() {
        return address;
    }

    public String getSubscr_type() {
        return subscr_type;
    }
    public String getSubscr_expiry() {
        return subscr_expiry;
    }
    public String getOpted_notification() {
        return opted_notification ;
    }
    public String getSubscription_status() {
        return subscription_status ;
    }
    public String getFamily_members_count() {
        return family_members_count ;
    }

    public String getDigital_coupons() {
        return digital_coupons ;
    }
    public String getSubscribed_events() {
        return subscribed_events ;
    }




}
