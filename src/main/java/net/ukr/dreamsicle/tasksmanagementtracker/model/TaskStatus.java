package net.ukr.dreamsicle.tasksmanagementtracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TaskStatus {
    TO_DO("TO DO"),
    IN_PROGRESS("IN PROGRESS"),
    DONE("DONE");

    @Getter
    private String name;

    public static TaskStatus getEnumFromString(String stringValue) {
        if (stringValue != null) {
            try {
                return Enum.valueOf(TaskStatus.class, stringValue.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Enum is allow. Please choose the next items: "
                        + TaskStatus.TO_DO + "; "
                        + TaskStatus.IN_PROGRESS + "; "
                        + TaskStatus.DONE);
            }
        }
        return null;
    }
}
