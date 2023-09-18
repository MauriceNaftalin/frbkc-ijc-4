package org.frbkc.ijc;

import java.util.*;

public interface OrgUnit {
    String getName();
    Set<? extends OrgUnit> getManagedUnits();
    Set<Employee> getEmployees();
}
