package com.bme.clp.bck.resources.q.domain.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bme.clp.bck.resources.q.web.api.model.FilterType;
import com.bme.clp.bck.resources.q.web.api.model.RestrictionRootType;

public class UtilsMappings {
	
  public static List<FilterType> mappingFilter(final List<FilterType> listFilters) {
    List<FilterType> result = new ArrayList<FilterType>();
	listFilters.forEach(filter -> {
     String attribute = filter.getAttribute().trim();
	 if (Constants.EQUIVALENCE_RISKGROUPID[0].equals(attribute)) {
        filter.setAttribute(
          UtilsCommon.checkFieldsIsJoined(attribute, Constants.EQUIVALENCE_RISKGROUPID[1],
            DividendDAO.class, ""));
		
     } else if (Constants.EQUIVALENCE_TESTID[0].equals(attribute)) {
		filter.setAttribute(
          UtilsCommon.checkFieldsIsJoined(attribute, Constants.EQUIVALENCE_TESTID[1],
            DividendDAO.class, ""));
		
	 } else {
        filter.setAttribute(UtilsCommon.checkFieldsIsJoined(attribute, attribute,
          RiskSubGroupDAO.class, ""));
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
              RiskSubGroupDAO.class, ""));        
	
     } else if (Constants.EQUIVALENCE_TESTID[0].equals(attribute)) {
		restrictionRootType
          .setAttribute(
            UtilsCommon.checkFieldsIsJoined(attribute, Constants.EQUIVALENCE_TESTID[1],
              RiskSubGroupDAO.class, ""));
		
      } else {
        restrictionRootType.setAttribute(UtilsCommon.checkFieldsIsJoined(attribute, attribute,
          RiskSubGroupDAO.class, ""));
      }
      result.add(restrictionRootType);
    });
    return result;
  }

  public static String mappingSorting(final String sorting) {
    return sorting;
  }

}