In objective 1

        in the first approach . easy to understand as below
         - reading from file
         - add six letter words to hashSet for o(1) searching
         - arrayList of other words less than 6 words
         - make all combination with o(n2) and search on hashSet
         - case is ignored but this can be handled by using hashMap and save the original word as value
         - worst case complexity o(n) construct the hashSet and o(n2) for searching
         
In Objective 2
		in the second approach . more optimized and a bit more complicated to read
         - reading from file
         - add six letter words to hashMap where key is the word and value is the list of possible combination pairs
         - ie (bubble -> list({b,ubble},{bub, ble}, {bubb, le}, {bubbl, e})
         - constructing of this data structure will be o(6*n) which is almost o(n)
         - also the search will be O(6*n) which is far better than o(n2)
         - then take each word in this hash map and search with all of it combination in the set
         - worst case complexity o(6*n) construct the map and o(6*n) for searching
		 
In Objective 3
		in the third approach . more optimized and extendable more complicated to read
		- by adding factory pattern so I can read from different datasource but I implemented only file one
		- add configuration file to handle app properties like file locations and so on
		- its optimized to o(6*N) so it run faster than the first one
		- can handle another data sources Just implement the interface 
		

Summary and answer to questions
 - For example, does making the program as fast as possible make it more or less readable?
		yes sometime optimization make the code harder to read or will take more time to be understood
 -Does it make easier to extend?
		my optimized solution still be able to extend easily
 -Does making the program readable make it slower or faster, flexible or rigid?
	yes some time readable solution make it slower as I mentioned before
  - does making it extendible make it more or less readable, slower or faster?
		my extendible solution is still readable and orginzed only the searching algorithm will need more time to be understood , but make it extedable was more readable
