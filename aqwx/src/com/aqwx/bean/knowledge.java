     package com.aqwx.bean;

     public class knowledge
     {
       private String id;
       private String name;
       private String date;
       private String content;
       private int count;

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
       public int getCount() {
       return this.count;
       }
       public void setCount(int count) {
       this.count = count;
       }

       @Override
    public String toString() {
       return "knowledge [id=" + this.id + ", name=" + this.name + ", date=" + this.date +
         ", content=" + this.content + ", count=" + this.count + "]";
       }
     }

