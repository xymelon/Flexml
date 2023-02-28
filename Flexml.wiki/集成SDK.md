## 集成
添加到你的根build.gradle。

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
                        maven { url "http://repository.atricore.org/m2-release-repository" }
		}
	}
```

添加到你所使用的模块。

```
	dependencies {
	        implementation 'com.github.sanyuankexie.Flexml:litho:0.3.2'
	}
```
 
然后找个地方初始化。
```
LithoBuildTool.init(context)
```

接下来你需要从json中解析得到`com.guet.flexbox.TemplateNode`，这玩意是未绑定数据的模板文件，由模板编译器编译得到（模板编译器与Intellij插件打包在一起发布），使用Gson和FastJson都可以顺利完成解析。

```kotlin
package com.guet.flexbox

class TemplateNode(
        val type: String,
        val attrs: Map<String, String>?,
        val children: List<TemplateNode>?
)
```
然后创建`com.guet.flexbox.litho.TemplatePage`，注意，此过程必须不在主线程执行，因为build函数会执行模板解析和数据绑定并完成布局测量，会占用大量的CPU时间。
```kotlin
TemplatePage.create(c)
        .template(template)//也就是TemplateNode的实例。
        .data(myData)//JSONObject，Map，标准JavaBean（有getter，setter的）都可以。
        .build()
```
在TemplatePage实例化完成之后，将它赋值给`com.guet.flexbox.litho.HostingView`的`templatePage`，即可完成View的展示。
```kotlin
hostingView.templatePage = yourTemplatePage
```
## 包体积影响
* 如果没有RN和Glide增加1.5M
* 如果有Glide减少400kb
* 如果有RN减少250kb（RN依赖yoga）