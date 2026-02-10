package com.chitkara.bfhl.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlService {

    // ---------- FIBONACCI ----------
    public List<Integer> fibonacci(int n) {
        List<Integer> result = new ArrayList<>();
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            result.add(a);
            int temp = a + b;
            a = b;
            b = temp;
        }
        return result;
    }

    // ---------- PRIME ----------
    public List<Integer> primes(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        for (int n : nums) {
            if (isPrime(n))
                result.add(n);
        }
        return result;
    }

    private boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    // ---------- HCF ----------
    public int hcf(List<Integer> nums) {
        int result = nums.get(0);
        for (int n : nums)
            result = gcd(result, n);
        return result;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ---------- LCM ----------
    public int lcm(List<Integer> nums) {
        int result = nums.get(0);
        for (int n : nums)
            result = (result * n) / gcd(result, n);
        return result;
    }
}
