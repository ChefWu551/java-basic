package com.yuefeng.thread.asynchronized;

import java.util.concurrent.Future;

public class MyFuture<T> {

    private T result;

    public T getFuture() {
        return result;
    }
}
