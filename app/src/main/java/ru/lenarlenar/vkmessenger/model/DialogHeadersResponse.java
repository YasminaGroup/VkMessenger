
package ru.lenarlenar.vkmessenger.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DialogHeadersResponse {

    @SerializedName("response")
    @Expose
    private DialogHeadersContainer response;

    public DialogHeadersContainer getResponse() {
        return response;
    }

    public void setResponse(DialogHeadersContainer response) {
        this.response = response;
    }

 /*   @SerializedName("response")
    @Expose
    private Object[] response;

    public Object[] getResponse() {
        return response;
    }

    public void setResponse(Object[] response) {
        this.response = response;
    }*/

}
