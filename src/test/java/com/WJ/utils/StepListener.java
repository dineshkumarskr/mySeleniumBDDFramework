package com.WJ.utils;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

public class StepListener implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {

        publisher.registerHandlerFor(TestStepStarted.class, event -> {

            if (event.getTestStep() instanceof PickleStepTestStep) {
            	PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();
                String stepText =
                        step.getStep().getKeyword() + step.getStep().getText();

                if(ExtentTestManager.getTest()!=null) {
                	ExtentTestManager.getTest().info(stepText);
                }
            }
        });
    }

}
