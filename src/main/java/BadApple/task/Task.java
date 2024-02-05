package BadApple.task;

import static java.lang.Integer.parseInt;

public class Task {

    protected String description;
    protected boolean isComplete = false;

    public Task(String desc) {
        this.description = desc;
    }

    public void mark(boolean b, int taskIndex) {
        String MARK = b ? "marked" : "unmarked"; //use enums if more needed
        if (TaskList.tasks.isEmpty()) {
            System.out.println("There's nothing to mark, Yay!");
            return;
        }
        try {
            if (taskIndex > TaskList.tasks.size() || taskIndex < 0) {
                System.out.println("You don't have that task silly!");
                return;
            }
            this.isComplete = b;
            if (!Tracker.suppressMessages) {
                System.out.println("I've " + MARK + " task " + (taskIndex+1));
                System.out.println(this);
            }
        } catch(NumberFormatException | IndexOutOfBoundsException  e) {
            System.out.println("Usage: mark <taskNumber>");
        }
    }
    @Override
    public String toString() {
        String completion = isComplete ? "[X]" : "[]";
        return completion + " " + description;
    }

    public String brief() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Task) {
            Task task = (Task) o;
            return task.description.equals(this.description);
        }

        return false;
    }
}
