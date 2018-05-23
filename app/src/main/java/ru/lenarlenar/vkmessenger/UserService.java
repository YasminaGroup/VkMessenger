package ru.lenarlenar.vkmessenger;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.lenarlenar.vkmessenger.model.VkUser;

/**
 * Created by Ленар on 22.05.2018.
 */

public interface UserService {
    @GET("/method/users.get")
    Call<VkUser> getDetail(@Query("access_token") String token, @Query("version") String version);
}
