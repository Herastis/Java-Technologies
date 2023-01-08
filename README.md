# Java-Technologies

Lab 1

Compulsory (1p)
Create a servlet that receives a word and returns an HTML page containing the letters of that word presented as an ordered list. ✔️

Homework (2p)
It receives an integer as a parameter, called size, and it returns all the permutations of length size of the given letters. If the size is 0 (default), it will return all the sequences. ✔️

If the servlet has access to a server-side file containing a list of acceptable words (a dictionary), it will return only the sequences forming valid words.
This list should be large enough; you may use aspell to generate a text file containing English words, or anything similar: WordNet, dexonline, etc.
For example, if the servlet receives the leters a,a,j,v and the size is 0, it may return the list aa, ava, java (assuming it uses an en english dictionary). ✔️

Lab 2

Compulsory (1p)
input.jsp: a page containing a form for introducing some letters and a size. ✔️
result.jsp a page describing the response that will be delivered to the client, for example an HTML table containing the words of the given size. ✔️

Homework (2p)
an object-oriented domain model; ✔️
a server-side component responsible with the business-logic of the application: writing the words to a file, reading data from a file, etc.✔️
a server-side component responsible with controlling the web-flow. ✔️
A web filter that will log all requests received by input.jsp.✔️
A web filter that will decorate the response by adding a specific prelude (at the beginning) and a specific coda (at the end) to the generated HTML page.✔️

Lab 3

Compulsory (1p)
A relational database in order to store and retrieve data. (PostgreSQL is recommended). ✔️
You should have at least the tables: teams and cities. ✔️
A JSF project using Maven ✔️
A web page for viewing the teams in the database. ✔️

Homework(2p)
Create the support for managing the teams, using a datatable. ✔️
Define a page for creating a new team or editing an existing one, using a modal dialog.✔️
Define the web-flow using navigation-rules.✔️
Internationalize the user interface and offer support for at least two locales.✔️

Lab 4

Compulsory (1p)
Implement an efficient way for obtaining connections to the database.✔️
Configure a connection pool and a JDBC resource using an administrative tool (such as GlassFish/Payara Console or asadmin).✔️
Create DatSource objects using either JNDI directly or resource injection.✔️

Homework (2p)
Create the pages using templates:
page.xhtml: describing the general aspect of the application pages: header, content, footer. The header should display the title and might include a menu bar.✔️
The footer will display a copyright notice and the current version of the aplication. The header, footer and the menu bar should all be in separate .xhtml files.✔️
dataView.xhtml: a generic page for displaying data as a list, dataTable, etc.✔️
dataEdit.xhtml: a generic page for editing data. This could be a dialog containing a generic form.✔️

Lab 5

Compulsory (1p)

Define the persistence unit using a data source configured as a JDBC Resource. ✔️
Define at least one entity class and perform a simple test in order to verify the communication with the database. ✔️

Homework (2p)

Create the EntityManager objects using dependency injection. ✔️
Define the mappings using JPA-only annotations. ✔️
Create named queries using JPA-QL. ✔️
Implement the repository classes. ✔️
Create a complete test unit for the CRUD operations of at least one entity class. ✔️

Lab 6

A stateless session bean that offers methods for checking the availability of a period in a week. ✔️
-CheckPeriodAvailabilityRepository.java

A stateful session bean responsible with the assignment of one or more matches. The assignment should be atomic, either all matches are successfully scheduled, or the transaction will be rolled back. ✔️
-AssignMatchStatefulBean.java

A singleton session bean that keeps an in-memory map of the current assignments. The map will be instantiated at application startup and updated whenever the assignments change.
-CurrentAssignmentsSingletonBean.java

Lab 7

(2p) 
An [authentication](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/java/com/mycompany/entities/Login.java) mechanism based on username and password (implement it as you please, we'll rewrite it soon).✔️
Register new users and assign them a specific role, for example admin, author, reviewer, etc.✔️
Specify a time frame, in which registration is open for users and submissions.✔️
The possibility to upload a document (for [authors](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/webapp/author.xhtml)) and to view all uploaded documents (for [admin](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/webapp/admin.xhtml)). Each uploaded document will have a uniquely generated registration number. All submissions will be logged in a text file.✔️

(3p) Use Contexts and Dependency Injection (CDI) for:
(0.5) the management of application's beans ([@Inject](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/java/com/mycompany/repositories/DocumentRepository.java)) and transactions ([@Transactional](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/java/com/mycompany/repositories/UserRepository.java));✔️
(0.5) decoupling the components using dependency injection (for example, use a producer method to generate registration numbers) ([@Produces](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/java/com/mycompany/utils/NumberGenerator.java));✔️
(0.5) decoupling orthogonal concerns, such as logging; ([@Interceptor](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/java/com/mycompany/logging/MyInterceptor.java))✔️
(0.5) decoupling bussines concerns, such as verifying the date for operations like registration and submission ([@Decorator](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/java/com/mycompany/repositories/UserRepositoryDecorator.java));✔️
(0.5) implementing at least one event-based comunication (for instance, whenever a new document is uploaded a message is produced and all observers of this type of event will be notified) ([@Observes](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/java/com/mycompany/entities/DocumentsList.java));✔️
(0.5) data validation, using Bean Validation [annotations](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/java/com/mycompany/entities/UserBean.java).✔️

Lab 8

(2p) Create RESTful Web services using JAX-RS that allow the interaction with at least one JPA entity, implementing CRUD operations. For example, the application may offer a resource containing the following services:
-adding a new document to the database: [AddDocumentService](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/java/com/mycompany/services/AddDocumentService.java); 
-replacing an existing document [ReplaceDocumentService](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/java/com/mycompany/services/ReplaceDocumentService.java); 
-deleting an existing document. [DeleteDocumentService](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/java/com/mycompany/services/DeleteDocumentService.java); 
-returning a "list" of the documents that were uploaded. The parameter of the web method will be an identifier for the user. If the parameter is null, then all documents should be considered. [GetUploadedDocumentsService](https://github.com/Herastis/Java-Technologies/blob/main/DocumentsSubmissionManager/src/main/java/com/mycompany/services/GetUploadedDocumentsService.java); 
Use JSON for representing consumed or produced data. Comment (using OpenAPI) and test at least one service.
