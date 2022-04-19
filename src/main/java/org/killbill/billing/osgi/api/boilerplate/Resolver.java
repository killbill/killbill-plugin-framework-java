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

package org.killbill.billing.osgi.api.boilerplate;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import org.killbill.billing.osgi.api.Healthcheck;
import org.killbill.billing.osgi.api.OSGIKillbill;
import org.killbill.billing.osgi.api.OSGIPluginProperties;
import org.killbill.billing.osgi.api.PluginInfo;
import org.killbill.billing.osgi.api.PluginServiceInfo;
import org.killbill.billing.osgi.api.PluginsInfoApi;

public class Resolver extends SimpleAbstractTypeResolver {
    public Resolver(){
        this.addMapping(Healthcheck.class, HealthcheckImp.class);
        this.addMapping(OSGIKillbill.class, OSGIKillbillImp.class);
        this.addMapping(OSGIPluginProperties.class, OSGIPluginPropertiesImp.class);
        this.addMapping(PluginInfo.class, PluginInfoImp.class);
        this.addMapping(PluginServiceInfo.class, PluginServiceInfoImp.class);
        this.addMapping(PluginsInfoApi.class, PluginsInfoApiImp.class);
    }
}
