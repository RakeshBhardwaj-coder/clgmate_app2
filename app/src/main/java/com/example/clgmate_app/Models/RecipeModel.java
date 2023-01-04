package com.example.clgmate_app.Models;
    // this is the model packg which helps in managing our app in case of expandation of the app
public class RecipeModel {

    // getting our data get and set

    int pic;
    String text;

        public RecipeModel() {
        }

        public RecipeModel(int pic, String text) {
        this.pic = pic;
        this.text = text;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
