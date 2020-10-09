package com.learntodroid.postrequestwithjson;

import com.google.gson.annotations.SerializedName;

//Model class for signup

public class EditMembers {
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


    @SerializedName("phone")
    private String phone;

    @SerializedName("email")
    private String email;

    @SerializedName("fname")
    private String fname;

    @SerializedName("sname")
    private String sname;

    @SerializedName("member_type")
    private String member_type;

    @SerializedName("address")
    private String address;

    @SerializedName("opted_notification")
    private String opted_notification;

    @SerializedName("subscr_type")
    private String subscr_type;

    @SerializedName("subscr_expiry")
    private String subscr_expiry;

    @SerializedName("subscr_events")
    private String subscr_events;

    @SerializedName("subscr_status")
    private String subscr_status;

    @SerializedName("family_members_count")
    private String family_members_count;

    @SerializedName("digital_coupons")
    private String digital_coupons;


    public EditMembers(String phone, String email,String fname, String sname, String member_type ,
                  String address , String opted_notification,String subscr_type , String subscr_expiry ,String subscr_events ,
                   String subscr_status ,String family_members_count ,String digital_coupons ) {
        this.phone = phone;
        this.email=email;
        this.fname = fname;
        this.sname = sname;
        this.member_type = member_type;
        this.address = address;
        this.opted_notification = opted_notification;
        this.subscr_type = subscr_type;
        this.subscr_expiry = subscr_expiry;
        this.subscr_events = subscr_events;
        this.subscr_status = subscr_status;
        this.family_members_count = family_members_count;
        this.digital_coupons = digital_coupons;

    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public String getSname() {
        return sname;
    }

    public String getMember_type() {
        return member_type;
    }

    public String getAddress() {
        return address;
    }
    public String getOpted_notification() {
        return opted_notification ;
    }

    public String getSubscr_type() {
        return subscr_type;
    }
    public String getSubscr_expiry() {
        return subscr_expiry;
    }

    public String getSubscr_events() {
        return subscr_events ;
    }
    public String getSubscr_status() {
        return subscr_status ;
    }
    public String getFamily_members_count() {
        return family_members_count ;
    }

    public String getDigital_coupons() {
        return digital_coupons ;
    }


}
