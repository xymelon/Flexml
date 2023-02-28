若下面的valueToTest为flase，则if之下的所有标签都不会被执行数据绑定和渲染。
```xml
<if test="${valueToTest}">
   <Flex/>
<if/>
```