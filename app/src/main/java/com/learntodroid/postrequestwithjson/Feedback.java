package com.learntodroid.postrequestwithjson;

import com.google.gson.annotations.SerializedName;

public class Feedback {

//    email_id           : req.body.email_id,
//    event_name         : req.body.event_name,  // list drop down
//    event_food         : req.body.event_food,
//    event_decoration   : req.body.event_decoration,
//    event_lightnsound  : req.body.event_lightnsound,
//    event_ceremony     : req.body.event_ceremony,
//    event_mgmt         : req.body.event_mgmt,
//    event_improvement  : req.body.event_improvement  // free edit text box


    @SerializedName("email_id")
    private String email_id;

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

    public Feedback(String email_id, String event_name, String event_food, String event_decoration ,
                    String event_lightnsound , String event_ceremony , String event_mgmt ,
                    String event_improvement ) {
        this.email_id = email_id;
        this.event_name = event_name;
        this.event_food = event_food;
        this.event_decoration = event_decoration;
        this.event_lightnsound = event_lightnsound;
        this.event_ceremony = event_ceremony;
        this.event_mgmt = event_mgmt;
        this.event_improvement = event_improvement;

    }

    public String getEmail_id() {
        return email_id;
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
