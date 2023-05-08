package ArgentinaPrograma.ArgentinaPrograma;
//javac -source 8 -target 8 MyClass.java
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ArgentinaProgramaApplication.class);	}

}
