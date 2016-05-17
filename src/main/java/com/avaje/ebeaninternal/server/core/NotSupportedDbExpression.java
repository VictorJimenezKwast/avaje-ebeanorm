package com.avaje.ebeaninternal.server.core;

import com.avaje.ebeaninternal.api.SpiExpressionRequest;
import com.avaje.ebeaninternal.server.expression.Op;

/**
 * Not supported JSON or ARRAY expression handler.
 */
public class NotSupportedDbExpression implements DbExpressionHandler {

  @Override
  public void json(SpiExpressionRequest request, String propName, String path, Op operator, Object value) {
    throw new RuntimeException("JSON expressions only supported on Postgres and Oracle");
  }

  @Override
  public void arrayContains(SpiExpressionRequest request, String propName, boolean contains, Object... values) {
    throw new RuntimeException("ARRAY expressions only supported on Postgres");
  }

  @Override
  public void arrayIsEmpty(SpiExpressionRequest request, String propName, boolean empty) {
    throw new RuntimeException("ARRAY expressions only supported on Postgres");
  }
}