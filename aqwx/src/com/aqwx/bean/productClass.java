     package com.aqwx.bean;

     public class productClass
     {
       private String id;
       private String name;

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

       @Override
    public String toString() {
       return "productClass [id=" + this.id + ", name=" + this.name + "]";
       }
     }

