package racingcar;

import java.util.Objects;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int DEFAULT_DISTANCE = 0;
    private static final String DISTANCE_EXPRESSION = "-";
    private final String name;
    private int distanceMovedForward;

    public Car(final String name) {
        validateNameLength(name);
        validateNameOnlyEnglishAndNumber(name);
        this.name = name;
        this.distanceMovedForward = DEFAULT_DISTANCE;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        distanceMovedForward++;
    }

    public int getDistanceMovedForward() {
        return distanceMovedForward;
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 최소 1글자, 최대 5글자입니다");
        }
    }

    private void validateNameOnlyEnglishAndNumber(final String name) {
        for (char c : name.toCharArray()) {
            validateCharOnlyEnglishAndNumber(c);
        }
    }

    private void validateCharOnlyEnglishAndNumber(final char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (Character.isDigit(c))) {
            return;
        }

        throw new IllegalArgumentException("자동차 이름은 영문자와 숫자만 허용합니다");
    }

    @Override
    public String toString() {
        return name + " : " + DISTANCE_EXPRESSION.repeat(distanceMovedForward);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car)) {
            return false;
        }
        Car car = (Car) obj;
        return Objects.equals(name, car.name);
    }
}