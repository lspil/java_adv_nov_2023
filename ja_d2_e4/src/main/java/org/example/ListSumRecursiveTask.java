package org.example;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ListSumRecursiveTask extends RecursiveTask<Integer> {

    private final List<Integer> list;

    public ListSumRecursiveTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        if (list.size() <= 3) {
            return list.stream().mapToInt(n -> n).sum();
        }

        int mid = list.size() / 2;
        var list1 = list.subList(0, mid);
        var list2 = list.subList(mid, list.size());

        ListSumRecursiveTask t1 = new ListSumRecursiveTask(list1);
        ListSumRecursiveTask t2 = new ListSumRecursiveTask(list2);

        t1.fork(); // porneste pe un alt thread
//        t2.fork();

        return t2.compute() + t1.join();
    }
}
