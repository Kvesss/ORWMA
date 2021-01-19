package hr.ferit.lv8;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static ApiInterface apiInterface;
    public static ApiInterface getApiInterface(){
        if(apiInterface == null){
            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            apiInterface = retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }
}
