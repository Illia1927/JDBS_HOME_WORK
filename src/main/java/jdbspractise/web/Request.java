package jdbspractise.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Request {
    private String url;
    private RequestMathod method;
    private Map<String, String[]> params;

    public enum RequestMathod {
        POST,
        GET
    }

    public Request(String url, RequestMathod method, Map<String, String[]> params) {
        this.url = url;
        this.method = method;
        this.params = params;
    }

    public static Request of(String url, RequestMathod method, Map<String, String[]> params) {
        return new Request(url, method, params);
    }

    public static Request of(String url, RequestMathod method) {
        return new Request(url, method, new HashMap<>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return url.equals(request.url) &&
                method == request.method;
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, method);
    }

    public String getParamByName(String name) {
        //////////////////
        System.out.println("////////////////////////////////////////////////////");
        System.out.println(params.isEmpty());
        System.out.println(params.toString());
        System.out.println(params.entrySet());
        //////////////////////
        return params.get(name)[0];
    }

    @Override
    public String toString() {
        return "Request{" +
                "url='" + url + '\'' +
                ", method=" + method +
                ", params=" + params +
                '}';
    }
}
