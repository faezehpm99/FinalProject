package Model;

import retrofit2.http.Url;

public class product {
    private String mProductName;
    private Url mProductSrc;


    public product() {
    }

    public product(String mProductName, Url mProductSrc) {
        this.mProductName = mProductName;
        this.mProductSrc = mProductSrc;
    }

    public Url getProductSrc() {
        return mProductSrc;
    }

    public void setProductSrc(Url mProductSrc) {
        this.mProductSrc = mProductSrc;
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String mProductName) {
        this.mProductName = mProductName;
    }


}
