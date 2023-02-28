var是一个text类型的属性，用于描述在foreach中所使用的临时变量的名字，items用来引用数据中的集合类型。

若items是一个大小为4的List<String>，使用foreach可以快速的展开集合。
```xml
<Flex>
  <foreach var="item" items="${items}">
    <Text text="${item}"/>
  <foreach/>
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