package ru.lenarlenar.vkmessenger;


import android.util.Log;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;

import javax.inject.Singleton;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.lenarlenar.vkmessenger.model.DialogHeadersContainer;
import ru.lenarlenar.vkmessenger.model.DialogHeadersResponse;
import ru.lenarlenar.vkmessenger.model.UserDetailsResponse;
import ru.lenarlenar.vkmessenger.model.UserDetail;

/**
 * Created by Ленар on 23.05.2018.
 */
@Singleton
public class VkServiceImp implements VkService {

    private final Retrofit retrofit;
    private final UserService userService;

    public VkServiceImp() {
        retrofit = new  Retrofit.Builder()
                .baseUrl("https://api.vk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        userService = retrofit.create(UserService.class);
    }

    @Override
    public Observable<UserDetail> getMyDetails() {


        return Observable.create(subscriber -> {


            userService.getDetail(VKAccessToken.currentToken().accessToken, VKSdk.getApiVersion()).enqueue(new Callback<UserDetailsResponse>() {
                @Override
                public void onResponse(Call<UserDetailsResponse> call, Response<UserDetailsResponse> response) {
                    //Данные успешно пришли, но надо проверить response.body() на null
                    Log.d("us", "success");
                    subscriber.onNext(response.body().getUserDetails()[0]);
                }
                @Override
                public void onFailure(Call<UserDetailsResponse> call, Throwable t) {
                    Log.d("us", "fail");
                    //Произошла ошибка
                }
            });
        });
    }

    @Override
    public Observable<DialogHeadersResponse> getDialogs() {
        String v = VKSdk.getApiVersion();
        return Observable.create(subscriber -> {
//
//            userService.getDialogs(VKAccessToken.currentToken().accessToken, "5.78" , 1).enqueue(new Callback<Object>() {
//                @Override
//                public void onResponse(Call<Object> call, Response<Object> response) {
//                    //Данные успешно пришли, но надо проверить response.body() на null
//                    Log.d("us", "success");
//                    Object a = response.body();
//                    subscriber.onNext(new DialogHeadersContainer());
//                }
//                @Override
//                public void onFailure(Call<Object> call, Throwable t) {
//                    Log.d("us", "fail");
//                    //Произошла ошибка
//                }
//            });


            userService.getDialogs(VKAccessToken.currentToken().accessToken, "5.78", 5).enqueue(new Callback<DialogHeadersResponse>() {
                @Override
                public void onResponse(Call<DialogHeadersResponse> call, Response<DialogHeadersResponse> response) {
                    //Данные успешно пришли, но надо проверить response.body() на null
                    Log.d("us", "success");
                    subscriber.onNext(response.body());
                }
                @Override
                public void onFailure(Call<DialogHeadersResponse> call, Throwable t) {
                    Log.d("us", "fail");
                    //Произошла ошибка
                }
            });
        });
    }
}
