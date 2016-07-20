package com.matthewcoggin.sd2550.mccriminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by MC on 7/13/16.
 */
public class Crime {
    private UUID id;
    private String title;
    private Date date;
    private boolean solved;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
