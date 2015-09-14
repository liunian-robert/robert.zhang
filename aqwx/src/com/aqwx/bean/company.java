      package com.aqwx.bean;

      public class company
      {
        private String id;
        private String name;
        private String logo;
        private String image;
        private String phone;
        private String phone1;
        private String qq1;
        private String phone2;
        private String qq2;
        private String site;
        private String adress;
        private String adress2;
        private String email;
        private String movie;
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
        public String getLogo() {
        return this.logo;
        }
        public void setLogo(String logo) {
        this.logo = logo;
        }
        public String getImage() {
        return this.image;
        }
        public void setImage(String image) {
        this.image = image;
        }
        public String getPhone1() {
        return this.phone1;
        }
        public void setPhone1(String phone1) {
        this.phone1 = phone1;
        }
        public String getQq1() {
        return this.qq1;
        }
        public void setQq1(String qq1) {
        this.qq1 = qq1;
        }
        public String getAdress() {
        return this.adress;
        }
        public void setAdress(String adress) {
        this.adress = adress;
        }
        public String getEmail() {
        return this.email;
        }
        public void setEmail(String email) {
        this.email = email;
        }
        public String getContent() {
        return this.content;
        }
        public void setContent(String content) {
        this.content = content;
        }
        public String getPhone2() {
        return this.phone2;
        }
        public void setPhone2(String phone2) {
        this.phone2 = phone2;
        }
        public String getQq2() {
        return this.qq2;
        }
        public void setQq2(String qq2) {
        this.qq2 = qq2;
        }
        public String getSite() {
        return this.site;
        }
        public void setSite(String site) {
        this.site = site;
        }

        public String getMovie() {
        return this.movie;
        }
        public void setMovie(String movie) {
        this.movie = movie;
        }

        public String getPhone() {
       return this.phone;
        }
        public void setPhone(String phone) {
       this.phone = phone;
        }
        public String getAdress2() {
       return this.adress2;
        }
        public void setAdress2(String adress2) {
       this.adress2 = adress2;
        }

        @Override
        public String toString() {
       return "company [id=" + this.id + ", name=" + this.name + ", logo=" + this.logo +
         ", image=" + this.image + ", phone=" + this.phone + ", phone1=" + this.phone1 +
         ", qq1=" + this.qq1 + ", phone2=" + this.phone2 + ", qq2=" + this.qq2 +
         ", site=" + this.site + ", adress=" + this.adress + ", adress2=" + this.adress2 +
         ", email=" + this.email + ", movie=" + this.movie + ", content=" + this.content +
         "]";
        }
      }