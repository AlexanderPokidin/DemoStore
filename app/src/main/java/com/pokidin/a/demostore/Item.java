package com.pokidin.a.demostore;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public class Result {

        @SerializedName("listing_id")
        @Expose
        private Integer listingId;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("category_id")
        @Expose
        private Integer categoryId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("currency_code")
        @Expose
        private String currencyCode;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("MainImage")
        @Expose
        private MainImage mainImage;

        public Integer getListingId() {
            return listingId;
        }

        public void setListingId(Integer listingId) {
            this.listingId = listingId;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public MainImage getMainImage() {
            return mainImage;
        }

        public void setMainImage(MainImage mainImage) {
            this.mainImage = mainImage;
        }
    }

    public class MainImage {

        @SerializedName("listing_image_id")
        @Expose
        private Integer listingImageId;
        @SerializedName("listing_id")
        @Expose
        private Integer listingId;
        @SerializedName("rank")
        @Expose
        private String url75x75;
        @SerializedName("url_170x135")
        @Expose
        private String url170x135;
        @SerializedName("url_570xN")
        @Expose
        private String url570xN;
        @SerializedName("url_fullxfull")
        @Expose
        private String urlFullxfull;

        public Integer getListingImageId() {
            return listingImageId;
        }

        public void setListingImageId(Integer listingImageId) {
            this.listingImageId = listingImageId;
        }

        public Integer getListingId() {
            return listingId;
        }

        public void setListingId(Integer listingId) {
            this.listingId = listingId;
        }

        public String getUrl75x75() {
            return url75x75;
        }

        public void setUrl75x75(String url75x75) {
            this.url75x75 = url75x75;
        }

        public String getUrl170x135() {
            return url170x135;
        }

        public void setUrl170x135(String url170x135) {
            this.url170x135 = url170x135;
        }

        public String getUrl570xN() {
            return url570xN;
        }

        public void setUrl570xN(String url570xN) {
            this.url570xN = url570xN;
        }

        public String getUrlFullxfull() {
            return urlFullxfull;
        }

        public void setUrlFullxfull(String urlFullxfull) {
            this.urlFullxfull = urlFullxfull;
        }
    }
}
