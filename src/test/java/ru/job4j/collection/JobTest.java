package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    private List<Job> createInitialJobs() {
        return new ArrayList<>(Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Reboot server", 1),
                new Job("Add feature", 0),
                new Job("Fix bug", 2)
        ));
    }

    @Test
    void whenAscByName() {
        List<Job> jobs = createInitialJobs();
        List<Job> expected = Arrays.asList(
                new Job("Add feature", 0),
                new Job("Fix bug", 1),
                new Job("Fix bug", 2),
                new Job("Impl task", 0),
                new Job("Reboot server", 1)
        );
        Collections.sort(jobs, new JobAscByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenDescByName() {
        List<Job> jobs = createInitialJobs();
        List<Job> expected = Arrays.asList(
                new Job("Reboot server", 1),
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Fix bug", 2),
                new Job("Add feature", 0)
        );
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenAscByPriority() {
        List<Job> jobs = createInitialJobs();
        List<Job> expected = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Add feature", 0),
                new Job("Fix bug", 1),
                new Job("Reboot server", 1),
                new Job("Fix bug", 2)
        );
        Collections.sort(jobs, new JobAscByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenDescByPriority() {
        List<Job> jobs = createInitialJobs();
        List<Job> expected = Arrays.asList(
                new Job("Fix bug", 2),
                new Job("Impl task", 0),
                new Job("Add feature", 0),
                new Job("Fix bug", 1),
                new Job("Reboot server", 1)
        );
        Collections.sort(jobs, new JobDescByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenComparatorByNameDescAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenComparatorByNameAscAndPriorityAsc() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmp.compare(
                new Job("Fix bug", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenComparatorByNameAscAndPriorityDesc() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobDescByPriority());
        List<Job> jobs = createInitialJobs();
        Collections.sort(jobs, cmp);

        List<Job> expected = Arrays.asList(
                new Job("Add feature", 0),
                new Job("Fix bug", 2),
                new Job("Fix bug", 1),
                new Job("Impl task", 0),
                new Job("Reboot server", 1)
        );
        assertThat(jobs).isEqualTo(expected);
    }
}