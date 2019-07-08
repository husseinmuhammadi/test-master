package com.javastudio.lms.tutorial.web.controller.base;

import com.javastudio.tutorial.dto.DTOBase;

public interface Lookup<T extends DTOBase> {
    void select(T entity);
}
