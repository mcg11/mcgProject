package com.mcg;

/**
 * Created by macg11 on 2018/8/3.
 */
public class TestT {
   static void Swap(int A[], int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

   static int Partition(int A[], int left, int right)  // 划分函数
    {
        int pivot = A[right];               // 这里每次都选择最后一个元素作为基准
        int tail = left - 1;                // tail为小于基准的子数组最后一个元素的索引
        for (int i = left; i < right; i++)  // 遍历基准以外的其他元素
        {
            if (A[i] <= pivot)              // 把小于等于基准的元素放到前一个子数组末尾
            {
                Swap(A, ++tail, i);
            }
        }
        Swap(A, tail + 1, right);           // 最后把基准放到前一个子数组的后边，剩下的子数组既是大于基准的子数组
        // 该操作很有可能把后面元素的稳定性打乱，所以快速排序是不稳定的排序算法
        return tail + 1;                    // 返回基准的索引
    }

   static void QuickSort(int A[], int left, int right)
    {
        if (left >= right)
            return;
        int pivot_index = Partition(A, left, right); // 基准的索引
        QuickSort(A, left, pivot_index - 1);
        QuickSort(A, pivot_index + 1, right);
    }

    public static void main(String[] args)
    {
        int[] A = { 5, 2, 9, 4, 7, 6, 1, 3 ,8,12,15,90,43}; // 从小到大快速排序
        int n = A.length;
        QuickSort(A, 0, n - 1);
        for (int i = 0; i < n; i++)
        {
            System.out.print( A[i]+" ");
        }
    }
}
