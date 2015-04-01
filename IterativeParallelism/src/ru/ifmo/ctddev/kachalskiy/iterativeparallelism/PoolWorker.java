package ru.ifmo.ctddev.kachalskiy.iterativeparallelism;

import java.util.Queue;

/**
 * Created by Ilya on 01.04.15.
 */
class PoolWorker implements Runnable {

    private final TaskQueue taskQueue;

    PoolWorker(TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        //While thread is alive, let him do the work
        try {
            while (!Thread.interrupted()) {
                taskQueue.getNextTask().process();
            }
        } catch (InterruptedException stopSignal) {
        }
    }
}
