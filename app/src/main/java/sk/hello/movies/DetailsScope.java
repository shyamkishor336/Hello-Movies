package sk.hello.movies;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;


/**
 * @author arunsasidharan
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface DetailsScope {
}
