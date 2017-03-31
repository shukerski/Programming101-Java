package com.week02.tuesday;

public class Polynomial {

	private int[] coefficients;
	private int degree;

	public Polynomial(int a, int b) {
		coefficients = new int[b + 1];
		coefficients[b] = a;
		degree = degree();
	}

	public int degree() {
		int result = 0;
		for (int i = 0; i < coefficients.length; i++) {
			if (coefficients[i] != 0) {
				result = i;
			}
		}
		return result;
	}

	public Polynomial plus(Polynomial b) {
		Polynomial result = new Polynomial(0, Math.max(this.degree, b.degree));
		for (int i = 0; i <= this.degree; i++) {
			result.coefficients[i] += this.coefficients[i];
		}
		for (int i = 0; i <= b.degree; i++) {
			result.coefficients[i] += b.coefficients[i];
		}
		result.degree = result.degree();
		return result;
	}

	public Polynomial minus(Polynomial b) {
		Polynomial result = new Polynomial(0, Math.max(this.degree, b.degree));
		for (int i = 0; i <= this.degree; i++) {
			result.coefficients[i] += this.coefficients[i];
		}
		for (int i = 0; i <= b.degree; i++) {
			result.coefficients[i] -= b.coefficients[i];
		}
		result.degree = result.degree();
		return result;
	}

	public Polynomial miltiplication(Polynomial b) {
		Polynomial result = new Polynomial(0, this.degree + b.degree);
		for (int i = 0; i <= this.degree; i++) {
			for (int j = 0; j <= b.degree; j++) {
				result.coefficients[i + j] += (this.coefficients[i] * b.coefficients[j]);
			}
		}
		result.degree = result.degree();
		return result;
	}

	public int evaluate(int x) {
		int p = 0;
		for (int i = degree; i >= 0; i--) {
			p = coefficients[i] + (x * p);
		}
		return p;
	}

	public Polynomial differentiate() {
		if (degree == 0) {
			return new Polynomial(0, 0);
		}
		Polynomial derivative = new Polynomial(0, degree - 1);
		derivative.degree = degree - 1;
		for (int i = 0; i < degree; i++)
			derivative.coefficients[i] = (i + 1) * coefficients[i + 1];
		return derivative;
	}

	@Override
	public String toString() {
		if (degree == 0) {
			return "" + coefficients[0];
		}
		if (degree == 1) {
			return coefficients[1] + "x + " + coefficients[0];
		}
		String result = coefficients[degree] + "x^" + degree;
		for (int i = degree - 1; i >= 0; i--) {
			if (coefficients[i] == 0) {
				continue;
			} else if (coefficients[i] > 0) {
				result = result + " + " + (coefficients[i]);
			} else if (coefficients[i] < 0) {
				result = result + " - " + (-coefficients[i]);
			}
			if (i == 1) {
				result = result + "x";
			} else if (i > 1) {
				result = result + "x^" + i;
			}
		}
		return result;
	}

}
