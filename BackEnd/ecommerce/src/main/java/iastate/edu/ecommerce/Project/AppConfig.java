package iastate.edu.ecommerce.Project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

        @Bean
        public Repo getRepo() {
            return new RepositoryImp();
        }
    }

