package com.example.finalproject.retrofit;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import Model.product;

public class GetProductItemDeserializer implements JsonDeserializer<List<product>> {
    List<product> products = new ArrayList<>();

    @Override
    public List<product> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray bodyObject = json.getAsJsonArray();
        for (int i = 0; i < bodyObject.size(); i++) {
            JsonObject Object = bodyObject.get(i).getAsJsonObject();
            String name = Object.get("name").toString();
            JsonArray photoArray = Object.getAsJsonArray("images");
            JsonObject srcObj = (JsonObject) photoArray.get(0);
            String src = srcObj.get("src").toString();
            product product = new product(name, src);
            products.add(product);

        }
        return products;
    }
}
