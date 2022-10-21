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
a server-side component responsible with the business-logic of the application: writing the words to a file, reading data from a file, etc.
a server-side component responsible with controlling the web-flow. ✔️
