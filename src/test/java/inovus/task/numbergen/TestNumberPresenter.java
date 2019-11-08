package inovus.task.numbergen;

import inovus.task.numbergen.service.NumberPresenter;

public class TestNumberPresenter implements NumberPresenter {
    @Override
    public String transform(int number) {
        return String.valueOf(number);
    }
}
