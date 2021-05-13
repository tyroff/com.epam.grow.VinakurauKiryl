package practice4.task5_Compare;

import practice4.task5_Compare.entity.ConsumerClassic;
import practice4.task5_Compare.entity.ConsumerConcurrent;
import practice4.task5_Compare.entity.ProducerClassic;
import practice4.task5_Compare.entity.ProducerConcurrent;
import practice4.task5_Compare.util.MyBlockingQueue;
import practice4.task5_Compare.util.MyQueue;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static int countOperation = 0;

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyBlockingQueue(10);
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

        Long startTime = new Date().getTime();
        ProducerClassic producerClassic1 = new ProducerClassic(queue);
        ProducerClassic producerClassic2 = new ProducerClassic(queue);
        ConsumerClassic consumerClassic1 = new ConsumerClassic(queue);
        ConsumerClassic consumerClassic2 = new ConsumerClassic(queue);

        producerClassic1.start();
        producerClassic2.start();
        consumerClassic1.start();
        consumerClassic2.start();

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producerClassic1.interrupt();
        producerClassic2.interrupt();
        consumerClassic1.interrupt();
        consumerClassic2.interrupt();

        Long endTime = new Date().getTime() - startTime;
        System.out.println("The number of operations per second in the classical way: " + (countOperation / (endTime / 1000)));

        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countOperation = 0;

        Long startTime2 = new Date().getTime();
        ProducerConcurrent producerConcurrent1 = new ProducerConcurrent(blockingQueue);
        ProducerConcurrent producerConcurrent2 = new ProducerConcurrent(blockingQueue);
        ConsumerConcurrent consumerConcurrent1 = new ConsumerConcurrent(blockingQueue);
        ConsumerConcurrent consumerConcurrent2 = new ConsumerConcurrent(blockingQueue);

        producerConcurrent1.start();
        producerConcurrent2.start();
        consumerConcurrent1.start();
        consumerConcurrent2.start();

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producerConcurrent1.interrupt();
        producerConcurrent2.interrupt();
        consumerConcurrent1.interrupt();
        consumerConcurrent2.interrupt();

        Long endTime2 = new Date().getTime() - startTime2;
        System.out.println("The number of operations per second in the concurrent way: " + (countOperation / (endTime2 / 1000)));
    }
}
