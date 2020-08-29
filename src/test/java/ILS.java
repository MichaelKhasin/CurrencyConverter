import java.io.Serializable;

class ILS extends Coin implements Serializable {
    private final double value = 0.28;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double input) {
        return input * getValue();
    }
}
