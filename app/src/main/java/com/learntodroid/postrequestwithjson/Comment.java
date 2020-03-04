package com.learntodroid.postrequestwithjson;

public class Comment {
    private String title;

    private String comment;

    private String author;

    public Comment(String title, String comment, String author) {
        this.title = title;
        this.comment = comment;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public String getAuthor() {
        return author;
    }
}
