package inovus.task.numbergen.service.impl;

import inovus.task.numbergen.service.NumberPresenter;
import inovus.task.numbergen.util.Util;
import org.springframework.stereotype.Component;

@Component
public class NumberPresenterImpl implements NumberPresenter {

    @Override
    public String transform(int number) {
        return Util.getAlphanumericCode(number);
    }
}
