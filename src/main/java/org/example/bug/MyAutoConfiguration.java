package org.example.bug;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyRegistrar.class)
public class MyAutoConfiguration {

	// Just to import MyRegistrat

}
