package com.example.lab_2_2_2;

/**
 * Demo class
 *
 * @author chenshuoke
 * @date 2019/4
 */
public class Item {
    private int image;
    private String first;
    private String second;

    public Item(int image, String first, String second){
        this.image = image;
        this.first = first;
        this.second = second;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}