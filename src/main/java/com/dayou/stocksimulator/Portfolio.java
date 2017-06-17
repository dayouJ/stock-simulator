package com.dayou.stocksimulator;

/**
 * Created by djiang on 6/17/17.
 */
public class Portfolio {
    private String name;
    private double initialMoney;
    private double annualReturn;
    private double risk;
    private int period;

    public Portfolio(String name, double initialMoney, double annualReturn, double risk, int period) {
        this.name=name;
        this.initialMoney=initialMoney;
        this.annualReturn=annualReturn;
        this.risk=risk;
        this.period=period;
    }

    public double getInitialMoney() { return initialMoney; }

    public int getPeriod() { return period; }

    public double getAnnualReturn() { return annualReturn; }

    public double getRisk() { return risk; }

    @Override
    public String toString() {
        return "Portfolio [name=" + name + ", initialMoney="
                + initialMoney + ", return=" + annualReturn + ", risk="
                + risk + ", Period=" + period + "]";
    }

}
