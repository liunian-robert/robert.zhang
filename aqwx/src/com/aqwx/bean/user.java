     package com.aqwx.bean;

     public class user
     {
       private String id;
       private String name;
       private String password;

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

       @Override
    public String toString() {
       return "user [id=" + this.id + ", name=" + this.name + ", password=" + this.password +
         "]";
       }
     }