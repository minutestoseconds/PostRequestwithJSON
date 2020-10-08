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

    @SerializedName("event_name")
    private String event_name;

    @SerializedName("event_food")
    private String event_food;

    @SerializedName("event_decoration")
    private String event_decoration;

    @SerializedName("event_lightnsound")
    private String event_lightnsound;

    @SerializedName("event_ceremony")
    private String event_ceremony;

    @SerializedName("event_mgmt")
    private String event_mgmt;

    @SerializedName("event_improvement")
    private String event_improvement;

    public SignUp(String phone, String event_name, String event_food, String event_decoration ,
                  String event_lightnsound , String event_ceremony , String event_mgmt ,
                  String event_improvement ) {
        this.phone = phone;
        this.event_name = event_name;
        this.event_food = event_food;
        this.event_decoration = event_decoration;
        this.event_lightnsound = event_lightnsound;
        this.event_ceremony = event_ceremony;
        this.event_mgmt = event_mgmt;
        this.event_improvement = event_improvement;

    }

    public String getEmail_id() {
        return phone;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getEvent_food() {
        return event_food;
    }

    public String getEvent_decoration() {
        return event_decoration;
    }

    public String getEvent_lightnsound() {
        return event_lightnsound;
    }

    public String getEvent_ceremony() {
        return event_ceremony;
    }
    public String getEvent_mgmt() {
        return event_mgmt;
    }

    public String getEvent_improvement() {
        return event_improvement;
    }


}
