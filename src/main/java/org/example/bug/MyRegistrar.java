package org.example.bug;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyRegistrar implements ImportBeanDefinitionRegistrar {

	// Creates two beans using MyFactory
	// bean2 depends on bean1

	// The factory takes the dependency via constructor
	// that is the reason why bean1 is created early and not eligible for all
	// bean post processors

	public void registerBeanDefinitions(
			AnnotationMetadata importingClassMetadata,
			BeanDefinitionRegistry registry)
	{
		// Bean 1 has no dependency
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
		builder.addConstructorArgValue(null);
		registry.registerBeanDefinition("bean1", builder.getBeanDefinition());
		// Bean 2 has dependency on bean 1 - via constructor argument injection
		builder = BeanDefinitionBuilder.genericBeanDefinition(MyFactoryBean.class);
		builder.addConstructorArgReference("bean1");
		registry.registerBeanDefinition("bean2", builder.getBeanDefinition());
	}

}
