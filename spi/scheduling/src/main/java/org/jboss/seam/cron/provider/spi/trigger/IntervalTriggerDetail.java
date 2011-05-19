/**
 * JBoss, Home of Professional Open Source
 * Copyright 2009, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.seam.cron.provider.spi.trigger;

import org.jboss.seam.cron.api.Every;
import org.jboss.seam.cron.api.TimeUnit;

/**
 * Simple container for the qualifying annotation and payload type of
 * a scheduled event to be fired.
 * 
 * @author Peter Royle
 */
public class IntervalTriggerDetail extends TriggerDetail {

    private final TimeUnit repeatUnit;
    private final Integer repeatInterval;

    public IntervalTriggerDetail(Every qualifier) {
        super(qualifier);
        this.repeatUnit = qualifier.value();
        this.repeatInterval = qualifier.nth();
    }

    public TimeUnit getRepeatUnit() {
        return repeatUnit;
    }

    public Integer getRepeatInterval() {
        return repeatInterval;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IntervalTriggerDetail other = (IntervalTriggerDetail) obj;
        if (this.getQualifier() != other.getQualifier() && (this.getQualifier() == null || !this.getQualifier().equals(other.getQualifier()))) {
            return false;
        }
        if (this.repeatUnit != other.repeatUnit) {
            return false;
        }
        if (this.repeatInterval != other.repeatInterval && (this.repeatInterval == null || !this.repeatInterval.equals(other.repeatInterval))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.getQualifier() != null ? this.getQualifier().hashCode() : 0);
        hash = 17 * hash + (this.repeatUnit != null ? this.repeatUnit.hashCode() : 0);
        hash = 17 * hash + (this.repeatInterval != null ? this.repeatInterval.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" + ", qualifier=" + getQualifier() + ", repeatUnit=" + repeatUnit + ", repeatInterval=" + repeatInterval + '}';
    }
}
