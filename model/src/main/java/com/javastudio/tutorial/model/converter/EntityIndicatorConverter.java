package com.javastudio.tutorial.model.converter;

import com.javastudio.tutorial.type.EntityIndicator;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EntityIndicatorConverter implements AttributeConverter<EntityIndicator, String> {

    @Override
    public String convertToDatabaseColumn(EntityIndicator entityIndicator) {
        return entityIndicator.getCode();
    }

    @Override
    public EntityIndicator convertToEntityAttribute(String value) {
        return EntityIndicator.valueOf(value);
    }
}
