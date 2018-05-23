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
import ru.lenarlenar.vkmessenger.model.User;
import ru.lenarlenar.vkmessenger.model.VkUser;

/**
 * Created by Ленар on 23.05.2018.
 */

public class VkServiceImp implements VkService {
    @Override
    public Observable<User> getMyDetails() {


        return Observable.create(subscriber -> {



            Retrofit retrofit = new  Retrofit.Builder()
                    .baseUrl("https://api.vk.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            UserService us = retrofit.create(UserService.class);

            us.getDetail(VKAccessToken.currentToken().accessToken, VKSdk.getApiVersion()).enqueue(new Callback<VkUser>() {
                @Override
                public void onResponse(Call<VkUser> call, Response<VkUser> response) {
                    //Данные успешно пришли, но надо проверить response.body() на null
                    Log.d("us", "success");
                    if(response.body() != null){
                        Log.d("us", response.body().getFirstName());
                    }
                }
                @Override
                public void onFailure(Call<VkUser> call, Throwable t) {
                    Log.d("us", "fail");
                    //Произошла ошибка
                }
            });
//           Callback<User> callback = new Callback<VKApiUser>() {
//                @Override
//                public void success(VKApiUser result) {
//                    Log.i(TAG, "Got your details, pal!");
//                    subscriber.onNext(new com.zedeff.twittererer.models.User(result.data.name, result.data.screenName, result.data.profileImageUrl));
//                }
//
//                @Override
//                public void failure(TwitterException e) {
//                    Log.e(TAG, e.getMessage(), e);
//                    subscriber.onError(e);
//                }
//            };

            //getService(UserService.class).show(TwitterCore.getInstance().getSessionManager().getActiveSession().getUserId()).enqueue(callback);
        });
    }
}
