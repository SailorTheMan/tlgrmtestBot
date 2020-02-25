package org.example;

public enum Comands {
    START {
        public String getComand(){ return "/start"; }
    },
    HELP {
        public String getComand(){ return "/help"; }
    };

    public abstract String getComand();
}
