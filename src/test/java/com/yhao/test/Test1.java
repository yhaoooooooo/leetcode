package com.yhao.test;

import org.junit.Test;

import java.util.Arrays;

public class Test1 {

    @Test
    public void quickSort() {

        int[] data = {1, 3, 4, 53, 4, 5435, 2343};


        sort(data, 0, data.length - 1);

        System.out.println(Arrays.toString(data));
    }

    private void sort(int[] data, int left, int right) {

        int leftP = left;
        int rightP = right;


        if (left < right) {
            int tmp = data[left];
            while (left < right) {


                while (left < right && data[right] >= tmp) {
                    right--;
                }

                data[left] = data[right];


                while (left < right && data[left] < tmp) {
                    left++;
                }
                    data[right] = data[left];
            }
            data[left] = tmp;

            sort(data, leftP, left);
            sort(data, left + 1, rightP);
        }
    }
}
