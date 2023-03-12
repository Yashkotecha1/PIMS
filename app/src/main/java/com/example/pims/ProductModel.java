package com.example.pims;

public class ProductModel
{

        private String category_name;
        private int imgid;

        public ProductModel(String category_name, int imgid) {
            this.category_name = category_name;
            this.imgid = imgid;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCourse_name(String course_name) {
            this.category_name = course_name;
        }

        public int getImgid() {
            return imgid;
        }

        public void setImgid(int imgid) {
            this.imgid = imgid;
        }


}
