package com.transportation.config;

import org.hibernate.dialect.MySQLDialect;

public class CustomMySQLDialect extends MySQLDialect {

  @Override
  public String getTableTypeString() {
    return " engine=innodb default charset=utf8 collate=utf8_bin";
  }
}
