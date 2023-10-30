package racingcar.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import racingcar.exception.CarNameDuplicateException;
import racingcar.exception.CarNameInvalidException;
import racingcar.exception.NumberOfCarInvalidException;
import racingcar.exception.TrialNumberInvalidException;

public class DataValidator {

    private static final int MAX_LENGTH = 5;
    private static final String TRIAL_NUMBER_RANGE = "^[0-9]*$";

    private static final String NONE_TRY = "0";

    private static final int MIN_CAR_NUMBER = 1;

    public void validateCarName(String[] carNames) {
        for (String car : carNames) {
            validateCarName(car);
        }
        validateDuplicatedCars(carNames);
        validateInputCarsIsOne(carNames);
    }

    public void validateTrialNumber(String trialNumber) {
        if (!Pattern.matches(TRIAL_NUMBER_RANGE, trialNumber)) {
            throw new TrialNumberInvalidException();
        }
        if (trialNumber.equals(NONE_TRY)) {
            throw new TrialNumberInvalidException();
        }
    }

    private void validateCarName(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new CarNameInvalidException();
        }
    }

    private void validateDuplicatedCars(String[] carNames) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, carNames);

        if (set.size() != carNames.length) {
            throw new CarNameDuplicateException();
        }
    }

    private void validateInputCarsIsOne(String[] carNames) {
        if (carNames.length == MIN_CAR_NUMBER) {
            throw new NumberOfCarInvalidException();
        }
    }
}
