package practice1.task3;

import java.util.Arrays;

/**
 * Created by Vinakurau Kiryl on 16.03.2021.
 */
public class DynamicArrayWithGenerics<T> {

    private int size;
    private int index = 0;
    private Object[] array;

    public DynamicArrayWithGenerics() {
        size = 16;
        array = new Object[size];
    }

    public DynamicArrayWithGenerics(int size) {
        this.size = size;
        array = new Object[size];
    }

    public void add(T e) {
        if(size == index) {
            Object[] temp = array;
            size = size + 10;
            array = new Object[size];
            for(int i = 0; temp.length > i; i++) {
                array[i] = temp[i];
            }
        }
        array[index++] = e;
    }

    public T get(int index) {
        return (T) array[index];
    }
    
    public void remove(int index) {
        int tempIndex = --this.index;
        if(index == tempIndex) {
            array[index] = null;
        } else if(index == 0) {
            for(int i = 0; tempIndex > i;) {
                array[i] = array[++i];
            }
            array[this.index] = null;
        } else if(index > 0 && index < tempIndex) {
            Object[] temp = array;
            array = new Object[size];
            for (int i = 0; tempIndex > i;) {
                if (i >= index) {
                    array[i] = temp[++i];
                } else {
                    array[i] = temp[i++];
                }
            }
        } else {
            this.index++;
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return "DynamicArray:" +
                "\n     size = " + size +
                "\n     index = " + index +
                "\n     array = " + Arrays.toString(array) + "\n";
    }

    public static void main(String[] args) {
        DynamicArrayWithGenerics<Double> dynamicArray = new DynamicArrayWithGenerics<>(2);
        System.out.println(dynamicArray.toString());
        dynamicArray.add(1.1);
        dynamicArray.add(2.2);
        dynamicArray.add(3.3);
        dynamicArray.add(4.4);
        dynamicArray.add(5.5);
        dynamicArray.add(6.6);
        dynamicArray.add(7.7);
        dynamicArray.add(8.8);
        System.out.println(dynamicArray.toString());
        System.out.println("dynamicArray.get[2] = " + dynamicArray.get(2) + "\n");
        System.out.println("delete index[0]: ");
        dynamicArray.remove(0);
        System.out.println(dynamicArray.toString());
        System.out.println("delete index[6]: ");
        dynamicArray.remove(6);
        System.out.println(dynamicArray.toString());
        System.out.println("delete index[2]: ");
        dynamicArray.remove(2);
        System.out.println(dynamicArray.toString());
        dynamicArray.add(9.9);
        System.out.println(dynamicArray.toString());
        dynamicArray.remove(8);
    }
}
