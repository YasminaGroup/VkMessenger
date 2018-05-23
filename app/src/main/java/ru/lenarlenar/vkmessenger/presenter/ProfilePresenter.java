package ru.lenarlenar.vkmessenger.presenter;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import ru.lenarlenar.vkmessenger.VkService;
import ru.lenarlenar.vkmessenger.view.ProfileView;

/**
 * Created by Ленар on 21.05.2018.
 */

public class ProfilePresenter {

    private final VkService vkService;

    @Inject
    public ProfilePresenter(VkService service){

        this.vkService = service;
    }

    private WeakReference<ProfileView> view;

    public void initialise(ProfileView view) {
        this.view = new WeakReference<>(view);
        vkService.getMyDetails().subscribe(user -> {
            int a = 1;
        });

//        service.getMyDetails()
//                .observeOn(scheduler)
//                .subscribe(user -> {
//                    service.setCurrentUser(user);
//                    refreshTweets();
//                });
    }
}
