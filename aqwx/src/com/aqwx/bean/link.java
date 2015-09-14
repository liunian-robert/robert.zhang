     package com.aqwx.bean;

     public class link
     {
       private String id;
       private String name;
       private String link;

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
       public String getLink() {
       return this.link;
       }
       public void setLink(String link) {
       this.link = link;
       }

       @Override
    public String toString() {
       return "link [id=" + this.id + ", name=" + this.name + ", link=" + this.link + "]";
       }
     }
