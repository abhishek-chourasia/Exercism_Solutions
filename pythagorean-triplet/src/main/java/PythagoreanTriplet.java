import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class PythagoreanTriplet {
    private final int a, b, c;
    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public static TripletListBuilder makeTripletsList() {
        return new TripletListBuilder();
    }
    public static class TripletListBuilder {
        private int maxValue, sum;
        public TripletListBuilder withFactorsLessThanOrEqualTo(int maxValue) {
            this.maxValue = maxValue;
            return this;
        }
        public TripletListBuilder thatSumTo(int sum) {
            this.sum = sum;
            return this;
        }
        public List<PythagoreanTriplet> build() {
            List<PythagoreanTriplet> results = new ArrayList<>();
            for (int a = 1; a <= maxValue; a++) {
                for (int b = 1; b <= maxValue; b++) {
                    int c = sum - a - b;
                    if (a * a + b * b == c * c && a < b) results.add(new PythagoreanTriplet(a, b, c));
                }
            }
            return results;
        }
    }
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PythagoreanTriplet that = (PythagoreanTriplet) o;
        return a == that.a && b == that.b && c == that.c;
    }
    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }
}
