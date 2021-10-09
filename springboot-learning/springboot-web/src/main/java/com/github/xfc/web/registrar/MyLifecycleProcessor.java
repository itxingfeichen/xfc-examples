package com.github.xfc.web.registrar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * 声明周期
 *
 * @author xf.chen
 * @date 2021/9/22 16:23
 * @since 1.0.0
 */
@Component
public class MyLifecycleProcessor implements SmartLifecycle, BeanFactoryAware {

    /**
     * Callback that supplies the owning factory to a bean instance.
     * <p>Invoked after the population of normal bean properties
     * but before an initialization callback such as
     * {@link InitializingBean#afterPropertiesSet()} or a custom init-method.
     *
     * @param beanFactory owning BeanFactory (never {@code null}).
     *                    The bean can immediately call methods on the factory.
     * @throws BeansException in case of initialization errors
     * @see BeanInitializationException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    /**
     * Returns {@code true} if this {@code Lifecycle} component should get
     * started automatically by the container at the time that the containing
     * {@link ApplicationContext} gets refreshed.
     * <p>A value of {@code false} indicates that the component is intended to
     * be started through an explicit {@link #start()} call instead, analogous
     * to a plain {@link Lifecycle} implementation.
     *
     * @see #start()
     * @see #getPhase()
     * @see LifecycleProcessor#onRefresh()
     * @see ConfigurableApplicationContext#refresh()
     */
    @Override
    public boolean isAutoStartup() {
        return false;
    }

    /**
     * Indicates that a Lifecycle component must stop if it is currently running.
     * <p>The provided callback is used by the {@link LifecycleProcessor} to support
     * an ordered, and potentially concurrent, shutdown of all components having a
     * common shutdown order value. The callback <b>must</b> be executed after
     * the {@code SmartLifecycle} component does indeed stop.
     * <p>The {@link LifecycleProcessor} will call <i>only</i> this variant of the
     * {@code stop} method; i.e. {@link Lifecycle#stop()} will not be called for
     * {@code SmartLifecycle} implementations unless explicitly delegated to within
     * the implementation of this method.
     *
     * @param callback
     * @see #stop()
     * @see #getPhase()
     */
    @Override
    public void stop(Runnable callback) {

    }

    /**
     * Start this component.
     * <p>Should not throw an exception if the component is already running.
     * <p>In the case of a container, this will propagate the start signal to all
     * components that apply.
     *
     * @see SmartLifecycle#isAutoStartup()
     */
    @Override
    public void start() {

    }

    /**
     * Stop this component, typically in a synchronous fashion, such that the component is
     * fully stopped upon return of this method. Consider implementing {@link SmartLifecycle}
     * and its {@code stop(Runnable)} variant when asynchronous stop behavior is necessary.
     * <p>Note that this stop notification is not guaranteed to come before destruction: On
     * regular shutdown, {@code Lifecycle} beans will first receive a stop notification before
     * the general destruction callbacks are being propagated; however, on hot refresh during a
     * context's lifetime or on aborted refresh attempts, only destroy methods will be called.
     * <p>Should not throw an exception if the component isn't started yet.
     * <p>In the case of a container, this will propagate the stop signal to all components
     * that apply.
     *
     * @see SmartLifecycle#stop(Runnable)
     * @see DisposableBean#destroy()
     */
    @Override
    public void stop() {

    }

    /**
     * Check whether this component is currently running.
     * <p>In the case of a container, this will return {@code true} only if <i>all</i>
     * components that apply are currently running.
     *
     * @return whether the component is currently running
     */
    @Override
    public boolean isRunning() {
        return false;
    }

    /**
     * Return the phase value of this object.
     */
    @Override
    public int getPhase() {
        return 0;
    }
}
