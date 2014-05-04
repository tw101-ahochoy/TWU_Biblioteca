package com.twu.biblioteca;

public class DoneState {

    private Boolean done;

    public DoneState(Boolean done){

        this.done = done;
    }

    public Boolean isDone(){
        return done;
    }

    public void toggle(){
        this.done = !this.done;
    }
}
