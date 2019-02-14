package jdbspractise.web;

import java.util.Objects;

public class Request {
    private String url;
    private RequestMathod method;

    public enum RequestMathod {
        POST,
        GET
    }

    public Request(String url, RequestMathod method) {
        this.url = url;
        this.method = method;
    }

    public static Request of(String url, RequestMathod method){
        return new Request(url, method);
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
}
