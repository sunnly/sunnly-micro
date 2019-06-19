package wang.sunnly.micro.module.demo.consumer.config;

import com.alibaba.fastjson.JSONObject;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wang.sunnly.micro.common.core.exception.UserInvalidException;

import java.io.IOException;

/**
 * @author Sunnly
 * @ClassName NotBreakerConfiguration
 * @Date 2019/6/19 0019 20:04
 **/
@Configuration
public class NotBreakerConfiguration {
    @Bean
    public ErrorDecoder errorDecoder() {
        return new UserErrorDecoder();
    }
    /**
     * 自定义错误
     */
    public class UserErrorDecoder implements ErrorDecoder {
        private Logger logger = LoggerFactory.getLogger(getClass());
        @Override
        public Exception decode(String methodKey, Response response) {
            Exception exception = null;
            try {
                String json = Util.toString(response.body().asReader());
                JSONObject jsonObject = JSONObject.parseObject(json);
                throw  new UserInvalidException(jsonObject.getString("message"),jsonObject.getInteger("status"));
//                Result result = JsonMapper.nonEmptyMapper().fromJson(json, Result.class);
//                // 业务异常包装成 HystrixBadRequestException，不进入熔断逻辑
//                if (!result.isSuccess()) {
//                    exception = new HystrixBadRequestException(result.getMessage());
//                }
            } catch (IOException ex) {
//                logger.error(ex.getMessage(), ex);
            }
            return exception;
        }
    }


}
