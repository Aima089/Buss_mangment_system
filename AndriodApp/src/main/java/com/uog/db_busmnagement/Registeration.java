package com.uog.db_busmnagement;

public class Registeration {

    private int id;
    private String Title;
    private String Description;
    private String phone;
    private String from;
    private String to;
    private boolean Enable;




    public Registeration(int id,String title, String description, String phone, String from, String to,  boolean enable) {
        this.id=id;
        Title = title;
        Description = description;
        this.phone = phone;
        this.from=from;
        this.to=to;
        Enable = enable;
    }

    public Registeration(String item) {
        String[] infos = item.split(",");

        if(infos.length > 5)
        {
            Title = infos[0];
            Description = infos[1];
            phone=infos[2];
            from=infos[3];
            to=infos[4];
            if(infos[0]!=" ") {
                Enable = true;
            }
        }
    }

//    public Registeration(String item) {
//
//        String[] infos = item.split(",");
//
//        if(infos.length > 2)
//        {
//            Title = infos[0];
//            Description = infos[1];
//            if(infos[0]!=" ") {
//                Enable = true;
//            }
//        }
//
//
//    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public boolean isEnable() {
        return Enable;
    }

    public void setEnable(boolean enable) {
        Enable = enable;
    }
    @Override
    public String toString() {
        return Title + "," + Description + "," +phone +","+ from + "," +to+","+ Enable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

