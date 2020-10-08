package com.learntodroid.postrequestwithjson;

import com.google.gson.annotations.SerializedName;

//Model class for signup

public class SignUp {

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


    @SerializedName("phone")
    private String phone;

    @SerializedName("fname")
    private String fname;

    @SerializedName("sname")
    private String sname;

    @SerializedName("member_type")
    private String member_type;

    @SerializedName("address")
    private String address;

    @SerializedName("subscr_type")
    private String subscr_type;

    @SerializedName("subscr_expiry")
    private String subscr_expiry;

    @SerializedName("opted_notification")
    private String opted_notification;

    @SerializedName("subscr_status")
    private String subscr_status;

    @SerializedName("family_members_count")
    private String family_members_count;

    @SerializedName("subscr_events")
    private String subscr_events;

    @SerializedName("digital_coupons")
    private String digital_coupons;


    public SignUp(String phone, String fname, String sname, String member_type ,
                  String address , String subscr_type , String subscr_expiry ,
                  String opted_notification, String subscr_status ,String family_members_count ,String subscr_events ,String digital_coupons ) {
        this.phone = phone;
        this.fname = fname;
        this.sname = sname;
        this.member_type = member_type;
        this.address = address;
        this.subscr_type = subscr_type;
        this.subscr_expiry = subscr_expiry;
        this.opted_notification = opted_notification;
        this.subscr_status = subscr_status;
        this.family_members_count = family_members_count;
        this.subscr_events = subscr_events;
        this.digital_coupons = digital_coupons;

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

    public String getMember_type() {
        return member_type;
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

    public String getSubscr_status() {
        return subscr_status ;
    }
    public String getFamily_members_count() {
        return family_members_count ;
    }
    public String getSubscr_events() {
        return subscr_events ;
    }
    public String getDigital_coupons() {
        return digital_coupons ;
    }


}
