package ru.devray;

public class Vault {
    private int dollars;
    private int euros;
    private double tonsOfGold;
    private String pentagonNukesCodes;

    private Vault(int dollars, int euros, double tonsOfGold, String pentagonNukesCodes) {
        this.dollars = dollars;
        this.euros = euros;
        this.tonsOfGold = tonsOfGold;
        this.pentagonNukesCodes = pentagonNukesCodes;
    }

    public Vault() {
        this.dollars = 1_000_000;
        this.euros = 300_000;
        this.tonsOfGold = 21.5;
        this.pentagonNukesCodes = "qwerty";
    }

    private int getDollars() {
        return dollars;
    }

    private void setDollars(int dollars) {
        this.dollars = dollars;
    }

    private int getEuros() {
        return euros;
    }

    private void setEuros(int euros) {
        this.euros = euros;
    }

    private double getTonsOfGold() {
        return tonsOfGold;
    }

    private void setTonsOfGold(double tonsOfGold) {
        this.tonsOfGold = tonsOfGold;
    }

    private String getPentagonNukesCodes() {
        return pentagonNukesCodes;
    }

    private void setPentagonNukesCodes(String pentagonNukesCodes) {
        this.pentagonNukesCodes = pentagonNukesCodes;
    }
}
