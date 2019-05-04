package com.javastudio.tutorial.api;

import com.javastudio.tutorial.dto.OrganizationChartDTO;

public interface OrganizationChartService extends GeneralServiceApi<OrganizationChartDTO> {
    OrganizationChartDTO findByOrganizationDescriptor(String corporateId, String title, String username);
}
