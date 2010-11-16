/**
 * ********************************************************************
 * Code developed by amazing QCADOO developers team.
 * Copyright (c) Qcadoo Limited sp. z o.o. (2010)
 * ********************************************************************
 */

package com.qcadoo.mes.model.search.restrictions.internal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public final class IsNotNullRestriction extends BaseRestriction {

    public IsNotNullRestriction(final String fieldName) {
        super(fieldName, null);
    }

    @Override
    public Criteria addRestrictionToHibernateCriteria(final Criteria criteria) {
        return criteria.add(Restrictions.isNotNull(getFieldName()));
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(47, 5).append(getFieldName()).append(getValue()).toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IsNotNullRestriction)) {
            return false;
        }
        IsNotNullRestriction other = (IsNotNullRestriction) obj;
        return new EqualsBuilder().append(getFieldName(), other.getFieldName()).append(getValue(), other.getValue()).isEquals();
    }

    @Override
    public String toString() {
        return getFieldName() + " is not null";
    }

}
