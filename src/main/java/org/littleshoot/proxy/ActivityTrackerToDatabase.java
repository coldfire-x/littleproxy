package org.littleshoot.proxy;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;

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
        System.out.println("in requestReceivedFromClient");
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
