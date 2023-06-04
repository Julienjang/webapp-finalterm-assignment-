    package com.common;

    public class SearchCondition {

        private String option;
        private String value;
        private String productName;
        private String salesStore;
        private String newProduct;

        @Override
        public String toString() {
            return "SearchCondition{" +
                    "option='" + option + '\'' +
                    ", value='" + value + '\'' +
                    ", productName='" + productName + '\'' +
                    ", salesStore='" + salesStore + '\'' +
                    ", newProduct='" + newProduct + '\'' +
                    '}';
        }

        public String getNewProduct() {
            return newProduct;
        }

        public void setNewProduct(String newProduct) {
            this.newProduct = newProduct;
        }

        public SearchCondition(String newProduct) {
            this.newProduct = newProduct;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getSalesStore() {
            return salesStore;
        }

        public void setSalesStore(String salesStore) {
            this.salesStore = salesStore;
        }

        public SearchCondition() {
        }

        public SearchCondition(String option, String value) {
            this.option = option;
            this.value = value;
        }

        public String getOption() {
            return option;
        }

        public void setOption(String option) {
            this.option = option;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setSearchOption(String searchOption) {
        }

        public void setSearchValue(String searchValue) {
        }
        public String getProductName() {
            return productName;
        }
    }


