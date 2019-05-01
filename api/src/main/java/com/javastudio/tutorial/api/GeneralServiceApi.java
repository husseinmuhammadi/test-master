package com.javastudio.tutorial.api;

import com.javastudio.tutorial.dto.DTOBase;

import java.util.List;

public interface GeneralServiceApi<T extends DTOBase> {
    T create(T t);

    List<T> findAll();

    T find(Long id);

    void update(T t);

    void delete(T t);
}
