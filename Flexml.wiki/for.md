var是一个text类型的属性，用于描述在for中所使用的临时变量的名字，from和to标签是value类型的，不过它们会把数字强制类型转换为整数。

若items是一个大小为4的List<String>，可以使用for来展开集合。
```xml
<Flex>
  <for var="index" from="0" to="${items.size()-1}">
    <Text text="${items[index]}"/>
  <for/>
<Flex/>
```
上面的代码会被展开成。
```xml
<Flex>
  <Text text="${items[0]}"/>
  <Text text="${items[1]}"/>
  <Text text="${items[2]}"/>
  <Text text="${items[3]}"/>
<Flex/>
```