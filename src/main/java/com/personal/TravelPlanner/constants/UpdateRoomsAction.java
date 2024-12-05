package com.personal.TravelPlanner.constants;

import lombok.Getter;

@Getter
public enum UpdateRoomsAction {
    ADD("add"),
    DELETE("delete");

    private final String action;

    UpdateRoomsAction(String action) {
        this.action = action;
    }

}
