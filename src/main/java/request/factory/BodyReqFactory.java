package main.java.request.factory;

import java.io.InputStream;
import java.util.Map;
import main.java.request.HttpRequestParser;
import main.java.request.RequestLine;
import main.java.request.event.BodyReq;

public class BodyReqFactory implements BaseRequestFactory<BodyReq> {

  @Override
  public boolean isResponsible(String requestLine) {
    return requestLine.split("[ ]")[0].toUpperCase().equals("POST");
  }

  @Override
  public BodyReq createEventFromRequest(HttpRequestParser parser) {
    final RequestLine requestLine = new RequestLine(parser.getRequestLine());
    final Map<String, String> requestHeaders = parser.getRequestHeaders();
    final String messageBody = parser.getMessageBody();

    return new BodyReq(requestLine, requestHeaders, messageBody);
  }
}