package ru.lenarlenar.vkmessenger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.button_login)
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(VKAccessToken.currentToken() != null && !VKAccessToken.currentToken().isExpired()){
            openNextScreen();
        }

        ButterKnife.bind(this);

        loginBtn.setOnClickListener((view) -> {VKSdk.login(this, "email");});
    }

    private void openNextScreen(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                openNextScreen();
            }
            @Override
            public void onError(VKError error) {

            }
        })){
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
