package TaskPlanner;

import TaskPlanner.Tasks.Priority;
import TaskPlanner.Tasks.PriorityTask;

import java.util.Comparator;

public class PriorityComparator implements Comparator<PriorityTask> {
    @Override
    public int compare(PriorityTask o1, PriorityTask o2) {
        if(o1.getPriority().equals(o2.getPriority())){
            return 0;
        } else if (o1.getPriority().equals(Priority.high) &&
                (o2.getPriority().equals(Priority.medium) || o2.getPriority().equals(Priority.low)))
        {
            return 1;
        }else if (o1.getPriority().equals(Priority.medium) && o2.getPriority().equals(Priority.low))
        {
            return 1;
        } else {
            return -1;
        }
    }
}
