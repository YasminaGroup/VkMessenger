package ru.lenarlenar.vkmessenger;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.lenarlenar.vkmessenger.model.DialogHeadersResponse;
import ru.lenarlenar.vkmessenger.model.UserDetailsResponse;

/**
 * Created by Ленар on 22.05.2018.
 */

public interface UserService {
    @GET("/method/users.get")
    Call<UserDetailsResponse> getDetail(@Query("access_token") String token, @Query("version") String version);

    @GET("/method/messages.getDialogs")
    Call<DialogHeadersResponse> getDialogs(@Query("access_token") String token, @Query("v") String version, @Query("count") int count);
}
