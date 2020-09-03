package com.book.datastructure.sequencelist;

import java.util.Arrays;

/**
 * 顺序表
 */
public class SequenceList {
    private int[] arr;
    private int size;

    public SequenceList() {
        this(0);
    }

    public SequenceList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("illegal argument size:" + initialCapacity);
        }
        arr = new int[initialCapacity];
    }

    public boolean add(int element) {
        ensureCapacity(size + 1);
        arr[size++] = element;
        return true;
    }

    public boolean add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
        }
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        size++;
        return true;
    }

    public int remove(int index) {
        rangeCheck(index);
        int oldValue = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = 0;
        return oldValue;
    }

    public int set(int index, int newValue) {
        rangeCheck(index);
        int oldValue = arr[index];
        arr[index] = newValue;
        return oldValue;
    }

    public int get(int index) {
        rangeCheck(index);
        return arr[index];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (arr.length == 0) {
            minCapacity = Math.max(10, minCapacity);
        }
        if (minCapacity > arr.length) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = arr.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        arr = Arrays.copyOf(arr, newCapacity);
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int i = 0;
        while (true) {
            sb.append(arr[i]);
            if (i + 1 == size) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
            i++;
        }
    }

    public int size() {
        return size;
    }

    public int length() {
        return arr.length;
    }

}
