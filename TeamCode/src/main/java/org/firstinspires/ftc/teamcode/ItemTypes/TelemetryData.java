package org.firstinspires.ftc.teamcode.ItemTypes;

import java.util.function.Supplier;

public class TelemetryData extends TelemetryItem{


    public TelemetryData(String caption, Supplier<Double> data){
        super(()->caption+data.get());

    }



}
