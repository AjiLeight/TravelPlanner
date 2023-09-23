package com.personal.TravelPlanner.constants;

public enum UpdateRoomsAction {
    ADD("add"),
    DELETE("delete");

    private final String action;

    UpdateRoomsAction(String action) {
        this.action = action;
    }

    public String getAction(){
        return action;
    }
}
