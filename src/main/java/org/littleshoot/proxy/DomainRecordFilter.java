package org.littleshoot.proxy;

import io.netty.handler.codec.http.HttpRequest;
import org.littleshoot.proxy.impl.ProxyToServerConnection;

/**
 * Created by pengfei on 16/8/12.
 */
public interface DomainRecordFilter {
    int addDomain(String domains);
    Boolean shouldRecord(String domain);
    Boolean shouldRecord(HttpRequest req);
    Boolean shouldRecord(ProxyToServerConnection c);
}
