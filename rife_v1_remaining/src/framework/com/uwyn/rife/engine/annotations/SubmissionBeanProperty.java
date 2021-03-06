/*
 * Copyright 2001-2008 Geert Bevin (gbevin[remove] at uwyn dot com)
 * Licensed under the Apache License, Version 2.0 (the "License")
 * $Id: SubmissionBeanProperty.java 3918 2008-04-14 17:35:35Z gbevin $
 */
package com.uwyn.rife.engine.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declares that the bean property that corresponds to the annotated setter
 * will be used as a submission bean. The name of the bean will be the name of
 * the property, and the bean class will be the property type. The submission
 * bean will be added to the previous submission that has been declared.
 * <p>If no submission has been declared beforehand, either through {@link Submission}
 * or {@link SubmissionHandler}, an exception will be thrown when the
 * annotations of this element are evaluated.
 * <p>When an element is processed, an instance of the submission bean will be
 * created and its properties will be filled in with the available submission
 * parameter values. The submission bean instance will be injected into the
 * element through the setter and RIFE's type conversion will try to convert the
 * bean type into the property type. A {@link com.uwyn.rife.engine.exceptions.NamedSubmissionBeanInjectionException}
 * exception will be thrown if the conversion failed.
 *
 * @author Geert Bevin (gbevin[remove] at uwyn dot com)
 * @version $Revision: 3918 $
 * @since 1.5
 * @see SubmissionBean
 * @see Submission
 * @see SubmissionHandler
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface SubmissionBeanProperty
{
	/**
	 * The expected name of the property.
	 * <p>
	 * This hasn't got any influence on the actual name that is being used
	 * for the property, but is used instead to ensure that the property name
	 * is the same as the one specified here. This is typically used to create
	 * a single point of declaration for the property name that can be
	 * referenced elsewhere and that is ensured to be correct.
	 *
	 * @since 1.6
	 */
	String name() default "";

	/**
	 * The prefix that will be prepended to each property name of the
	 * submission bean when corresponding parameters are automatically
	 * declared.
	 * @since 1.5
	 */
	String prefix() default "";

	/**
	 * The validation group that has been declared by the bean class.
	 * <p>This requires the bean class to implement the {@link com.uwyn.rife.site.ValidatedConstrained}
	 * interface, either directly, or by extending {@link com.uwyn.rife.site.MetaData}, or by using
	 * automated <a href="http://rifers.org/wiki/display/RIFE/Meta+data+merging">meta data merging</a>.
	 * <p>The group will indicate which bean properties should only be taken
	 * into account. Any properties outside the group will not be created as
	 * submission parameters.
	 * @since 1.5
	 */
	String group() default "";
}
