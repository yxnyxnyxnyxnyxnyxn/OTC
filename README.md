Approach: 
split path string by "/" and store them into vector. Loop through the vector check special cases like ".." and ".". When element equals to ".." remove ".." and previouselement. When element equals to ".", remove the element. Finally, loop through vector again to form the finalPath.

Improvement:
Had some confusion about case: "//lib///", so I hard coded to check if the string contains continuous "/".If so, the finalPath is the non-frontlash string. 

Run:
javac Directory.java
java -ea Directory
