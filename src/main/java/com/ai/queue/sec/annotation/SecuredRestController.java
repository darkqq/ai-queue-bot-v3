package com.ai.queue.sec.annotation;


import com.ai.queue.sec.temp.WrapperModel;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RestController
public @interface SecuredRestController {
    Class<? extends WrapperModel> wrapper();
}
