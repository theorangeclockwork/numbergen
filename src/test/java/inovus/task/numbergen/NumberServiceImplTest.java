package inovus.task.numbergen;

import inovus.task.numbergen.service.NumberPresenter;
import inovus.task.numbergen.service.NumberService;
import inovus.task.numbergen.service.impl.NumberServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberServiceImplTest {

    private NumberPresenter numberPresenter = new TestNumberPresenter();
    private NumberService numberService = new NumberServiceImpl(numberPresenter, 1728000);

    @Test
    public void testRandom() {
        numberService.getRandomAlphanumeric();
    }

    @Test
    public void testNext() {
        String nextAlphanumeric = numberService.getNextAlphanumeric();
        assertEquals("1", nextAlphanumeric);
    }

    @Test
    public void testNextAfterRandom() {
        String randomAlphanumeric = numberService.getRandomAlphanumeric();

        String nextAlphanumeric = numberService.getNextAlphanumeric();
        assertEquals(String.valueOf(Integer.parseInt(randomAlphanumeric) + 1), nextAlphanumeric);
    }

}