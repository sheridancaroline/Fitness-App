package Project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecordedSteps {

    private List<StepRecord> stepRecords;

    public RecordedSteps() {
        this.stepRecords = new ArrayList<>();
    }

    public void recordSteps(int steps) {
        StepRecord stepRecord = new StepRecord(steps, LocalDateTime.now());
        stepRecords.add(stepRecord);
    }

    public void displayStepRecords() {
        System.out.println("Step Records:");
        for (StepRecord stepRecord : stepRecords) {
            System.out.println(stepRecord);
        }
    }

    // Inner class to represent a step record
    private static class StepRecord {
        private int steps;
        private LocalDateTime recordTime;

        public StepRecord(int steps, LocalDateTime recordTime) {
            this.steps = steps;
            this.recordTime = recordTime;
        }

        @Override
        public String toString() {
            return "Steps: " + steps + " recorded at " + recordTime;
        }
    }
}
