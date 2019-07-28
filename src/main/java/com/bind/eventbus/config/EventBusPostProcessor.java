package com.bind.eventbus.config;

import com.google.common.eventbus.AsyncEventBus;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

@Component
public class EventBusPostProcessor implements BeanPostProcessor {

	private final AsyncEventBus eventBus;

	@Autowired
	public EventBusPostProcessor(final AsyncEventBus eventBus) {
		this.eventBus = eventBus;
	}

	@Override
	public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {

		final Class<? extends Object> clazz = bean.getClass();

		final Method[] methods = clazz.getMethods();
		for (final Method method : methods) {

			final Annotation[] annotations = method.getAnnotations();
			for (final Annotation annotation : annotations) {

				final Class<? extends Annotation> annotationType = annotation.annotationType();
				final boolean subscriber = annotationType.equals(Subscribe.class);
				if (subscriber) {
					eventBus.register(bean);
					return bean;
				}

			}

		}
		return bean;
	}

}