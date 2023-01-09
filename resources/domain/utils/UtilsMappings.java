package com.bme.clp.bck.resources.q.domain.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bme.clp.bck.resources.q.web.api.model.FilterType;
import com.bme.clp.bck.resources.q.web.api.model.RestrictionRootType;
import com.bme.clp.bck.resources.q.domain.model.mongo.ModelDAO;

public class UtilsMappings {
	
  public static List<FilterType> mappingFilter(final List<FilterType> listFilters) {
    List<FilterType> result = new ArrayList<FilterType>();
	listFilters.forEach(filter -> {
     String attribute = filter.getAttribute().trim();
	 if (Constants.EQUIVALENCE_RISKGROUPID[0].equals(attribute)) {
        filter.setAttribute(
          UtilsCommon.checkFieldsIsJoined(attribute, Constants.EQUIVALENCE_RISKGROUPID[1],
            ModelDAO.class, ""));
		
     } else if (Constants.EQUIVALENCE_TESTID[0].equals(attribute)) {
		filter.setAttribute(
          UtilsCommon.checkFieldsIsJoined(attribute, Constants.EQUIVALENCE_TESTID[1],
            ModelDAO.class, ""));
		
	 } else {
        filter.setAttribute(UtilsCommon.checkFieldsIsJoined(attribute, attribute,
          ModelDAO.class, ""));
     }
     result.add(filter);
    });
    return result;
  }

  public static List<RestrictionRootType> mappingRestrictions(
    final List<RestrictionRootType> listRestrictionsRootTypes) {
    List<RestrictionRootType> result = new ArrayList<RestrictionRootType>();
    listRestrictionsRootTypes.forEach(restrictionRootType -> {
      String attribute = restrictionRootType.getAttribute().trim();
	  if (Constants.EQUIVALENCE_RISKGROUPID[0].equals(attribute)) {
        restrictionRootType
          .setAttribute(
            UtilsCommon.checkFieldsIsJoined(attribute, Constants.EQUIVALENCE_RISKGROUPID[1],
              ModelDAO.class, ""));        
	
     } else if (Constants.EQUIVALENCE_TESTID[0].equals(attribute)) {
		restrictionRootType
          .setAttribute(
            UtilsCommon.checkFieldsIsJoined(attribute, Constants.EQUIVALENCE_TESTID[1],
              ModelDAO.class, ""));
		
      } else {
        restrictionRootType.setAttribute(UtilsCommon.checkFieldsIsJoined(attribute, attribute,
          ModelDAO.class, ""));
      }
      result.add(restrictionRootType);
    });
    return result;
  }

  public static String mappingSorting(final String sorting) {
    if (sorting != null) {
      String[] sortingSplit = sorting.split(",");
      List<String> result = new ArrayList<String>();
      Arrays.asList(sortingSplit).forEach(sort -> {
        String order = sort.startsWith("-") ? "-" : "+";
        if (sort.contains(Constants.EQUIVALENCE_RISKGROUPID[0])) {
          result.add(order.concat(Constants.EQUIVALENCE_RISKGROUPID[1]));
		
        } else if (sort.contains(Constants.EQUIVALENCE_TESTID[0])) {
          result.add(order.concat(Constants.EQUIVALENCE_TESTID[1]));
        
		} else {
          result.add(sort);
        }
      });
      return String.join(",", result);
    } else {
      return "";
    }
  }

}