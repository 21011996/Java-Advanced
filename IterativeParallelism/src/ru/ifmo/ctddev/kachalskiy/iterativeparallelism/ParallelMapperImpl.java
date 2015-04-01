package ru.ifmo.ctddev.kachalskiy.iterativeparallelism;

import info.kgeorgiy.java.advanced.mapper.ParallelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Ilya on 01.04.15.
 */
/**
 * Implementation of {@link info.kgeorgiy.java.advanced.mapper.ParallelMapper}.
 * <p>
 * This class is a kind of simple thread pool. Its main method
 * {@link #map(java.util.function.Function, java.util.List)} divides
 * potentially heavy work for number of {@code Threads} specified at constructor
 * and does the work in parallel.
 * <p>
 * As an implementation of {@link info.kgeorgiy.java.advanced.mapper.ParallelMapper}
 * this class derives {@link java.lang.AutoCloseable}, so it is perfectly suitable to
 * use with {@code try-with-resources}.
 */
public class ParallelMapperImpl implements ParallelMapper {

    private List<Thread> rooms;
    private TaskQueue taskQueue;

    /**
     * Create an instance of thread pool with specified number of worker {@code threads}.
     *
     * @param threads number of threads to which work should be divided
     */
    public ParallelMapperImpl(int threads) {
        rooms = new ArrayList<>();
        taskQueue = new TaskQueue();
        for (int i = 0; i < threads; i++) {
            Thread room = new Thread(new PoolWorker(taskQueue));
            rooms.add(room);
            room.start();
        }
    }

    /**
     * Apply given {@code function} to given {@code list} of arguments and do that work
     * in parallel. Number of threads specified at constructor will be number of
     * potentially workers that pops queued tasks by readiness.
     *
     * @param function action to be applied to the given {@code list} of arguments
     * @param list list to be mapped
     * @param <T> type of all the arguments in the {@code list}
     * @param <R> type of the result of the applying function
     * @return {@code List} of mapped elements
     * @throws InterruptedException if {@link #close()} was called before calculations were finished
     */
    @Override
    public <T, R> List<R> map(Function<? super T, ? extends R> function, List<? extends T> list) throws InterruptedException {
        List<Task<? super T, ? extends R>> tasks = new ArrayList<>();
        for (T arg : list) {
            Task<? super T, ? extends R> task = new Task<>(arg, function);
            taskQueue.addTask(task);
            tasks.add(task);
        }
        List<R> totalResult = new ArrayList<>();
        for (Task<? super T, ? extends R> task : tasks) {
            totalResult.add(task.getResult());
        }
        return totalResult;
    }

    /**
     * Forces all worker threads to terminate their activity (that is stop performing queued tasks)
     *
     * @throws InterruptedException if one of worker threads cannot be stopped
     */
    @Override
    public void close() throws InterruptedException {
        for (Thread room : rooms) {
            room.interrupt();
        }
    }
}
