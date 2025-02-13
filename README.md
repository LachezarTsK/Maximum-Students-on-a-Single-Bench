# Maximum-Students-on-a-Single-Bench
Challenge at LeetCode.com. Tags: Bitwise Operations, Hash table, Math.

--------------------------------------------------------------------------------------------------------------------------------------------------------------

The presented solution demonstrates how we can apply bitwise operations to store information about ''visited points'', even when the input range 
(which is processed as the number of bitwise left shifts) exceeds a 32-bit integer or a 64-bit integer. In this particular case, ''visited points'' stores information about the already seated students on a given bench. The information is needed to avoid seating one and the same student more than once on the same bench.

Solutions with Java, C++, C#, Kotlin, Go.<br/>
64-bit integers are applied. In order to avoid integer overflow, the input range of IDs [1, 100] is processed in two separate ranges [1, 50] and [51, 100].

Solutions with JavaScript and TypeScript.<br/>
These two languages, when applying bitwise operations on their inbuilt number (a double-precision 64-bit binary format), the number is treated as a 32-bit integer. So, if the information about the ''visited points'' is to be stored with bitwise operations, there are two options:<br/>
- apply their BigInt class instead of the inbuilt number<br/>
- apply the inbuilt number and process the input in four separate ranges [1, 25], [26, 50], [51, 75] and [75, 100].

The option with BigInt is slightly slower than the one with four separate ranges, therefore the latter approach is taken here.
Anyway, when it comes to JavaScript and TypeScript, for this particular problem, both of these approaches are much slower 
than solutions with a Hash Table. So, solutions with Hash Set for JavaScript and TypeScript are also included. 

