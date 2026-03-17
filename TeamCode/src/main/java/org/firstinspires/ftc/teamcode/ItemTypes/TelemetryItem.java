package org.firstinspires.ftc.teamcode.ItemTypes;

import org.firstinspires.ftc.teamcode.TelemetryManager;

import java.util.ArrayList;
import java.util.function.Supplier;

public class TelemetryItem {
    protected Supplier<String> item;
    protected ArrayList<String> tags;

    public TelemetryItem(Supplier<String> item){
        this.item = item;
        tags =new ArrayList<String>();
        TelemetryManager.getInstance().addTelemetryItem(this);
    }
    public void addTag(String tag){
        tags.add(tag);
    }
    public String getItem(){
        return item.get();
    }
    public ArrayList<String> getTags(){
        return tags;
    }

    public void remove(){
        TelemetryManager.getInstance().removeTelemetryItem(this);
    }
}
