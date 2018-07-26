package com.bleedyao.demo.algorithm;

import com.bleedyao.demo.algorithm.result.Checker;
import com.bleedyao.demo.algorithm.utils.Utils;

public class Select_02 {
    public static void main(String[] args) {
        new Checker(new SelectSort())
                .setSize(10000)
                .run();
    }

    static class SelectSort implements Checker.TestAlgorithm {

        @Override
        public void test(int[] testArray) {
            if (testArray == null || testArray.length < 2) {
                return;
            }
            for (int i = 0; i < testArray.length - 1; i++) {
                int index = i;
                for (int j = i + 1; j < testArray.length; j++) {
                    index = testArray[index] < testArray[j] ? index : j;
                }
                Utils.swap(testArray, index, i);
            }
        }
    }
}
