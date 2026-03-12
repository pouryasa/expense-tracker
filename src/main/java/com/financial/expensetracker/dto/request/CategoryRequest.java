package com.financial.expensetracker.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CategoryRequest {

    @NotNull(message = "{category.name.is.empty}")
    @NotBlank(message = "{category.name.is.empty}")
    private String name;


    @NotNull(message = "{category.type.is.empty}")
    @NotBlank(message = "{category.type.is.empty}")
    private String type;
}
