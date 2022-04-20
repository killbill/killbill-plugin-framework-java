/* This is generated code, edit with caution! */
/*
 * Copyright 2022-2022 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.overdue.api.boilerplate;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Arrays;
import java.util.Objects;
import org.killbill.billing.overdue.api.EmailNotification;

@JsonDeserialize( builder = EmailNotificationImp.Builder.class )
public class EmailNotificationImp implements EmailNotification {

    private static final long serialVersionUID = 0xE60FBB8D4C6B579FL;

    protected Boolean isHTML;
    protected String subject;
    protected String templateName;

    public EmailNotificationImp(final EmailNotificationImp that) {
        this.isHTML = that.isHTML;
        this.subject = that.subject;
        this.templateName = that.templateName;
    }
    protected EmailNotificationImp(final EmailNotificationImp.Builder<?> builder) {
        this.isHTML = builder.isHTML;
        this.subject = builder.subject;
        this.templateName = builder.templateName;
    }
    protected EmailNotificationImp() { }
    @Override
    @JsonGetter("isHTML")
    public Boolean isHTML() {
        return this.isHTML;
    }
    @Override
    public String getSubject() {
        return this.subject;
    }
    @Override
    public String getTemplateName() {
        return this.templateName;
    }
    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( ( o == null ) || ( this.getClass() != o.getClass() ) ) {
            return false;
        }
        final EmailNotificationImp that = (EmailNotificationImp) o;
        if( !Objects.equals(this.isHTML, that.isHTML) ) {
            return false;
        }
        if( !Objects.equals(this.subject, that.subject) ) {
            return false;
        }
        if( !Objects.equals(this.templateName, that.templateName) ) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int result = 1;
        result = ( 31 * result ) + Objects.hashCode(this.isHTML);
        result = ( 31 * result ) + Objects.hashCode(this.subject);
        result = ( 31 * result ) + Objects.hashCode(this.templateName);
        return result;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{");
        sb.append("isHTML=").append(this.isHTML);
        sb.append(", ");
        sb.append("subject=");
        if( this.subject == null ) {
            sb.append(this.subject);
        }else{
            sb.append("'").append(this.subject).append("'");
        }
        sb.append(", ");
        sb.append("templateName=");
        if( this.templateName == null ) {
            sb.append(this.templateName);
        }else{
            sb.append("'").append(this.templateName).append("'");
        }
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public static class Builder<T extends EmailNotificationImp.Builder<T>> {

        protected Boolean isHTML;
        protected String subject;
        protected String templateName;

        public Builder() { }
        public Builder(final Builder that) {
            this.isHTML = that.isHTML;
            this.subject = that.subject;
            this.templateName = that.templateName;
        }
        public T withIsHTML(final Boolean isHTML) {
            this.isHTML = isHTML;
            return (T) this;
        }
        public T withSubject(final String subject) {
            this.subject = subject;
            return (T) this;
        }
        public T withTemplateName(final String templateName) {
            this.templateName = templateName;
            return (T) this;
        }
        public T source(final EmailNotification that) {
            this.isHTML = that.isHTML();
            this.subject = that.getSubject();
            this.templateName = that.getTemplateName();
            return (T) this;
        }
        protected Builder validate() {
          return this;
        }
        public EmailNotificationImp build() {
            return new EmailNotificationImp(this.validate());
        }
    }
}
