package com.transportation.mapper;

import java.util.List;

public interface Mapper<T, R> {

  T toModel(R entity);

  List<T> toModelList(List<R> entities);
}
