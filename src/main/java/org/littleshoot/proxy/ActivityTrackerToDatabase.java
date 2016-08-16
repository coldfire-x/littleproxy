package org.littleshoot.proxy;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import org.littleshoot.proxy.impl.ClientToProxyConnection;
import org.littleshoot.proxy.impl.DefaultHttpProxyServer;

import javax.net.ssl.SSLSession;
import java.net.InetSocketAddress;

/**
 * Created by pengfei on 16/8/11.
 */
public class ActivityTrackerToDatabase implements ActivityTracker {
    @Override
    public void bytesReceivedFromClient(FlowContext flowContext,
                                        int numberOfBytes) {
    }

    @Override
    public void requestReceivedFromClient(FlowContext flowContext,
                                          HttpRequest httpRequest) {
        DefaultHttpProxyServer s = flowContext.getcTopConnection().getProxyServer();
        DBCollection c = s.getMc();
        BasicDBObject doc = new BasicDBObject("URI", httpRequest.getUri());
        doc.append("method", httpRequest.getMethod().toString());
        c.insert(doc);
    }

    @Override
    public void bytesSentToServer(FullFlowContext flowContext, int numberOfBytes) {
    }

    @Override
    public void requestSentToServer(FullFlowContext flowContext,
                                    HttpRequest httpRequest) {
    }

    @Override
    public void bytesReceivedFromServer(FullFlowContext flowContext,
                                        int numberOfBytes) {
    }

    @Override
    public void responseReceivedFromServer(FullFlowContext flowContext,
                                           HttpResponse httpResponse) {
    }

    @Override
    public void bytesSentToClient(FlowContext flowContext,
                                  int numberOfBytes) {
    }

    @Override
    public void responseSentToClient(FlowContext flowContext,
                                     HttpResponse httpResponse) {
        System.out.println("in responseSentToClient");
    }

    @Override
    public void clientConnected(InetSocketAddress clientAddress) {
    }

    @Override
    public void clientSSLHandshakeSucceeded(InetSocketAddress clientAddress,
                                            SSLSession sslSession) {
    }

    @Override
    public void clientDisconnected(InetSocketAddress clientAddress,
                                   SSLSession sslSession) {
    }
}
