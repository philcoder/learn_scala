package com.philipp.ch6;

public class Calculator {
    public int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
