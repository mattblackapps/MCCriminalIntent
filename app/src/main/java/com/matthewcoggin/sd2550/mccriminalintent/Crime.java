package com.matthewcoggin.sd2550.mccriminalintent;

import java.util.UUID;

/**
 * Created by MC on 7/13/16.
 */
public class Crime {
    private UUID id;
    private String title;

    public Crime () {
        id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String mTitle) {
        this.title = mTitle;
    }

}
