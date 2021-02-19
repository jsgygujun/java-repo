package com.java.repo.recsys.core.recall;

import com.java.repo.recsys.core.bean.RecContext;
import com.java.repo.recsys.core.bean.RecItem;
import com.java.repo.recsys.core.fetch.AbstractFetch;
import com.java.repo.recsys.core.filter.AbstractFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author GuJun
 * @date 2021/2/7
 */
public abstract class AbstractRecall {

    private final ExecutorService THREAD_POOL;

    public AbstractRecall(ExecutorService threadPool) {
        this.THREAD_POOL = threadPool;
    }

    private final List<AbstractFetch> FETCH_CONTAINER = new ArrayList<>();
    private final List<AbstractFilter> FILTER_CONTAINER = new ArrayList<>();


    protected abstract Map<String, Double> getTriggers(RecContext recContext) throws RuntimeException;

    public void addFetch(AbstractFetch fetch) {
        FETCH_CONTAINER.add(fetch);
    }

    public void addFilter(AbstractFilter filter) {
        FILTER_CONTAINER.add(filter);
    }

    public List<RecItem> recall(RecContext recContext, long timeout, TimeUnit timeUnit) throws Exception {
        final List<RecItem> recItems = new ArrayList<>();
        Map<String, Double> weightedTriggers = getTriggers(recContext);
        CompletionService<List<RecItem>> completionService = new ExecutorCompletionService<>(THREAD_POOL);
        for (AbstractFetch fetch : FETCH_CONTAINER) {
            completionService.submit(new FetchTask(recContext, fetch, new ArrayList<>(weightedTriggers.keySet())));
        }
        IntStream.range(0, FETCH_CONTAINER.size()).forEach((n) -> {
            try {
                recItems.addAll(completionService.take().get(timeout, timeUnit));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return recItems;
    }

    @Data
    @AllArgsConstructor
    private static class FetchTask implements Callable<List<RecItem>> {
        private RecContext recContext;
        private AbstractFetch fetch;
        private List<String> triggers;

        @Override
        public List<RecItem> call() throws Exception {
            try {
                return fetch.fetch(recContext, triggers);
            } catch (Exception e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
        }
    }

}
