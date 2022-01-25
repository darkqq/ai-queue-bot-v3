package com.ai.queue.sec.handler;

import com.ai.queue.sec.annotation.SecuredRestController;
import com.ai.queue.sec.annotation.Secured;
import com.ai.queue.sec.cipher.EncryptionService;
import com.ai.queue.sec.temp.WrapperModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice(annotations = SecuredRestController.class)
@RequiredArgsConstructor
public class ResponseWrapperAdvice implements ResponseBodyAdvice<Object> {
    private final EncryptionService encryptionService;

    @Override
    public boolean supports(MethodParameter returnType, @NonNull Class converterType) {
        for (Annotation a : returnType.getMethodAnnotations()) {
            if (a.annotationType() == Secured.class) {
                return true;
            }
        }
        return false;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(
            @Nullable Object body,
            @NonNull MethodParameter returnType,
            @NonNull MediaType selectedContentType,
            @NonNull Class selectedConverterType,
            @NonNull ServerHttpRequest request,
            @NonNull ServerHttpResponse response
    ) {
        if (body == null) {
            return null;
        }
        Class<? extends WrapperModel> wrapperClass = null;
        for (Annotation annotation : returnType.getContainingClass().getAnnotations()) {
            if (annotation.annotationType() == SecuredRestController.class) {
                wrapperClass = ((SecuredRestController) annotation).wrapper();
                break;
            }
        }

        if (wrapperClass == null) {
            return body;
        }
        if (Collection.class.isAssignableFrom(body.getClass())) {
            try {
                Collection<?> bodyCollection = (Collection<?>) body;
                if (bodyCollection.isEmpty()) {
                    return body;
                }
                return generateListOfResponseWrapper(bodyCollection, wrapperClass);
            } catch (Exception e) {
                return body;
            }
        }

        return generateResponseWrapper(body, wrapperClass);
    }

    private List<WrapperModel> generateListOfResponseWrapper(Collection<?> bodyCollection, Class<? extends WrapperModel> wrapperClass) {
        return bodyCollection.stream()
                .map((t) -> t == null ?
                        null :
                        generateResponseWrapper(t, wrapperClass)
                )
                .collect(Collectors.toList());
    }

    @SneakyThrows
    private WrapperModel generateResponseWrapper(Object body, Class<? extends WrapperModel> wrapperClass) {
        WrapperModel wrapper = wrapperClass.getDeclaredConstructor().newInstance();
        wrapper.setData(encryptionService.encrypt(body));
        return wrapper;
    }

}