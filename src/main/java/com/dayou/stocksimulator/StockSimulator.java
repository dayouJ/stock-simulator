package com.dayou.stocksimulator;

/**
 * Created by djiang on 6/17/17.
 */
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class StockSimulator {
    private Portfolio portfolio;
    private double inflation;
    private long simulations;

    private Simulator simulator;

    public StockSimulator(Portfolio portfolio, double inflation, long simulations) {
        this.portfolio = portfolio;
        this.inflation = inflation;
        this.simulations = simulations;
        simulator = new Simulator(portfolio.getAnnualReturn(), portfolio.getRisk());
    }

    public void simulate() {
        for (int i = 0; i < simulations; i++) {
            double simResult=portfolio.getInitialMoney();
            for(int n=0;n<portfolio.getPeriod();n++){
                double r = simulator.nextSampleReturn();
                simResult = (1+r-inflation)*simResult;
            }
            simulator.saveSimulationResult(simResult);
        }
    }

    private class Simulator{
        private NormalDistribution normalDistribution;
        private DescriptiveStatistics stats;

        public Simulator(double mean, double standardDeviation) {

            this.normalDistribution = new NormalDistribution(mean, standardDeviation);
            this.stats = new DescriptiveStatistics();
        }

        public void saveSimulationResult(double simResult) {
            this.stats.addValue(simResult);
        }

        public double nextSampleReturn() {
            return this.normalDistribution.sample();
        }

        public double getPercentile(double n){
            return this.stats.getPercentile(n);
        }
    }

    public void printSimulationResult(){
        System.out.println("Simulated " + portfolio + " " + simulations + " times with " + inflation + " inflation get returns: \n"
                + "Median=" + simulator.getPercentile(50) + "\n"
                + "10% Best=" + simulator.getPercentile(90) + "\n"
                + "10% Worst=" + simulator.getPercentile(10));
    }
}