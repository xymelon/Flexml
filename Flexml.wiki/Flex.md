Flex是Flexbox风格的容器组件，对应的职能类似于ViewGroup，或者更形象一点，你可以把它当成一个Google的[FlexboxLayout](https://github.com/google/flexbox-layout)。
### flexWrap
enum类型，默认情况下，组件都排在一条线（又称"轴线"）上。flexWrap属性定义，如果一条轴线排不下，如何换行。包括以下几种值：
* nowrap
* wrap
* wrapReverse
### justifyContent
enum类型，属性定义了项目在主轴上的对齐方式，包括以下几种值：
* flexStart 
* flexEnd 
* center 
* spaceBetween 
* spaceAround
### alignItems
enum类型，属性定义项目在交叉轴上如何对齐，包括以下值：
* flexStart 
* flexEnd 
* center 
* baseline 
* stretch