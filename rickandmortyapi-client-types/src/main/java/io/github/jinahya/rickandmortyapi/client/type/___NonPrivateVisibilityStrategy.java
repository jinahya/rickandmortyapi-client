package io.github.jinahya.rickandmortyapi.client.type;

import jakarta.json.bind.config.PropertyVisibilityStrategy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ___NonPrivateVisibilityStrategy
        implements PropertyVisibilityStrategy {

    @Override
    public boolean isVisible(final Field field) {
        return !Modifier.isPrivate(field.getModifiers());
    }

    @Override
    public boolean isVisible(final Method method) {
        return !Modifier.isPrivate(method.getModifiers());
    }
}
