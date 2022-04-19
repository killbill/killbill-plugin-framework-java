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

package org.killbill.billing.util.api.boilerplate;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import org.killbill.billing.util.api.AuditUserApi;
import org.killbill.billing.util.api.ColumnInfo;
import org.killbill.billing.util.api.CustomFieldUserApi;
import org.killbill.billing.util.api.DatabaseExportOutputStream;
import org.killbill.billing.util.api.ExportUserApi;
import org.killbill.billing.util.api.RecordIdApi;
import org.killbill.billing.util.api.TagUserApi;

public class Resolver extends SimpleAbstractTypeResolver {
    public Resolver(){
        this.addMapping(AuditUserApi.class, AuditUserApiImp.class);
        this.addMapping(ColumnInfo.class, ColumnInfoImp.class);
        this.addMapping(CustomFieldUserApi.class, CustomFieldUserApiImp.class);
        this.addMapping(DatabaseExportOutputStream.class, DatabaseExportOutputStreamImp.class);
        this.addMapping(ExportUserApi.class, ExportUserApiImp.class);
        this.addMapping(RecordIdApi.class, RecordIdApiImp.class);
        this.addMapping(TagUserApi.class, TagUserApiImp.class);
    }
}
