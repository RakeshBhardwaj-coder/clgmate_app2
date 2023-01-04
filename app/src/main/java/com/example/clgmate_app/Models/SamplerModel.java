package com.example.clgmate_app.Models;

public class SamplerModel {
    int bookPic;
    String bookName,bookAuthor;

    public SamplerModel(int bookPic, String bookName, String bookAuthor) {
        this.bookPic = bookPic;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }

    public int getBookPic() {
        return bookPic;
    }

    public void setBookPic(int bookPic) {
        this.bookPic = bookPic;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
