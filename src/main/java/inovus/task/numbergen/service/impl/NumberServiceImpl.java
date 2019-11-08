package inovus.task.numbergen.service.impl;

import inovus.task.numbergen.service.NumberPresenter;
import inovus.task.numbergen.service.NumberService;

import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberServiceImpl implements NumberService {
    private int currentId;
    private LinkedList<Integer> unusedNumbers;

    private final NumberPresenter presenter;

    public NumberServiceImpl(final NumberPresenter presenter, final int rangeLimit) {
        this.presenter = presenter;

        unusedNumbers = IntStream.range(0, rangeLimit).boxed().collect(Collectors.toCollection(LinkedList::new));
        Collections.shuffle(unusedNumbers);
    }

    @Override
    public synchronized String getRandomAlphanumeric() {
        currentId = unusedNumbers.removeLast();
        return presenter.transform(currentId);
    }

    @Override
    public synchronized String getNextAlphanumeric() {
        unusedNumbers.remove(currentId);
        currentId++;
        return presenter.transform(currentId);
    }
}
