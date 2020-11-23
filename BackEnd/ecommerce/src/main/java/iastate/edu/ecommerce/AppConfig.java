package iastate.edu.ecommerce;

import iastate.edu.ecommerce.Project.Repo;
import iastate.edu.ecommerce.Project.RepositoryImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

        @Bean
        public Repo getRepo() {
            return new RepositoryImp();
        }
    }

