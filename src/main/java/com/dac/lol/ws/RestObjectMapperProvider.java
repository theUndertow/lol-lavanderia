/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dac.lol.ws;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author marco
 */
@Provider
public class RestObjectMapperProvider implements ContextResolver<ObjectMapper> {

    final ObjectMapper defaultObjectMapper;
    final ObjectMapper combinedObjectMapper;

    public RestObjectMapperProvider() {
        defaultObjectMapper = createDefaultMapper();
        combinedObjectMapper = createCombinedObjectMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {

        if (type == SaveOrder.class) {
            return combinedObjectMapper;
        } else {
            return defaultObjectMapper;
        }
    }

    private static ObjectMapper createCombinedObjectMapper() {

        AnnotationIntrospector ai = new AnnotationIntrospectorPair(
                new JaxbAnnotationIntrospector(),
                new JacksonAnnotationIntrospector()
        );
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        mapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        mapper.setAnnotationIntrospector(ai);

        return mapper;
    }

    private static ObjectMapper createDefaultMapper() {

        ObjectMapper result = new ObjectMapper();

        return result;
    }
}
