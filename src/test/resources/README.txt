#!/bin/sh

# In order to generate the Jooq classes either copy and paste the code below
# or run this through "sh" like:
# > sh ./src/test/resources/README.txt

# Load the DDL schema in MySQL
DDL_DIR="`dirname \"$0\"`"
mysql -u root killbill < "${DDL_DIR}"/ddl.sql

# Download and install the Jooq required plugins in our repo
JOOQ_VERSION=3.9.1
mvn org.apache.maven.plugins:maven-dependency-plugin:2.1:get -Dartifact=org.jooq:jooq:$JOOQ_VERSION -DrepoUrl=http://sonatype.org
mvn org.apache.maven.plugins:maven-dependency-plugin:2.1:get -Dartifact=org.jooq:jooq-meta:$JOOQ_VERSION -DrepoUrl=http://sonatype.org
mvn org.apache.maven.plugins:maven-dependency-plugin:2.1:get -Dartifact=org.jooq:jooq-codegen:$JOOQ_VERSION -DrepoUrl=http://sonatype.org

# Get the Jooq JARs out of the MVN repository
M2_REPOS=~/.m2/repository;
JOOQ="$M2_REPOS/org/jooq";
MYSQL="$(ls -1 ~/.m2/repository/mysql/mysql-connector-java/*/*jar | sort -r | head -1)";
JARS="$JOOQ/jooq/$JOOQ_VERSION/jooq-$JOOQ_VERSION.jar:$JOOQ/jooq-meta/$JOOQ_VERSION/jooq-meta-$JOOQ_VERSION.jar:$JOOQ/jooq-codegen/$JOOQ_VERSION/jooq-codegen-$JOOQ_VERSION.jar:$MYSQL:.";

# Run Jooq's generation tool
java -cp $JARS org.jooq.util.GenerationTool src/test/resources/gen.xml
