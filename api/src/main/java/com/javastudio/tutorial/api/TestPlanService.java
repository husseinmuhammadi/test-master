package com.javastudio.tutorial.api;

import com.javastudio.tutorial.dto.Issue;
import com.javastudio.tutorial.dto.TestPlan;

import java.util.List;

public interface TestPlanService extends GeneralServiceApi<TestPlan> {
    List<TestPlan> findByIssueNo(Issue issue);
}
