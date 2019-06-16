package wang.sunnly.micro.security.oauth.service;

import java.util.List;

public interface AuthClientServices {


    String generateToken(String clientId, String secret) throws Exception;

    List<String> getAllowClient(String clientId, String secret);

    void validate(String clientId, String secret);
}
