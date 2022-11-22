package org.prog.util;

import java.util.HashMap;

public class DataHolder {
  private final HashMap<String, Object> objectHolder = new HashMap<>();
  private final static DataHolder instance = new DataHolder();

  private DataHolder() {

  }

  public static DataHolder getInstance() {
    return instance;
  }

  public void put(String key, Object object) {
    objectHolder.put(key, object);
  }

  public Object get(String key) {
    return objectHolder.get(key);
  }
}
