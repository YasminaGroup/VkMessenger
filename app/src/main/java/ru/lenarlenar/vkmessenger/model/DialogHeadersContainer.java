
package ru.lenarlenar.vkmessenger.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DialogHeadersContainer {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("unread_dialogs")
    @Expose
    private Integer unreadDialogs;
    @SerializedName("items")
    @Expose
    private List<DialogHeader> items = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUnreadDialogs() {
        return unreadDialogs;
    }

    public void setUnreadDialogs(Integer unreadDialogs) {
        this.unreadDialogs = unreadDialogs;
    }

    public List<DialogHeader> getItems() {
        return items;
    }

    public void setItems(List<DialogHeader> items) {
        this.items = items;
    }

}
