1. To work on this project you need Maven + JDK 8. If you want to execute only then JRE will be fine.
2. For CSV manipulation I am using Open Source Apache CSV framework.
3. For Unit Testing using the JUnit Framework and Integreation Testing using the Maven. You can run maven install for complete run.
4. Java Threading Synchronization is not used because expecting single csv processing
5. You can Import the GreaterBankCustomerTransactions into Eclipse IDE as a Maven Project
6. Create an Environment Variable TRANSACTION_PROCESSING and value as the root folder for file location and create one more folder "pending" Eg G:\TransactionProcess\pending.... Please restart machine after setting the environment variable otherwise the java program won't pick it up
7. For execution of Maven ,Right click on pom.xml and 1) clean 2) maven install 3) maven test
8. Main Class is GBApplicationStarter.java file