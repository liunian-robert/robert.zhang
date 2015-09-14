     package com.aqwx.bean;

     public class technology
     {
       private String id;
       private String name;
       private String image;
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
       public String getImage() {
       return this.image;
       }
       public void setImage(String image) {
       this.image = image;
       }

       public String getDate() {
       return this.date;
       }
       public void setDate(String date) {
       this.date = date;
       }

       @Override
    public String toString() {
       return "technology [id=" + this.id + ", name=" + this.name + ", image=" + this.image +
         ", date=" + this.date + "]";
       }
     }
