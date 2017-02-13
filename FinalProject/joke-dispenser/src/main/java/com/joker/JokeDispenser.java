package com.joker;

import java.util.ArrayList;
import java.util.List;

public class JokeDispenser {

    private static final List<String> repository = new ArrayList<>();

    static {
        repository.add("I will make this pencil dissapear!");
        repository.add("If two holy men want to kill each other, it makes me a happy man!");
        repository.add("Atheism is non-prophet organisation.");
        repository.add("Internet is a wonderful thing. I've never suspected there are so many idiots in this world.");
    }

    public static String getAJoke() {
        return repository.get((int)Math.floor(Math.random()*repository.size()));
    }

}
