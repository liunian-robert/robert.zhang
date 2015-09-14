     package com.aqwx.bean;

     public class team
     {
       private String id;
       private String name;
       private String image;
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
       public String getContent() {
       return this.content;
       }
       public void setContent(String content) {
       this.content = content;
       }

       @Override
    public String toString() {
       return "team[id=" + this.id + ", name=" + this.name + ", image=" + this.image +
         ", content=" + this.content + "]";
       }
     }

