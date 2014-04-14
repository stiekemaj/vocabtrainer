vocabtrainer
============

Installation
============

The vocabtrainer should be deployed into a Glassfish JEE container. The following resources should be configured in Glassfish:

Datasource
----------
Create a JDBC Resource with the name 'jdbc/vocabtrainerDS' to give the application access to the vocabtrainer database.
Log in to the Oracle GlassFish Server console and go to Resources -> JDBC -> JDBC Resources.

Security Realm
--------------
Go to Configurations -> server-config -> Security -> Realms and create a new Realm with the following settings:
* Realm Name: jdbcRealm
* Class Name: com.sun.enterprise.security.auth.realm.jdbc.JDBCRealm
* JAAS context: jdbcRealm
* JNDI: udbc/vocabtrainerDS
* User Table: USERS
* User Name Column: EMAILADDRESS
* Password Column: PASSWORD
* Group Table: USERS
* Group Name Column: ROLE
* Password Encryption Algorithm: SHA-256
* Encoding: Hex
