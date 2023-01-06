package com.distribuida.config;

import lombok.SneakyThrows;
import org.apache.commons.dbcp2.BasicDataSource;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

import java.sql.Connection;

public class ConectionPool {

    private static BasicDataSource conectionPool;

    public static BasicDataSource getInstance() {
        Config config = ConfigProvider.getConfig();
        if (conectionPool == null) {
            conectionPool = new BasicDataSource();
            conectionPool.setUrl(config.getValue("db.url", String.class));
            conectionPool.setUsername(config.getValue("db.user", String.class));
            conectionPool.setPassword(config.getValue("db.password", String.class));
        }
        return conectionPool;
    }

    @SneakyThrows
    public static Connection getConnection() {
        return getInstance().getConnection();
    }
}
