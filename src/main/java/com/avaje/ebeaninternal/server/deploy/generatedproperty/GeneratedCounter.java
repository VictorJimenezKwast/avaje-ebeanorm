package com.avaje.ebeaninternal.server.deploy.generatedproperty;

import com.avaje.ebean.bean.EntityBean;
import com.avaje.ebeaninternal.server.core.BasicTypeConverter;
import com.avaje.ebeaninternal.server.deploy.BeanProperty;

/**
 * A general number counter for various number types.
 */
public class GeneratedCounter implements GeneratedProperty {

  final int numberType;

  public GeneratedCounter(int numberType) {
    this.numberType = numberType;
  }

  /**
   * Always returns a 1.
   */
  @Override
  public Object getInsertValue(BeanProperty prop, EntityBean bean, long now) {
    return BasicTypeConverter.convert(1, numberType);
  }

  /**
   * Increments the current value by one.
   */
  @Override
  public Object getUpdateValue(BeanProperty prop, EntityBean bean, long now) {
    Number currVal = (Number) prop.getValue(bean);
    Integer nextVal = currVal.intValue() + 1;
    return BasicTypeConverter.convert(nextVal, numberType);
  }

  /**
   * Include this in every update.
   */
  public boolean includeInUpdate() {
    return true;
  }

  @Override
  public boolean includeInAllUpdates() {
    return false;
  }

  /**
   * Include this in every insert setting initial counter value to 1.
   */
  public boolean includeInInsert() {
    return true;
  }

  public boolean isDDLNotNullable() {
    return true;
  }

}
