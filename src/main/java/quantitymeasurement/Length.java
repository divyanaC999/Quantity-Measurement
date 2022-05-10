package quantitymeasurement;

public class Length {

	private final Unit unit;
	private final double value;
	private static final double Feet_To_Inch = 12;
	private static final double Yard_To_Feet = 3;
	private static final double Yard_To_Inch = 36;

	enum Unit {
		FEET, INCH, YARD
	};

	public Length(Unit unit, double value) {
		this.unit = unit;
		this.value = value;
	}

	public boolean compare(Length that) {
		if (this.unit.equals(that.unit))
			return this.equals(that);
		if (this.unit.equals(Unit.FEET) & that.unit.equals(Unit.INCH))
			return Double.compare(this.value * Feet_To_Inch, that.value) == 0;
		if (this.unit.equals(Unit.INCH) && that.unit.equals(Unit.FEET))
			return Double.compare(this.value, that.value * Feet_To_Inch) == 0;
		if (this.unit.equals(Unit.FEET) && that.unit.equals(Unit.YARD))
			return Double.compare(this.value, that.value * Yard_To_Feet) == 0;
		if (this.unit.equals(Unit.YARD) && that.unit.equals(Unit.FEET))
			return Double.compare(this.value * Yard_To_Feet, that.value) == 0;
		if (this.unit.equals(Unit.INCH) && that.unit.equals(Unit.YARD))
			return Double.compare(this.value, that.value * Yard_To_Inch) == 0;
		if (this.unit.equals(Unit.YARD) && that.unit.equals(Unit.INCH))
			return Double.compare(this.value * Yard_To_Inch, that.value) == 0;
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Length length = (Length) o;
		return Double.compare(length.value, value) == 0 && unit == length.unit;
	}
}