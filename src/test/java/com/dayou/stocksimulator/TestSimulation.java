package com.dayou.stocksimulator;

import org.junit.Test;
/**
 * Created by djiang on 6/17/17.
 */
public class TestSimulation {
    @Test
    public void testSimulation(){
        Portfolio aggressive = new Portfolio("Aggressive", 100000, 0.094324, 0.15675, 20);
        Portfolio conservative = new Portfolio("Conservative", 100000, 0.06189, 0.063438, 20);

        StockSimulator stockSimulator = new StockSimulator(aggressive, 0.035, 10000);
        stockSimulator.simulate();
        stockSimulator.printSimulationResult();

        stockSimulator = new StockSimulator(conservative, 0.035, 10000);
        stockSimulator.simulate();
        stockSimulator.printSimulationResult();
    }
}
