# killbill-plugin-framework-java
![Maven Central](https://img.shields.io/maven-central/v/org.kill-bill.billing.plugin.java/killbill-base-plugin?color=blue&label=Maven%20Central)

Convenience library to help write Kill Bill plugins.

## Kill Bill compatibility

| Framework version | Kill Bill version |
| ----------------: | ----------------: |
| 0.3.y             | 0.16.z            |
| 1.2.y             | 0.18.z            |
| 2.x.y             | 0.19.z            |
| 3.x.y             | 0.20.z            |
| 4.1.y             | 0.22.z            |
| 4.2.y             | 0.22.z            |
| 5.0.y             | 0.24.z            |
| 5.1.y             | 0.24.z            |

We've upgraded numerous dependencies in 4.2.x (required for Java 11 support).

## Usage

Add the library to your plugin:

```xml
<dependency>
    <groupId>org.kill-bill.billing.plugin.java</groupId>
    <artifactId>killbill-base-plugin</artifactId>
    <version>... release version ...</version>
</dependency>
<dependency>
    <groupId>org.kill-bill.billing.plugin.java</groupId>
    <artifactId>killbill-base-plugin</artifactId>
    <version>... release version ...</version>
    <type>test-jar</type>
    <scope>test</scope>
</dependency>
```

## About

Kill Bill is the leading Open-Source Subscription Billing & Payments Platform. For more information about the project, go to https://killbill.io/.
