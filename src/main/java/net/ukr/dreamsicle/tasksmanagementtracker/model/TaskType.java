package net.ukr.dreamsicle.tasksmanagementtracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TaskType {
    BUG("bug"),
    EPIC("epic"),
    STORY("story"),
    TASK("task");


    @Getter
    private String name;

    public static TaskType getEnumFromString(String stringValue) {
        if (stringValue != null) {
            try {
                return Enum.valueOf(TaskType.class, stringValue.trim().toUpperCase());
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Enum is allow. Please choose the next items: "
                        + TaskType.BUG + "; "
                        + TaskType.EPIC + "; "
                        + TaskType.STORY + "; "
                        + TaskType.TASK);
            }
        }
        return null;
    }
}
