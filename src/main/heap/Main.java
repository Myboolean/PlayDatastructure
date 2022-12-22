package main.heap;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/22
 * Time: 14:01
 *
 * @author:pzj
 */
public class Main {
    public static double testHeap(Integer [] testData, boolean isHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify) {
            maxHeap = new MaxHeap<>();
            for (int i = 0; i < testData.length; i++) {
                maxHeap.add(testData[i]);
            }


        }else {
            maxHeap = new MaxHeap<>(testData);
        }
        long endTime =System.nanoTime();
        int [] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < testData.length; i++) {
            if(arr[i-1] < arr[i]){
                throw new IllegalArgumentException("Eoor");
            }
        }
//        long endTime =System.nanoTime();
        System.out.println("complement");
        return (endTime - startTime)/ 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 10000000;

        Random random = new Random();
        Integer []testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i ]= random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, false);
        double time2 = testHeap(testData, true);
        System.out.println(time1 + " only");
        System.out.println(time2 + " one by one");
//        int [] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = heap.extractMax();
//        }
//        for (int i = 1; i < n; i++) {
//            if(arr[i-1] < arr[i]){
//                throw new IllegalArgumentException("Eoor");
//            }
//        }
//        System.out.println("success completed");
    }
}
