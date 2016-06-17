killbill-plugin-framework-java
==============================

-------------------------------------------------
| Plugin Framework version | Kill Bill version   |
| -----------------------: | ------------------: |
| 0.x.y                    | 0.16.z              |
| -----------------------: | ------------------: |
| 1.x.y                    | 0.18.z (and 0.17.x) |


Convenience library to help write Kill Bill plugins.

Here are some examples to get you started:

* Payment plugin: https://github.com/killbill/killbill-adyen-plugin
* Routing plugin: https://github.com/killbill/killbill-accertify-plugin

Usage
-----

Add the library to your plugin:

```
<dependency>
    <groupId>org.kill-bill.billing.plugin.java</groupId>
    <artifactId>killbill-base-plugin</artifactId>
</dependency>
<dependency>
    <groupId>org.kill-bill.billing.plugin.java</groupId>
    <artifactId>killbill-base-plugin</artifactId>
    <type>test-jar</type>
    <scope>test</scope>
</dependency>
```

Add the following OSGI Import-Package directives:

```
org.killbill.billing.account.api;
org.killbill.billing.catalog.api;
org.killbill.billing.invoice.api;
org.killbill.billing.entitlement.api;
org.killbill.billing.notification.api;
org.killbill.billing.notification.plugin.api;
org.killbill.billing.notification.plugin;
org.killbill.billing.osgi.api;
org.killbill.billing.osgi.api.config;
org.killbill.billing.payment.api;
org.killbill.billing.payment.plugin.api;
org.killbill.billing.control.plugin.api;
org.killbill.billing.tenant.api;
org.killbill.billing.usage.api;
org.killbill.billing.util.api;
org.killbill.billing.currency.plugin.api;
org.killbill.billing.currency.api;
org.killbill.billing.security.api;
```
