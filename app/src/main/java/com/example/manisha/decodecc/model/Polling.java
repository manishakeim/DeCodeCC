package com.example.manisha.decodecc.model;

public class Polling {
    private String EPIC;
    private Integer pollingStationID;
    private PollingStation pollingStation;

    public Polling(String EPIC, Integer pollingStationID)
    {
        this.EPIC = EPIC;
        this.pollingStationID = pollingStationID;
    }

    public String getEPIC() {
        return EPIC;
    }

    public void setEPIC(String EPIC) {
        this.EPIC = EPIC;
    }

    public Integer getPollingStationID() {
        return pollingStationID;
    }

    public void setPollingStationID(Integer pollingStationID) {
        this.pollingStationID = pollingStationID;
    }

    public PollingStation getPollingStation() {
        return pollingStation;
    }

    public void setPollingStation(PollingStation pollingStation) {
        this.pollingStation = pollingStation;
    }
}
