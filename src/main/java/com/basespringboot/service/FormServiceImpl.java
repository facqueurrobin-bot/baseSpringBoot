package com.basespringboot.service;

import com.basespringboot.dto.FormDto;
import com.basespringboot.entity.Form;
import com.basespringboot.repository.FormRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FormServiceImpl implements FormService {

    private final FormRepository formRepository;

    public FormServiceImpl(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    @Override
    public Form save(FormDto formDto) {
        Form form = new Form();
        form.setTitle(formDto.getTitle());
        return formRepository.save(form);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Form> findAll() {
        return formRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Form> findById(Long id) {
        return formRepository.findById(id);
    }

    @Override
    public Optional<Form> update(Long id, FormDto formDto) {
        return formRepository.findById(id).map(existingForm -> {
            existingForm.setTitle(formDto.getTitle());
            return formRepository.save(existingForm);
        });
    }

    @Override
    public boolean deleteById(Long id) {
        if (formRepository.existsById(id)) {
            formRepository.deleteById(id);
            return true;
        }
        return false;
    }
}