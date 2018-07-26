package com.bleedyao.demo.algorithm;

import com.bleedyao.demo.algorithm.result.Checker;

public class SmallSum_05 {
    public static void main(String[] args) {
        new Checker(new SmallSumQuestion())
                .setCorrectAlgorithm(new SmallSumCorrect())
                .setSize(20_000).run();
    }

    static class SmallSumCorrect implements Checker.CorrectAlgorithm {

        @Override
        public void correct(int[] arr) {
            int res = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] < arr[j]) {
                        res += arr[i];
                    }
                }
            }
            System.out.println("正确答案小和结果：" + res);
        }
    }

    static class SmallSumQuestion implements Checker.TestAlgorithm {
        @Override
        public void test(int[] arr) {
            if (arr == null || arr.length < 2)
                return;
            int sum = mergeSort(arr, 0, arr.length - 1);
            System.out.println("测试方法小和结果：" + sum);
        }

        private int mergeSort(int[] arr, int left, int right) {
            if (left == right)
                return 0;
            int mid = left + ((right - left) >> 1);
            return mergeSort(arr, left, mid)
                    + mergeSort(arr, mid + 1, right)
                    + merge(arr, left, mid, right);
        }

        private int merge(int[] arr, int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int i = 0;
            int p1 = left;
            int p2 = mid + 1;
            int res = 0;
            while (p1 <= mid && p2 <= right) {
                res += arr[p1] < arr[p2] ? arr[p1] * (right - p2 + 1) : 0;
                temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            }

            while (p1 <= mid) {
                temp[i++] = arr[p1++];
            }

            while (p2 <= right) {
                temp[i++] = arr[p2++];
            }

            for (i = 0; i < temp.length; i++) {
                arr[left + i] = temp[i];
            }
            return res;
        }
    }
}
