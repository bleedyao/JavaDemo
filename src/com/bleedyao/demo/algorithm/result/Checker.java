package com.bleedyao.demo.algorithm.result;

import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

public class Checker {
    private TestAlgorithm mTestAlgorithm;
    private CorrectAlgorithm mCorrectAlgorithm;
    private int runCount = 100;
    private int dataRange = 100;
    private int size = 100;
    private long startTime;
    private long diffTime;
    int[] originArray;
    int[] testArray;
    int[] correctArray;
    Random randomWithSeed;
    Random random;
    long seed;
    Boolean isEqual;
    Properties properties = new Properties();

    public interface TestAlgorithm {
        void test(int[] arr);
    }

    public interface CorrectAlgorithm {
        void correct(int[] arr);
    }

    private String createDividingLine() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            sb.append("=");
        }
        return sb.toString();
    }

    public Checker(TestAlgorithm testAlgorithm) {
        mTestAlgorithm = testAlgorithm;
        random = new Random();
        seed = random.nextLong();
        randomWithSeed = new Random(seed);
    }

    public Checker setCorrectAlgorithm(CorrectAlgorithm correctAlgorithm) {
        mCorrectAlgorithm = correctAlgorithm;
        return this;
    }

    public Checker setRunCount(int runCount) {
        if (runCount < 1) {
            runCount = 1;
        }
        this.runCount = runCount;
        return this;
    }

    public Checker setDataRange(int dataRange) {
        if (dataRange < 10) {
            dataRange = 10;
        }
        this.dataRange = dataRange;
        return this;
    }

    public Checker setSize(int size) {
        if (size < 10) {
            size = 10;
        }
        this.size = size;
        return this;
    }

    public void createRandomArray(int range) {
        testArray = new int[(int) (Math.random() * range)];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = random.nextInt(dataRange * 2) - dataRange;
        }
    }

    private void copyArray() {
        correctArray = Arrays.copyOf(testArray, testArray.length);
        originArray = Arrays.copyOf(testArray, testArray.length);
    }

    private void correctAlgorithm() {
        startTime = System.currentTimeMillis();
        if (mCorrectAlgorithm != null)
            mCorrectAlgorithm.correct(correctArray);
        else
            //默认升序排序
            Arrays.sort(correctArray);
        diffTime = System.currentTimeMillis() - startTime;
        System.out.println("正确算法测试时间：" + diffTime);
    }

    private void printPreSort() {
        System.out.println("待测数组：" + Arrays.toString(originArray));
    }

    private void printSortedResult() {
        System.out.println("原始数组：" + Arrays.toString(originArray));
        System.out.println("测试数组：" + Arrays.toString(testArray));
        System.out.println("正确数组：" + Arrays.toString(correctArray));
        isEqual();
        System.out.println("数组长度：" + originArray.length);
        System.out.println("测试结果：" + isEqual);
    }

    private void isEqual() {
        for (int i = 0; i < originArray.length; i++) {
            if (testArray[i] != correctArray[i]) {
                isEqual = false;
                return;
            }
        }
        isEqual = true;
    }

    public void run(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("staaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaart");
            createRandomArray((int) (Math.random() * size));
            copyArray();
            System.out.println("第 " + (i + 1) + " 测试");
//            printPreSort();
//            System.out.println();
            startTime = System.currentTimeMillis();
            mTestAlgorithm.test(testArray);
            diffTime = System.currentTimeMillis() - startTime;
            System.out.println("测试算法测试时间：" + diffTime);
            correctAlgorithm();
            printSortedResult();
            System.out.println("ennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnd");
            System.out.println();
        }
    }

    public void run() {
        run(runCount);
    }
}
