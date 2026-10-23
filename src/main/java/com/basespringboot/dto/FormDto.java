package com.basespringboot.dto;

import jakarta.validation.constraints.NotBlank;

public class FormDto {

    @NotBlank(message = "Le titre ne doit pas être vide")
    private String title;

    public FormDto() {
    }

    public FormDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}