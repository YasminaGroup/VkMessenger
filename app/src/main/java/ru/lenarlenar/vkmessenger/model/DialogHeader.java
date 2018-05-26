
package ru.lenarlenar.vkmessenger.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DialogHeader {

    @SerializedName("message")
    @Expose
    private DialogHeaderTitle message;
    @SerializedName("in_read")
    @Expose
    private Integer inRead;
    @SerializedName("out_read")
    @Expose
    private Integer outRead;

    public DialogHeaderTitle getMessage() {
        return message;
    }

    public void setMessage(DialogHeaderTitle message) {
        this.message = message;
    }

    public Integer getInRead() {
        return inRead;
    }

    public void setInRead(Integer inRead) {
        this.inRead = inRead;
    }

    public Integer getOutRead() {
        return outRead;
    }

    public void setOutRead(Integer outRead) {
        this.outRead = outRead;
    }

}
