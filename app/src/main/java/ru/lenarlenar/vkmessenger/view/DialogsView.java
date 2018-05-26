package ru.lenarlenar.vkmessenger.view;

import java.util.List;

import ru.lenarlenar.vkmessenger.model.DialogHeader;

/**
 * Created by zvezdy.lord on 25.05.18.
 */

public interface DialogsView {
    void show(List<DialogHeader> messages);
}
