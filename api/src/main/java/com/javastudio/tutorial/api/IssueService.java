package com.javastudio.tutorial.api;

import com.javastudio.tutorial.dto.Issue;

public interface IssueService extends GeneralServiceApi<Issue> {
    Issue findByIssueNo(Long issueNo);
}
