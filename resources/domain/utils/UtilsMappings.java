package com.bme.clp.bck.resources.q.domain.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bme.clp.bck.resources.q.web.api.model.FilterType;
import com.bme.clp.bck.resources.q.web.api.model.RestrictionRootType;

public class UtilsMappings {

  public static List<FilterType> mappingFilter(final List<FilterType> listFilters) {
    List<FilterType> result = new ArrayList<FilterType>();
    return result;
  }

  public static List<RestrictionRootType> mappingRestrictions(
    final List<RestrictionRootType> listRestrictionsRootTypes) {
    List<RestrictionRootType> result = new ArrayList<RestrictionRootType>();
    return result;
  }

  public static String mappingSorting(final String sorting) {
    return sorting;
  }

}