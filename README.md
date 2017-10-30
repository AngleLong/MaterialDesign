
参考文献:
[developer_Kale的文章](http://www.cnblogs.com/tianzhijiexian/p/4081562.html)

#5.0新特性(包含MaterialDesign)
##1.转场动画
> 曾经在android中Activity和Activity之间跳转时,我们使用的动画基本上都是**overridePendingTransition()**进行动画设置,这里不对这个动画的好坏进行评论,但是在5.X版本之后,出现了一个新的动画效果(转场动画)

###1.1转场动画种类(Transition)

- 进入: 一个进入的过度动画,决定了Activity中所有视图怎么进入屏幕;
- 退出: 一个退出的过度动画,决定了Activity中所有试图怎么退出屏幕;
- 共享元素: 一个共享元素过度动画决定两个Activity之间的过渡,怎么共享他们的视图. 

##2.Theme 主题设置
- @android:style/Theme.Material
- @android:style/Theme.Material.Light
- @android:style/Theme.Material.Light.DarkActionBar

> 我们可以在values-21中的styles.xml文件中继承这个主题,然后定制一些属性
![一张经典的图片](https://github.com/AngleLong/MaterialDesign/blob/master/resultPic/theme_bg.png)