package ru.ifmo.ctddev.kachalskiy.iterativeparallelism;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ilya on 01.04.15.
 */
class TaskQueue {

    private final Queue<Task<?, ?>> taskQueue;

    TaskQueue() {
        taskQueue = new LinkedList<>();
    }

    public synchronized void addTask(Task<?, ?> task) {
        taskQueue.add(task);
        //Notify workers to wake them up
        notifyAll();
    }

    public synchronized Task<?, ?> getNextTask() throws InterruptedException {
        while (taskQueue.isEmpty()) {
            wait();
        }
        return taskQueue.poll();
    }

}