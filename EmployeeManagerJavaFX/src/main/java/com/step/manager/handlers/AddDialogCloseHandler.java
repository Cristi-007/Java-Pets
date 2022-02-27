package com.step.manager.handlers;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class AddDialogCloseHandler implements EventHandler<WindowEvent> {
    @Override
    public void handle(WindowEvent event) {
        System.out.println("Are you sure?");
    }
}
