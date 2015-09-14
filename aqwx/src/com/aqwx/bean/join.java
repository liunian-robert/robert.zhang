    package com.aqwx.bean;

     public class join
     {
       private String id;
       private String image;
       private String content;

       public String getId()
       {
        return this.id;
       }
       public void setId(String id) {
       this.id = id;
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
       return "join [id=" + this.id + ", image=" + this.image + ", content=" + this.content + "]";
       }
     }

