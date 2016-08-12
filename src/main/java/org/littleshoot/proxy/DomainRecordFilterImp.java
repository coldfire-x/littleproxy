package org.littleshoot.proxy;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import org.littleshoot.proxy.impl.ProxyToServerConnection;

/**
 * Created by pengfei on 16/8/12.
 */
public class DomainRecordFilterImp implements DomainRecordFilter {

    private ArrayList<Pattern> domain_patterns = new ArrayList<Pattern>();

    public int addDomain(String s) {
        s = s.trim();
        if (s == "")
            return domain_patterns.size();

        String[] ss;

        if (s.contains(",")) {
            ss = s.split(",");
        } else {
            ss = new String[]{s};
        }

        for (String _s : ss) {
            Pattern p = Pattern.compile(_s);
            addDomain(p);
        }

        return domain_patterns.size();
    }

    public int addDomain(Pattern p) {
        if (!domain_patterns.contains(p)) {
            domain_patterns.add(p);
        }
        return domain_patterns.size();
    }

    public Boolean shouldRecord(String s) {
        for (Pattern p : domain_patterns) {
            Matcher m = p.matcher(s);
            if (m.matches())
                return true;
        }

        return false;
    }

    public Boolean shouldRecord(ProxyToServerConnection c) {
        String host = c.getServerHostAndPort();
        Boolean s = shouldRecord(host);
        return s;
    }

    public Boolean shouldRecord(HttpRequest request) {
        String host = request.headers().get("Host");
        Boolean s = shouldRecord(host);
        return s;
    }
}
