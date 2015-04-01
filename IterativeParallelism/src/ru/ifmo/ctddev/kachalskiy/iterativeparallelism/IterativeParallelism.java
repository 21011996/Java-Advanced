package ru.ifmo.ctddev.kachalskiy.iterativeparallelism;

import info.kgeorgiy.java.advanced.concurrent.ScalarIP;
import info.kgeorgiy.java.advanced.mapper.ParallelMapper;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Implementation of {@link info.kgeorgiy.java.advanced.concurrent.ScalarIP}.
 * <p>
 * This class is a convenient way to perform common operations on <tt>Lists</tt>,
 * such as {@link #minimum(int, java.util.List, java.util.Comparator)},
 * {@link #all(int, java.util.List, java.util.function.Predicate)} and some others.
 *
 * @see java.util.stream.Stream
 * @see java.util.function.Function
 * @see java.util.function.Predicate
 */
public class IterativeParallelism implements ScalarIP {

    /**
     * Instance of {@code thread pool}
     */
    private ParallelMapper mapper;

    /**
     * Create a simple instance of {@code IterativeParallelism} that creates
     * and manages worker threads itself
     */
    public IterativeParallelism() {
    }

    /**
     * Create an instance of {@code IterativeParallelism} that uses specified
     * {@code ParallelMapper} as a {@code thread pool} for intrinsic purposes.
     * All the work is performing in parallel through it.
     *
     * @param mapper given {@code thread pool}
     */
    public IterativeParallelism(ParallelMapper mapper) {
        this.mapper = mapper;
    }

    public static void main(String[] args) throws InterruptedException {
    }


    /**
     * Splits <tt>list</tt> into <tt>partsNumber</tt> of <tt>sub-lists</tt> each of which
     * is about the same size (<code>Math.ceil(list.size() / partsNumber)</code>) and
     * returns them in forward (left-to-right) order.
     *
     * @param partsNumber number of parts
     * @param list initial list to be divided
     * @param <T> <tt>parent generic</tt> type of elements
     * @return <tt>List</tt> of <tt>sub-lists</tt>
     */
    private <T> List<List<? extends T>> divideIntoParts(int partsNumber, List<? extends T> list) {
        if (partsNumber < 1) {
            partsNumber = 1;
        } else if (partsNumber > list.size()) {
            partsNumber = list.size();
        }
        int chunkSize = (int) Math.ceil(1d * list.size() / partsNumber);
        int lowerBound = 0;
        int upperBound = Math.min(lowerBound + chunkSize, list.size());
        List<List<? extends T>> parts = new ArrayList<>();
        for (int i = 0; i < partsNumber; i++) {
            parts.add(list.subList(lowerBound, upperBound));
            chunkSize = (int) Math.ceil(1d * (list.size() - upperBound) / (partsNumber - i - 1));
            lowerBound = upperBound;
            upperBound = Math.min(list.size(), upperBound + chunkSize);
        }
        return parts;
    }

    /**
     * Instances of this class perform all heavy operations in their main
     * {@link #run()} method and saves result in {@code result}
     * @param <R> {@code generic} type of result
     */
    private static class PartWorker<T, R> implements Runnable {

        private List<? extends T> part;
        private Function<List<? extends T>, R> action;
        private R result;

        private PartWorker(List<? extends T> part, Function<List<? extends T>, R> action) {
            this.part = part;
            this.action = action;
        }

        public R getResult() {
            return result;
        }

        @Override
        public void run() {
            result = action.apply(part);
        }
    }

    /**
     * Performs <i>work</i> on the specified <tt>list</tt> in parallel using
     * specified number <tt>threads</tt> of {@link java.lang.Thread} objects.
     * <p>
     * It firstly divides the <tt>list</tt> into <tt>threads</tt> parts,
     * performs operation in parallel on each of them and then combines results of threads
     * to get best performance.
     *
     * @param threads number of <tt>Threads</tt> in which work should be done.
     * @param list <tt>List</tt> on which work should be done
     * @param action function that specifies which action should be done on
     * each part of divided <tt>list</tt>
     * @param combiner function that specifies how to combine results of production
     * of divided parts
     * @param <T> <tt>parent generic</tt> type of elements
     * @param <R> <tt>generic</tt> type of expected result
     * @return result of work in the form of expected type
     * @throws InterruptedException if any worker thread was interrupted during his work
     */
    private <T, R> R parallelisation(int threads, List<? extends T> list,
                                     Function<List<? extends T>, R> action,
                                     Function<List<R>, R> combiner) throws InterruptedException {
        List<List<? extends T>> parts = divideIntoParts(threads, list);
        if (mapper != null) {
            List<R> results = mapper.map(action, parts);
            return combiner.apply(results);
        } else {
            List<Thread> rooms = new ArrayList<>();
            List<PartWorker<T, R>> workers = new ArrayList<>();
            for (List<? extends T> part : parts) {
                PartWorker<T, R> worker = new PartWorker<T, R>(part, action);
                workers.add(worker);
                Thread room = new Thread(worker);
                rooms.add(room);
                room.start();
            }
            for (Thread room : rooms) {
                room.join();
            }
            return combiner.apply(workers.stream().map(PartWorker::getResult).collect(Collectors.toList()));
        }
    }

    /**
     * For the given <tt>list</tt> returns minimum element in this list according to
     * <tt>comparator</tt>.
     * <p>
     * For intrinsic purposes it uses <tt>threads</tt> of
     * {@link java.lang.Thread} objects. Each of them gets its own part of work to
     * perform the whole work in parallel.
     *
     * @param threads number of <tt>Threads</tt> in which work should be done.
     * @param list <tt>List</tt> where to find minimum element
     * @param comparator comparator according to which compares performs
     * @param <T> <tt>parent</tt> <tt>generic</tt> type of elements
     * @return minimum element in list in the sense of <tt>comparator</tt>
     * @throws InterruptedException if any worker thread was interrupted during his work
     */
    @Override
    public <T> T minimum(int threads, List<? extends T> list, Comparator<? super T> comparator) throws InterruptedException {
        return parallelisation(threads, list, part -> Collections.min(part, comparator), results -> Collections.min(results, comparator));
    }

    /**
     * For the given <tt>list</tt> returns maximum element in this list according to
     * <tt>comparator</tt>.
     * <p>
     * For intrinsic purposes it uses <tt>threads</tt> of
     * {@link java.lang.Thread} objects. Each of them gets its own part of work to
     * perform the whole work in parallel.
     *
     * @param threads number of <tt>Threads</tt> in which work should be done.
     * @param list <tt>List</tt> where to find minimum element
     * @param comparator comparator according to which compares performs
     * @param <T> <tt>parent</tt> <tt>generic</tt> type of elements
     * @return maximum element in list in the sense of <tt>comparator</tt>
     * @throws InterruptedException if any worker thread was interrupted during its work
     */
    @Override
    public <T> T maximum(int threads, List<? extends T> list, Comparator<? super T> comparator) throws InterruptedException {
        return parallelisation(threads, list, part -> Collections.max(part, comparator), results -> Collections.max(results, comparator));
    }

    /**
     * Returns whether all elements of the given <tt>list</tt> match
     * the provided <tt>predicate</tt>.
     * <p>
     * For intrinsic purposes it uses <tt>threads</tt> of {@link java.lang.Thread}
     * objects. Each of them gets its own part of work to perform the whole work in parallel.
     *
     * @param threads number of <tt>Threads</tt> in which work should be done.
     * @param list <tt>List</tt> of elements to be checked
     * @param predicate a <tt>non-interfering</tt> and <tt>stateless</tt>
     * predicate to be check to each element
     * @param <T> <tt>parent</tt> <tt>generic</tt> type of elements
     * @return <tt>true</tt> if all elements match the given <tt>predicate</tt>,
     * <tt>false</tt> otherwise.
     * @throws InterruptedException if any worker thread was interrupted during its work
     */
    @Override
    public <T> boolean all(int threads, List<? extends T> list, Predicate<? super T> predicate) throws InterruptedException {
        return parallelisation(threads, list, part -> part.stream().allMatch(predicate), results -> results.stream().allMatch(Predicate.isEqual(true)));
    }

    /**
     * Returns whether any element of the given <tt>list</tt> matches
     * the provided <tt>predicate</tt>.
     * <p>
     * For intrinsic purposes it uses <tt>threads</tt> of {@link java.lang.Thread}
     * objects. Each of them gets its own part of work to perform the whole work in parallel.
     *
     * @param threads number of <tt>Threads</tt> in which work should be done.
     * @param list <tt>List</tt> of elements for which <tt>predicate</tt> should be checked
     * @param predicate a <tt>non-interfering</tt> and <tt>stateless</tt>
     * predicate to be checked
     * @param <T> <tt>parent</tt> <tt>generic</tt> type of elements
     * @return <tt>true</tt> if any element of the <tt>list</tt> matches the given <tt>predicate</tt>,
     * <tt>false</tt> otherwise.
     * @throws InterruptedException if any worker thread was interrupted during its work
     */
    @Override
    public <T> boolean any(int threads, List<? extends T> list, Predicate<? super T> predicate) throws InterruptedException {
        return parallelisation(threads, list,
                part -> part.stream().anyMatch(predicate), results -> results.stream().anyMatch(Predicate.isEqual(true)));
    }
}
