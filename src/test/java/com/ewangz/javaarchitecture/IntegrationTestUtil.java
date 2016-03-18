package com.ewangz.javaarchitecture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by aaronqin on 16/3/18.
 */
public class IntegrationTestUtil {
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

    public static <T> T convertJsonStringToObject(Class<T> clazz, String content) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if (StringUtils.isEmpty(content)) {
            return null;
        }
        return mapper.readValue(content, clazz);
    }
}

