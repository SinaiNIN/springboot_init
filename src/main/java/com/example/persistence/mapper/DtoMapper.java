package com.example.persistence.mapper;

public interface DtoMapper <Input, Output>{
    Output toEntity(Input input);
    Input toDto(Output output);
}
