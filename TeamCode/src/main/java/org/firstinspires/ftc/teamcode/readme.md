## Installation
Just copy the files in Teamcode over to your code

## Telemetry Manager Instructions

Use TelemetryManager.getInstance().print to add all the telemetry for a single loop. 
At the end of every loop, call TelemetryManager.getInstance().resetTempTelemetry

If you want to add telemetry, you only have to create a new TelemetryItem or TelemetryData object.
The TelemetryManager will remember these, unless you remove them through TelemetryItem.remove().
This is good if you want telemetry 
If you want to add telemetry in a piece of code that runs in a loop, use 
TelemetryManager.getInstance.addTempTelemetry()

You can add more types of Telemetry Items if you need them.
