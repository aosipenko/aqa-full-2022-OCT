package org.prog.util;

import java.util.HashMap;
import org.prog.web.pageobjects.commons.AbstractPage;

public class PageHolder {
  private final HashMap<Pages, AbstractPage> pageHolder = new HashMap<>();
  private final static PageHolder instance = new PageHolder();

  private PageHolder() {

  }

  public static PageHolder getInstance() {
    return instance;
  }

  public void iniPage(Pages pageName, AbstractPage page) {
    pageHolder.put(pageName, page);
  }

  public AbstractPage get(Pages pageName) {
    return pageHolder.get(pageName);
  }
}
