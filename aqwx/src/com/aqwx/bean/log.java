     package com.aqwx.bean;

     public class log
     {
       private String id;
       private String name;
       private String password;
       private String status;
       private String IP;
       private String date;

       public String getId()
       {
       return this.id;
       }
       public void setId(String id) {
       this.id = id;
       }
       public String getName() {
       return this.name;
       }
       public void setName(String name) {
       this.name = name;
       }
       public String getPassword() {
       return this.password;
       }
       public void setPassword(String password) {
       this.password = password;
       }
       public String getStatus() {
       return this.status;
       }
       public void setStatus(String status) {
       this.status = status;
       }
       public String getIP() {
       return this.IP;
       }
       public void setIP(String iP) {
       this.IP = iP;
       }
       public String getDate() {
       return this.date;
       }
       public void setDate(String date) {
       this.date = date;
       }

       @Override
    public String toString() {
       return "log [id=" + this.id + ", name=" + this.name + ", password=" + this.password +
         ", status=" + this.status + ", IP=" + this.IP + ", date=" + this.date + "]";
       }
     }