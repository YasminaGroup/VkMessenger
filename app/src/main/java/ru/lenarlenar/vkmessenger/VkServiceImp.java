package ru.lenarlenar.vkmessenger;


import android.util.Log;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKSdk;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.lenarlenar.vkmessenger.model.UsersResponseModel;
import ru.lenarlenar.vkmessenger.model.VkUser;

/**
 * Created by Ленар on 23.05.2018.
 */

public class VkServiceImp implements VkService {
    @Override
    public Observable<VkUser> getMyDetails() {


        return Observable.create(subscriber -> {



            Retrofit retrofit = new  Retrofit.Builder()
                    .baseUrl("https://api.vk.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            UserService us = retrofit.create(UserService.class);

            us.getDetail(VKAccessToken.currentToken().accessToken, VKSdk.getApiVersion()).enqueue(new Callback<UsersResponseModel>() {
                @Override
                public void onResponse(Call<UsersResponseModel> call, Response<UsersResponseModel> response) {
                    //Данные успешно пришли, но надо проверить response.body() на null
                    Log.d("us", "success");
                    subscriber.onNext(response.body().getUsers()[0]);
                }
                @Override
                public void onFailure(Call<UsersResponseModel> call, Throwable t) {
                    Log.d("us", "fail");
                    //Произошла ошибка
                }
            });
        });
    }
}
