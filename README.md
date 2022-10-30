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
