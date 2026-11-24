/**
 * @author Sébastien Bordes
 */
open module org.jrebirth.af.presentation.javafx {

	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.web;

	requires java.desktop;

	requires transitive org.jrebirth.af.api;
	requires org.jrebirth.af.core;
	requires org.jrebirth.af.preloader;
	requires org.jrebirth.af.presentation;

	requires org.glassfish.jaxb.runtime;
	requires java.naming;
	requires ch.qos.logback.classic;
}