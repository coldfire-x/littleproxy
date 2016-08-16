package org.littleshoot.proxy;

import java.net.InetSocketAddress;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;

import org.littleshoot.proxy.impl.ClientToProxyConnection;

/**
 * <p>
 * Encapsulates contextual information for flow information that's being
 * reported to a {@link ActivityTracker}.
 * </p>
 */
public class FlowContext {
    private final InetSocketAddress clientAddress;
    private final SSLSession clientSslSession;
    protected final ClientToProxyConnection cTopConnection;

    public FlowContext(ClientToProxyConnection clientConnection) {
        super();
        this.cTopConnection = clientConnection;
        this.clientAddress = clientConnection.getClientAddress();
        SSLEngine sslEngine = clientConnection.getSslEngine();
        this.clientSslSession = sslEngine != null ? sslEngine.getSession()
                : null;
    }

    public ClientToProxyConnection getcTopConnection() {
        return cTopConnection;
    }

    /**
     * The address of the client.
     * 
     * @return
     */
    public InetSocketAddress getClientAddress() {
        return clientAddress;
    }

    /**
     * If using SSL, this returns the {@link SSLSession} on the client
     * connection.
     * 
     * @return
     */
    public SSLSession getClientSslSession() {
        return clientSslSession;
    }

}
