package com.example.weather_app.Domains;

public class weatherCard {
    private String day;
    private String pic;
    private String status;
    private int lowTemp;
    private int highTemp;

    public weatherCard(String day, String pic, String status, int lowTemp, int highTemp) {
        this.day = day;
        this.pic = pic;
        this.status = status;
        this.lowTemp = lowTemp;
        this.highTemp = highTemp;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(int lowTemp) {
        this.lowTemp = lowTemp;
    }

    public int getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(int highTemp) {
        this.highTemp = highTemp;
    }
}