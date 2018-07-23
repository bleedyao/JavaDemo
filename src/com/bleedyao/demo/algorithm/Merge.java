package com.bleedyao.demo.algorithm;

import com.bleedyao.demo.algorithm.result.Checker;

public class Merge {
    public static void main(String[] args) {
        new Checker(new MergeSort())
                .setSize(10_000)
                .run();
    }

    static class MergeSort implements Checker.TestAlgorithm {
        @Override
        public void test(int[] arr) {
            if (arr == null || arr.length < 2) {
                return;
            }
            sortProcess(arr, 0, arr.length - 1);
        }

        private void sortProcess(int[] arr, int left, int right) {
            if (left == right)
                return;
            int mid = left + ((right - left) >> 1);

            sortProcess(arr, left, mid);
            sortProcess(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }

        private void merge(int[] arr, int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int i = 0;
            int p1 = left;
            int p2 = mid + 1;

            while (p1 <= mid && p2 <= right) {
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
        }
    }
}
