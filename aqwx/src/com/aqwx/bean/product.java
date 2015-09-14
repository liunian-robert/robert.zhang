     package com.aqwx.bean;

     public class product
     {
       private String id;
       private String name;
       private String image;
       private String content;
       private String class_id;

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

       public String getClass_id() {
       return this.class_id;
       }
       public void setClass_id(String class_id) {
       this.class_id = class_id;
       }

       @Override
    public String toString() {
       return "product [id=" + this.id + ", name=" + this.name + ", image=" + this.image +
         ", content=" + this.content + ", class_id=" + this.class_id + "]";
       }
     }
