package com.basespringboot.service;

import com.basespringboot.dto.FormDto;
import com.basespringboot.entity.Form;

import java.util.List;
import java.util.Optional;

public interface FormService {
    Form save(FormDto form);
    List<Form> findAll();
    Optional<Form> findById(Long id);
    Optional<Form> update(Long id, FormDto form);
    boolean deleteById(Long id);
}