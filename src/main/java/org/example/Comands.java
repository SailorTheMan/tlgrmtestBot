package org.example;

public enum Comands {
    START { @Override public String getComand(){ return "/start"; } },

    HELP { @Override public String getComand(){ return "/help"; } },

    RANDOM { @Override public String getComand() { return "/random"; } };


    public abstract String getComand();
}
