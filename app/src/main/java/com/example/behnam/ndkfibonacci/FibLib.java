package com.example.behnam.ndkfibonacci;

import android.util.Log;

public class FibLib {
    public static final String TAG = "FibLib";

    static {
        System.loadLibrary("NativeFibLib");
    }

    private static long fib(long n) {

        if (n <= 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);

    }

    public static long fibJR(long n) {
        Log.d(TAG, "fibJR(" + n + ")");
        return fib(n);

    }

    public native static long fibNR(long n);

    public static long fibJI(long n) {
        Log.d(TAG, "fibJI(" + n + ")");
        long previous = -1;
        long result = 1;
        for (int i = 0; i <= n; i++) {
            long sum = result + previous;
            previous = result;
            result = sum;
        }
        return result;
    }

    public native static long fibNI(long n);
}
