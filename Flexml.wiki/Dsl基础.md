## 属性的类型
flexml中的属性类型分为以下几种：
* text 也就是字符串
* value 可以是浮点和整数（使用一个float存储）
* enum 只能为特定的值
* bool 真或假
* pt pt是屏幕独立单位，1pt=屏幕宽度像素/360
* event 事件的回调函数
* typed 特殊类型

同时所有的属性又分为字面值和表达式两种情况。
```
xxx1="123456"
xxx2="abcdef"
```
以上两种情况都是字面值，可以被对应类型的属性解析（value或text）

但是如果你想在布局中使用传入TemplatePage中data的值、逻辑判断或内置函数，则必须使用`${}`包围表达式，例如：
```
borderRightTopRadius="${(index*3+2)==2?10:0}"
borderRightBottomRadius="${(index*3+2)==(images.size()-1)?10:0}"
```
## 通用属性
通用属性指的是所有组件都支持的属性。
### visibility
enum类型，支持visible、invisible和gone与Android中的定义类似，不再赘述。
### width、height、minWidth、maxWidth、minHeight、maxHeight
pt类型，表示宽高等。
### flexGrow
value类型，flexbox属性，定义组件的放大比例，默认为0，即如果存在剩余空间，也不放大。
### flexShrink
value类型，flexbox属性，属性定义了组件的缩小比例，默认为1，即如果空间不足，该项目将缩小。
### alignSelf
enum类型，属性允许单个项目有与其他项目不一样的对齐方式，可覆盖父组件的alignItems属性（参见[Flex](https://github.com/sanyuankexie/Flexml/wiki/Flex)）。
### margin、marginLeft、marginRight、marginTop、marginBottom
pt类型，表示外边距。
### padding、paddingLeft、paddingRight、paddingTop、paddingBottom
pt类型、表示内边距。
### shadowElevation（实验性功能，不要使用）
pt类型，表示阴影大小。
### borderColor
color类型，表示边框颜色支持ARGB的色值例如#ffffffff。
### borderRadius，borderLeftTopRadius，borderRightTopRadius，borderLeftBottomRadius，borderRightBottomRadius
pt类型，表示该组件4个圆角的弧度。
### borderWidth
pt类型，表示边框的宽度。

### onClick
event类型，支持类似于java的lambda，通常用它来改变数据并刷新页面，在布局xml中你可以这么写：
```
onClick="${()->{pageContext.refresh().with(()->{clicked=!clicked}).commit()}}"
```
上面这段链式调用的意思是，刷新该布局，并且将clicked改为相反的值，最后提交运行。

同时你还可以调用多个with，像这样。
```
onClick="${()->{pageContext.refresh().with(()->{clicked1=!clicked1}).with(()->{clicked2=!clicked2}).commit()}}"
```
或者一并native发送一些数据。
```
onClick="${()->{pageContext.refresh().with(()->{clicked=!clicked}).send('github.com').commit()}}"
```
native中的事件监听器会收到你发送的事件内容，详见[发送事件到native](https://github.com/sanyuankexie/Flexml/wiki/发送事件到native)。
### clickUrl
text类型，点击该组件时向native发送的url信息，可用于执行跳转逻辑。但是只有当onClick不存在时，它才生效。
### onVisible
event类型，在页面曝光后调用一次。你可以在这时向native发送一些曝光数据，比如像这样。
```
onVisible="${()->{pageContext.send(viewDataObj1,viewDataObj2,viewDataObj3)}}"
```
send是一个可变参函数，可以发送任意数量的数据。

**注意**：当在实时预览时，布局每刷新一次就会曝光一次，如果不关闭自动刷新，那就会一直疯狂触发曝光函数。
### background
text类型，background支持三种显示：
* `background="#ffffffff"` 将显示纯色。
* `background="https://www.google.com/xxxx.png"` 将显示异步加载的图片。
* `background="${gradient:linear('l2r','#6200ea','#d500f9')}"` 将显示渐变色。至于为什么要加`${}`请看[使用本地资源和渐变色](https://github.com/sanyuankexie/Flexml/wiki/使用本地资源和渐变色)。

## 相关资料
关于flexbox的相关内容，你还可以看看**阮一峰**大神的博客[《Flex 布局教程：语法篇》](https://www.ruanyifeng.com/blog/2015/07/flex-grammar.html)。

flexml的属性不使用中划线，与html略有不同，但和RN相似，例如在html中的flex-grow在flexml中就是flexGrow，但是其对应的值和意思不变。