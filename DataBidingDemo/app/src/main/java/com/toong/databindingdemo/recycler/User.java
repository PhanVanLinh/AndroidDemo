package com.toong.databindingdemo.recycler;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.ImageView;

import com.toong.databindingdemo.BR;

/**
 * Created by framgia on 04/11/2016.
 */

public class User extends BaseObservable {
    private String firstName;
    private String lastName;
    private String iconUrl;

    public User(String firstName, String lastName, String iconUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.iconUrl = iconUrl;
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }
    @Bindable
    public String getFirstName() {
        return firstName;
    }
    @Bindable
    public String getIconUrl(){return iconUrl;};

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        notifyPropertyChanged(BR.iconUrl);
    }
}
