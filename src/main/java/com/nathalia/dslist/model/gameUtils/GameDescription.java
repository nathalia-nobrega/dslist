package com.nathalia.dslist.model.gameUtils;

public class GameDescription {
    private String short_description;
    private String long_description;

    public GameDescription(String short_description, String long_description) {
        this.short_description = short_description;
        this.long_description = long_description;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    @Override
    public String toString() {
        return "GameDescription{" +
                "short_description='" + short_description + '\'' +
                ", long_description='" + long_description + '\'' +
                '}';
    }
}
