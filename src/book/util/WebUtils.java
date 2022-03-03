package book.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	/**
	 * Populate the bean object with value stored in the parameter map
	 * @param bean
	 * @param value
	 * @return the bean object
	 */
	public static Object copyParamToBean(Object bean, Map value) {
		// Use BeanUtils to populate bean.
		try {
			BeanUtils.populate(bean, value);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return bean;
	}
}
