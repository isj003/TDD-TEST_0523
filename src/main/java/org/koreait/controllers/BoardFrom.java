package org.koreait.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BoardFrom {
    private long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;

}
