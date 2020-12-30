package com.example.finalproject.retrofit;

import android.net.Uri;

import java.util.HashMap;
import java.util.Map;

import Model.product;

public class NetWorkParams {
    public static final String BASE_URL = "https://woocommerce.maktabsharif.ir/wp-json/wc/v3/";
    public static final String consumer_key = "ck_f025265e3479f7bee8e93bffe5685517b93ec27d";
    public static final String consumer_secret = "cs_27b19e572ac9cf1333d4d53f7082a15e9fb6a2b0a";
    public static final Map<String, String> BASE_OPTIONS = new HashMap<String, String>() {{
        put("consumer_key",consumer_key);
        put("consumer_secret",consumer_secret);
    }};
    public static Map<String, String> getProductList() {
        Map<String, String> productList = new HashMap<>();
        productList.putAll(BASE_OPTIONS);
        return productList;
    }

    public static Uri getPhotoPageUri(product productItem) {
        Uri uri = Uri.parse("https://woocommerce.maktabsharif.ir/wp-json/wc/v3/")
                .buildUpon()
                .build();

        return uri;
    }
}
