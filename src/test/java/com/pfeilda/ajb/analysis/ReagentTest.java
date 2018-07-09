package com.pfeilda.ajb.analysis;

import com.pfeilda.ajb.miscellaneous.Pressure;
import com.pfeilda.ajb.miscellaneous.Temperature;
import com.pfeilda.ajb.miscellaneous.TestInterface;
import com.pfeilda.ajb.miscellaneous.Volume;
import org.junit.Assert;
import org.junit.Test;

public class ReagentTest extends AbstractSubstanceTest implements TestInterface {
    @Override
    public Reagent generateInstanceOfTestClass() {
        return new Reagent(this.elements);
    }

    @Override
    @Test
    public void creation() {
        final Reagent reagent = this.generateInstanceOfTestClass();
        Assert.assertNotNull(reagent);
        Assert.assertEquals(new Volume(this.elements.length * this.volumePerElement), reagent.getVolume());
        Assert.assertEquals(new Pressure(0), reagent.getPressure());
        Assert.assertEquals(new Temperature(0), reagent.getTemperature());
        Assert.assertEquals(true, reagent.isValid());
    }

    @Override
    public void getPressureAfterAlter() {

    }

    @Override
    public void getTemperatureAfterAlter() {

    }
}
