     package com.aqwx.bean;

     public class Page
     {
      public int pageNum = 1;
      public int numPerPage = 15;
       public int totalCount;
       public int totalPage;

       public int getPageNum()
       {
       return this.pageNum;
       }
       public void setPageNum(int pageNum) {
       this.pageNum = pageNum;
       }
       public int getNumPerPage() {
       return this.numPerPage;
       }
       public void setNumPerPage(int numPerPage) {
       this.numPerPage = numPerPage;
       }
       public int getTotalCount() {
       return this.totalCount;
       }
       public void setTotalCount(int totalCount) {
       this.totalCount = totalCount;
       }
       public int getTotalPage() {
       int m = getTotalCount();
       if (m / this.numPerPage <= 1.0D)
         {
         return 1;
         }
       return m / this.numPerPage + 1;
       }
     }