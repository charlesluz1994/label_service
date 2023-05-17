package com.cluz.coscus.label.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.http.ResponseEntity;

public class ResponseEntityRedisSerializer implements RedisSerializer<ResponseEntity<?>> {

    private final ObjectMapper mapper;

    public ResponseEntityRedisSerializer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public byte[] serialize(ResponseEntity<?> responseEntity) throws SerializationException {
        try {
            return mapper.writeValueAsBytes(responseEntity);
        } catch (Exception e) {
            throw new SerializationException("Error serializing ResponseEntity", e);
        }
    }

    @Override
    public ResponseEntity<?> deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null) {
            return null;
        }
        try {
            return mapper.readValue(bytes, ResponseEntity.class);
        } catch (Exception e) {
            throw new SerializationException("Error deserializing ResponseEntity", e);
        }
    }
}