package com.javastudio.tutorial.api;

import com.javastudio.tutorial.dto.OrganizationChart;

public interface OrganizationChartService extends GeneralServiceApi<OrganizationChart> {
    OrganizationChart findByOrganizationDescriptor(String corporateId, String title, String username);
}
