package com.tut.repository;

import com.tut.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Custom query methods (if required)

    /**
     * Find all tasks with a specific status.
     *
     * @param status The status of the tasks to retrieve (e.g., PENDING or COMPLETED).
     * @return A list of tasks matching the specified status.
     */
    List<Task> findByStatus(String status);

    /**
     * Find all tasks ordered by their due date.
     *
     * @return A list of tasks sorted by due date.
     */
    List<Task> findAllByOrderByDueDateAsc();

    /**
     * Find tasks with a specific priority.
     *
     * @param priority The priority level (e.g., HIGH, MEDIUM, LOW).
     * @return A list of tasks with the specified priority.
     */
    List<Task> findByPriority(String priority);

    /**
     * Find tasks where the due date is before a given date.
     *
     * @param dueDate The date to compare.
     * @return A list of tasks due before the given date.
     */
    List<Task> findByDueDateBefore(java.util.Date dueDate);
}
