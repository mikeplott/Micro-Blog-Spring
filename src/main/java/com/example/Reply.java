package com.example;

/**
 * Created by michaelplott on 10/22/16.
 */
public class Reply {
    int id;
    String reply;
    int mID;

    public Reply() {
    }

    public Reply(int id, String reply) {
        this.id = id;
        this.reply = reply;
    }

    public Reply(int id, String reply, int mID) {
        this.id = id;
        this.reply = reply;
        this.mID = mID;
    }

    public int getId() {
        return id;
    }

    public String getReply() {
        return reply;
    }

    public int getmID() {
        return mID;
    }
}
