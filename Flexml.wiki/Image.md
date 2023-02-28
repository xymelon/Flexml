Image 是用于显示图片的组件。
### scaleType
enum类型，与ImageView中的值对应，除了matrix以外都支持。
### src
text类型，图片的url，类似background，你也可以用它显示纯色或渐变色。
### blurRadius
value类型，高斯模糊半径，值在0-25之间取。当src类型不为图片时该项不生效。
### blurSampling
value类型，高斯模糊时的采样率，该值最小为1，值越大高斯模糊的效果越好，速度越快。当src类型不为图片时该项不生效。
### aspectRatio
value类型，宽高比，默认是1。
