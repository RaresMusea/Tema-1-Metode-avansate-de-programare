package com.tema1MAP.ex8;

//Clasa ComplexNumber, modeleaza functionalitatea unui numar complex de forma a+bi, necesar computatiei ecuatiilor de grad 2 in momentul in care discriminantul are o valoare negativa.
public class ComplexNumber {

    protected double real;  //partea reala
    protected double imaginary; //partea imaginara

    public ComplexNumber() {
        real = 0.0;
        imaginary = 0.0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    //Verifica egalitatea a doua numere complexe
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplexNumber that)) return false;
        return Double.compare(that.getReal(), getReal()) == 0 && Double.compare(that.getImaginary(), getImaginary()) == 0;
    }

    //Override pe toString(), permite afisarea numarului complex sub forma matematica
    @Override
    public String toString() {
        if (getReal() == 0)
            return getImaginary() == 0 ? ("0") : (getImaginary() + "i");
        return getImaginary() == 0 ? ("" + getReal()) : ("" + getReal() +(getImaginary()>0?" + ":" - ")+ Math.abs(getImaginary())+"i");
    }
}

