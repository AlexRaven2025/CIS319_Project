/*
 * Name: Alex Amador
 * Date: 20 APR 24
 * Descrption: Project week 3 
 */

import java.sql.Date;

class Task {
    private String description;
    private Date deadline;
    private String category;
    private boolean completed;

    public Task(String description, Date deadline, String category, boolean completed) {
        this.description = description;
        this.deadline = deadline;
        this.category = category;
        this.completed = completed;
    }

    // Getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", deadline=" + deadline +
                ", category='" + category + '\'' +
                ", completed=" + completed +
                '}';
    }
}
