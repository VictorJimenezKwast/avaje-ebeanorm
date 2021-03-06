package com.avaje.ebeaninternal.server.core;

import com.avaje.ebeaninternal.api.SpiExpressionRequest;
import com.avaje.ebeaninternal.server.expression.Op;

/**
 * Oracle JSON expression handler, ARRAY expressions not supported.
 */
public class OracleDbExpression implements DbExpressionHandler {

  @Override
  public void json(SpiExpressionRequest request, String propName, String path, Op operator, Object value) {

    if (operator == Op.EXISTS) {
      request.append("json_exists(").append(propName).append(", '$.").append(path).append("')");
    } else if (operator == Op.NOT_EXISTS) {
      request.append("not json_exists(").append(propName).append(", '$.").append(path).append("')");
    } else {
      request.append("json_value(").append(propName).append(", '$.").append(path).append("')");
      request.append(operator.bind());
    }
  }

  @Override
  public void arrayContains(SpiExpressionRequest request, String propName, boolean contains, Object... values) {
    throw new IllegalStateException("ARRAY expressions not supported on Oracle");
  }

  @Override
  public void arrayIsEmpty(SpiExpressionRequest request, String propName, boolean empty) {
    throw new IllegalStateException("ARRAY expressions not supported on Oracle");
  }
}
