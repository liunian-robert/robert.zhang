     package com.aqwx.bean;

     public class news
     {
       private String id;
       private String name;
       private String image;
       private String date;
       private String content;

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
       public String getContent() {
       return this.content;
       }
       public void setContent(String content) {
       this.content = content;
       }

       @Override
    public String toString() {
       return "news [id=" + this.id + ", name=" + this.name + ", image=" + this.image + ", date=" +
         this.date + ", content=" + this.content + "]";
       }
     }