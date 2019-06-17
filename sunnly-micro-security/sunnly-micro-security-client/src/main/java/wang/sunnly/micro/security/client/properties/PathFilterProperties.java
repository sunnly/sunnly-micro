package wang.sunnly.micro.security.client.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Sunnly
 * @ClassName ArrPropeties
 * @Date 2019/6/17 0017 23:52
 **/
@Component
@ConfigurationProperties(prefix="sunnly.path-patterns")
public class PathFilterProperties {

    private PathPatterns client = new PathPatterns();
    private PathPatterns user = new PathPatterns();

    public class PathPatterns{
        private List<String> intercept;
        private List<String> exclude;

        public List<String> getIntercept() {
            return intercept;
        }

        public void setIntercept(List<String> intercept) {
            this.intercept = intercept;
        }

        public List<String> getExclude() {
            return exclude;
        }

        public void setExclude(List<String> exclude) {
            this.exclude = exclude;
        }
    }

    public PathPatterns getClient() {
        return client;
    }

    public void setClient(PathPatterns client) {
        this.client = client;
    }

    public PathPatterns getUser() {
        return user;
    }

    public void setUser(PathPatterns user) {
        this.user = user;
    }
}
