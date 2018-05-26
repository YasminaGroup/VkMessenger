package ru.lenarlenar.vkmessenger;

import dagger.Component;
import ru.lenarlenar.vkmessenger.ui.ProfileFragment;

/**
 * Created by zvezdy.lord on 25.05.18.
 */

@Component(dependencies = App.BaseApplicationComponent.class)
interface FragmentComponent {

    void inject(ProfileFragment fragment);
}
