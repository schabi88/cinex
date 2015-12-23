package de.cinex.servlet;

import de.cinex.database.dao.UserDao;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.sql.SQLException;

@Singleton
@Startup
public class StartupBean {
    public static final String DB_PORT = "9093";
    private static final Logger log = LoggerFactory.getLogger(StartupBean.class);

    @Inject
    UserDao userDao;

    private static void stopDbServer() {
        try {
            Server.shutdownTcpServer("tcp://localhost:" + DB_PORT, "", true, true);
        } catch (SQLException e) {
            log.error("Could not shutdown db server: " + e);
        }
    }

    @PostConstruct
    public void init() {
        log.info("Cinex Server started.");
        // inital code goes here
        startDbServer();
    }

    @PreDestroy
    public void shutdown() {
        stopDbServer();
    }

    /**
     * Start H2 db as server.
     * You can connect remotly using this URL:
     * jdbc:h2:tcp://localhost:9093/~/cinexdb
     * User: sa
     * Pwd: <KEEP EMPTY>
     * <p>
     * WARNING: Server is NOT secured. Don't use in production!!!!!
     */
    private void startDbServer() {
        try {
            Server.createTcpServer("-tcpPort", DB_PORT, "-tcpAllowOthers").start();
            log.warn("WARNING: H2 Server started. Only for testing allowed! Don't start on production system!!!!!");
        } catch (SQLException e) {
            log.error("Could not start db server: " + e);
        }
    }
}