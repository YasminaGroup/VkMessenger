package ru.lenarlenar.vkmessenger.presenter;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import ru.lenarlenar.vkmessenger.VkService;
import ru.lenarlenar.vkmessenger.view.DialogsView;
import ru.lenarlenar.vkmessenger.view.ProfileView;

/**
 * Created by zvezdy.lord on 25.05.18.
 */

public class DialogsPresenter {

    private final VkService vkService;

    @Inject
    public DialogsPresenter(VkService service){

        this.vkService = service;
    }

    private WeakReference<DialogsView> view;

    public void initialise(DialogsView view) {
        this.view = new WeakReference<>(view);
        vkService.getDialogs().subscribe(dialogHeadersResponse -> {
            view.show(dialogHeadersResponse.getResponse().getItems());
        });
    }
}
