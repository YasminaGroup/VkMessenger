package ru.lenarlenar.vkmessenger;


import io.reactivex.Observable;
import ru.lenarlenar.vkmessenger.model.User;

/**
 * Created by Ленар on 22.05.2018.
 */

public interface VkService {
    Observable<User> getMyDetails();
}
