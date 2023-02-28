从类似于java的switch和kt的when，同一时间只有一条分支被使用。
```xml
<when>
   <case test="${value1}">
     <Image src="https://www.google.com/xxx.png"/>
   <case/>
   <case test="${value2}">
     <Flex width="400" height="500"/>
   <case/>
   <else>
     <Stack width="400" height="500"/>
   <else/>
<when/>
```