package hr.ferit.lv8;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    //json2pojo => generiranje objekata iz json-a
    //jsonpretty => prettyprint


    @GET("users")
    Call<List<User>> getUsers();

    @GET("users/{id}")
    Call<User> getUser(@Path("id") String userId);

    @GET("products.json")
    Call<List<User>> getUsers(@Query("brand") String name);     //ZADACA TODO TODO TODO
}
