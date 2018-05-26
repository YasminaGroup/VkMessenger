package ru.lenarlenar.vkmessenger;


import io.reactivex.Observable;
import ru.lenarlenar.vkmessenger.model.DialogHeadersContainer;
import ru.lenarlenar.vkmessenger.model.DialogHeadersResponse;
import ru.lenarlenar.vkmessenger.model.UserDetail;

/**
 * Created by Ленар on 22.05.2018.
 */

public interface VkService {
    Observable<UserDetail> getMyDetails();
    Observable<DialogHeadersResponse> getDialogs();
}
