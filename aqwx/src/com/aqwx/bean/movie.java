     package com.aqwx.bean;

     public class movie
     {
       private String id;
       private String name;
       private String movie;
       private String format;

       public String getFormat()
       {
        return this.format;
       }
       public void setFormat(String format) {
       this.format = format;
       }

       public String getId() {
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
       public String getMovie() {
       return this.movie;
       }
       public void setMovie(String movie) {
       this.movie = movie;
       }

       @Override
    public String toString() {
       return "movie [id=" + this.id + ", name=" + this.name + ", movie=" + this.movie +
         ", format=" + this.format + "]";
       }
     }