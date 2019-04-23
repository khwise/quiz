package com.quiz.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Web MVC 관련 설정을 정의한다.
 * |_ View Resolver
 * |_ View Controller
 * |_ Default Handler
 * |_ Interceptor
 * |_ Message Convert
 */

@Configuration
@EnableWebMvc
public class WebMvcConfiguration {

    // todo : message convert 재정의 (MessageConvert 동작 방법 파악 !!)
    // todo : LocalDateTime Serialize / Deserialize 구현

}
