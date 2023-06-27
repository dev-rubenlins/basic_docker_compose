module boot {
    requires util;
    requires entities;
    requires use.cases;
    requires spring.boot.starter.data.mongodb;
    requires spring.context;
    requires spring.beans;
    requires spring.data.mongodb;
    requires spring.data.commons;
    requires lombok;
    requires org.mongodb.driver.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires spring.boot;
    requires spring.web;
    requires spring.boot.autoconfigure;
    requires spring.boot.starter.web;
    requires org.slf4j;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
}