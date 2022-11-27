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
