package com.laudandjolynn.test.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @author: huangtiande
 * @email:htd0324@gmail.com
 * @date: 2013年10月9日
 */

public class QuickSort {
	public static final Random RND = new Random();

	private static void swap(Object[] array, int i, int j) {
		Object tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	private static <E> int partition(E[] array, int begin, int end,
			Comparator<? super E> cmp) {
		int index = begin + RND.nextInt(end - begin + 1);
		E pivot = array[index];
		swap(array, index, end);
		for (int i = index = begin; i < end; ++i) {
			if (cmp.compare(array[i], pivot) <= 0) {
				swap(array, index++, i);
			}
		}
		swap(array, index, end);
		return (index);
	}

	private static <E> void qsort(E[] array, int begin, int end,
			Comparator<? super E> cmp) {
		if (end > begin) {
			int index = partition(array, begin, end, cmp);
			qsort(array, begin, index - 1, cmp);
			qsort(array, index + 1, end, cmp);
		}
	}

	public static <E> void sort(E[] array, Comparator<? super E> cmp) {
		qsort(array, 0, array.length - 1, cmp);
	}

	public static void main(String[] args) {
		Integer[] data = new Integer[] { 3, 5, 2, 7, 6, 8, 1, 0, 9, 4 };
		sort(data, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2) {
					return 1;
				} else if (o1 == o2) {
					return 0;
				} else {
					return -1;
				}
			}

		});

		System.out.println(Arrays.deepToString(data));
	}
}
