public class MetricDistanceCalculator {
        public enum Unit {
            MM(1),
            CM(10),
            DM(100),
            M(1000),
            KM(1000000);

            private final int scale;

            Unit(int scale) {
                this.scale = scale;
            }

            public double convertToBaseUnit(double value) {
                return value * scale;
            }

            public static Unit fromString(String unit) {
                for (Unit u : Unit.values()) {
                    if (u.name().equalsIgnoreCase(unit)) {
                        return u;
                    }
                }
                throw new IllegalArgumentException("Invalid unit: " + unit);
            }
        }

        public static double calculateDistance(String expression) throws IllegalArgumentException {
            String[] parts = expression.split(" ");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid expression format");
            }

            double value1 = Double.parseDouble(parts[0]);
            Unit unit1 = Unit.fromString(parts[2]);
            double value2 = Double.parseDouble(parts[1]);
            Unit unit2 = Unit.fromString(parts[3]);

            double value1InBaseUnit = unit1.convertToBaseUnit(value1);
            double value2InBaseUnit = unit2.convertToBaseUnit(value2);

            return Math.abs(value1InBaseUnit - value2InBaseUnit);
        }
    }

