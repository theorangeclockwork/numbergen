package inovus.task.numbergen;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class NumberService {

    private final static String letters = "АВЕКМНОРСТУХ";
    private final static String regionalCode = "116 RUS";
    private int currentId;

    private LinkedList<Integer> unusedNumbers;

    public String getRandomAlphanumeric() {
        currentId = unusedNumbers.removeLast();
        System.out.println(unusedNumbers.size());
        return getAlphanumericCode(currentId);
    }

    public String getNextAlphanumeric() {
        unusedNumbers.remove(currentId);
        currentId++;
        System.out.println(unusedNumbers.size());
        return getAlphanumericCode(currentId);
    }

    private String getAlphanumericCode(int id) {
        StringBuilder letterCode = new StringBuilder(getLetterCode(id));
        StringBuilder numericCode = new StringBuilder(String.valueOf(id % 1000));
        while (numericCode.length() < 3) {
            numericCode.insert(0, '0');
        }
        letterCode.insert(1, numericCode);
        letterCode.append(" " + regionalCode);
        return String.valueOf(letterCode);
    }

    //Получить последовательность букв автомобильного номера в соответствии с его порядковым номером id
    private String getLetterCode(int id) {
        StringBuilder code = new StringBuilder(Util.convertDecimalToBase(id / 1000, letters));
        while (code.length() < 3) {
            code.insert(0, 'A');
        }
        return String.valueOf(code);
    }

    NumberService() {
        unusedNumbers = IntStream.range(0, 1728000).boxed().collect(Collectors.toCollection(LinkedList::new));
        Collections.shuffle(unusedNumbers);
        System.out.println("shuffled");
    }
}
