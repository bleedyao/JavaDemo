package com.bleedyao.demo.algorithm;

import com.bleedyao.demo.algorithm.result.Checker;
import com.bleedyao.demo.algorithm.utils.Utils;

public class Insert {
    public static void main(String[] args) {
        new Checker(new InsertSort())
                .setSize(10_000).run();
    }

    static class InsertSort implements Checker.TestAlgorithm {
        @Override
        public void test(int[] testArray) {
            if (testArray == null || testArray.length < 2)
                return;
            for (int i = 1; i < testArray.length; i++) {
                for (int j = i; j > 0 && testArray[j] < testArray[j - 1]; j--) {
                    Utils.swap(testArray, j, j - 1);
                }
            }
        }
    }
}
