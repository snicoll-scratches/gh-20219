package org.example.bug;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Object> {

	public MyFactoryBean(Object other) {
		// The parameters is not really needed in this example
		// It is here just to have constructor dependency
	}

	public Class<?> getObjectType() {
		return Object.class;
	}

	@Override
	public Object getObject() throws Exception {
		return new Object();
	}

}
