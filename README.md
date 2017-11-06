
参考文献:
[developer_Kale的文章](http://www.cnblogs.com/tianzhijiexian/p/4081562.html)
[wuzhen的文章](http://www.jianshu.com/p/378ea4ee5a54)


#5.0新特性(包含MaterialDesign)
##1.转场动画
> 曾经在android中Activity和Activity之间跳转时,我们使用的动画基本上都是**overridePendingTransition()**进行动画设置,这里不对这个动画的好坏进行评论,但是在5.X版本之后,出现了一个新的动画效果(转场动画)

###1.1转场动画种类(Transition)

- 进入: 一个进入的过度动画,决定了Activity中所有视图怎么进入屏幕;
- 退出: 一个退出的过度动画,决定了Activity中所有试图怎么退出屏幕;
- 共享元素: 一个共享元素过度动画决定两个Activity之间的过渡,怎么共享他们的视图. 

###1.2 主要实现类(ActivityOptionsCompat)
- ActivityOptionsCompat.makeCustomAnimation(context, enterResId, exitResId)
    ```
            //(这个动画类似于overridePendingTransition()这个动画)
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.slide_bottom_in, R.anim.slide_bottom_out);
            Intent intent = new Intent(this, SecondActivity.class);
            ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
    ```
- ActivityOptionsCompat.makeScaleUpAnimation(source, startX, startY, startWidth, startHeight)(从指定位置不断方法一个View,进行过度)
    - source 代表共享的View(以那个View为基准)
    - startX 代表从本页面的开始X轴的位置(以source为基准点的位置)
    - startY 代表从本页面的开始Y轴的位置(以source为基准点的位置)
    - startWidth 弹出的Activity开始的宽度
    - startHeight 弹出的Activity开始的高度
    ```
            //这个是在4.x上使用的,可实现新的Activity从某个固定的坐标以某个大小扩大至全屏
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeScaleUpAnimation(iv, width, height, 0, 0);
            intent = new Intent(this, AnimationResultActivity.class);
            ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());            
    ```
    这里有个问题注意就是,当你在RecycleView这种控件中获取子条目的位置的时候要注意,我使用的是下面的这个方法:
    ```
                    int[] location = new int[2];
                    view.getLocationOnScreen(location);
                    int width = location[0];
                    int height = location[1];    
    ```
    
- ActivityOptionsCompat.makeThumbnailScaleUpAnimation(source, thumbnail, startX, startY)
    > 这个动画和makeScaleUpAnimation非常相似,只不过这里是放大一个图片,最后过度到一个新的activity

- ActivityOptionsCompat.makeSceneTransitionAnimation(activity, sharedElement, sharedElementName)    
    > 这个实现起来就有点复杂了,共享元素动画

    - 首先在跳转页面的共享元素设置**android:transitionName="transitionImg"**(其中这个名字可以随便更改)
    - 在跳转只有准备共享的元素设置**android:transitionName="transitionImg"**(其中这个名字可以随便更改)
    - 跳转的逻辑
    
    ```
        if (Build.VERSION.SDK_INT > 20) {
            Intent intent = new Intent(this, AnimationResultActivity.class);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(AnimationActivity.this, iv, "transitionImg");
            ActivityCompat.startActivity(this, intent, optionsCompat.toBundle());
        } else {
            startActivity(new Intent(AnimationActivity.this, AnimationResultActivity.class));
        }
    ```
- ActivityOptionsCompat.makeSceneTransitionAnimation((Activity arg0, Pair<View, String>...  arg1)
    > 这个是基于上面的动画,但是可以指定多个共享元素,可以标明多个pair对象
    
    ps: 如果要是使用多个共享元素的时候要用下面的代码进行创建pair
    ```
    Pair<View, String> imagePair = Pair.create(mImageView, getString(R.string.image));
    ```

- 上面都是预设的动画,如果你想换动画的效果的话该如何实现呢?
    >系统预设的几种动画效果
     
     - change_bounds
     - change_clip_bounds
     - change_transition
     - change_image_transition
     - change_scroll
     
    - 首先在res目录下创建一个transition文件夹,然后在创建新的xml文件,这里举个例子:如果是change_bounds,则代码这么写
        
        ```
        <transitionSet xmlns:android="http://schemas.android.com/apk/res/android">
            <changeBounds />
            //这里也可以制动动画时长和插值器
            <changeBounds
                 android:interpolator="@android:interpolator/accelerate_decelerate"
                 android:duration="500"/>            
        </transitionSet>
        ```
        如果是change_clip_bounds则代码这么写
        ```
        <transitionSet xmlns:android="http://schemas.android.com/apk/res/android">
            <changeClipBounds />
        </transitionSet>
        ```
    - 使用方法(在style.xml中配置我们的theme)
        ```
        <resources>
            <style name="AppTheme" parent="Theme.AppCompat.Light">
                <item name="android:windowContentTransitions">true</item>
                <item name="android:windowAllowEnterTransitionOverlap">true</item>
                <item name="android:windowAllowReturnTransitionOverlap">true</item>
                <item name="android:windowEnterTransition">@android:transition/slide_bottom</item>
                <item name="android:windowExitTransition">@android:transition/slide_bottom</item>
                <item name="android:windowSharedElementEnterTransition">@transition/change_bounds</item>
                <item name="android:windowSharedElementExitTransition">@transition/change_bounds</item>
            </style>
        </resources>
        ```


##2.Theme 主题设置
- @android:style/Theme.Material
- @android:style/Theme.Material.Light
- @android:style/Theme.Material.Light.DarkActionBar

> 我们可以在values-21中的styles.xml文件中继承这个主题,然后定制一些属性
![一张经典的图片](https://github.com/AngleLong/MaterialDesign/blob/master/resultPic/theme_bg.png)

```
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>

        <!--添加的一些属性-->
        <item name="textColorPrimary">@android:color/white</item><!--标题栏文字颜色-->
        <item name="windowNoTitle">true</item><!--去掉标题栏-->
        <item name="windowActionBar">false</item><!--不显示Actionbar-->
    </style>
```

但是为了兼容低版本我们要想一些办法才可以的,主要是在4.4及以前的版本要使用** <item name="android:windowNoTitle">true</item>**来去掉标题栏

##3.Color(Palette库来获取图片的主要色彩)
- Vibrant （有活力） 
- Vibrant dark（有活力 暗色）
- Vibrant light（有活力 亮色）
- Muted （柔和） 
- Muted dark（柔和 暗色）
- Muted light（柔和 亮色）

```
//目标bitmap，代码片段
        Bitmap bm = BitmapFactory.decodeResource(getResources(),
                R.drawable.kale);
        Palette palette = Palette.generate(bm);
        if (palette.getLightVibrantSwatch() != null) {
            //得到不同的样本，设置给imageview进行显示
            iv.setBackgroundColor(palette.getLightVibrantSwatch().getRgb());
            iv1.setBackgroundColor(palette.getDarkVibrantSwatch().getRgb());
            iv2.setBackgroundColor(palette.getLightMutedSwatch().getRgb());
            iv3.setBackgroundColor(palette.getDarkMutedSwatch().getRgb());
        }
```

通过这个类,我们可以很方便的取得相应的颜色值,通过代码动态设置.

##4.RevealAnimator动画效果
> 首先这个动画是在5.0以上的版本才能使用的

 - view 作用的View
 - centerX 动画开始的中心点X
 - centerY 动画开始的中心点Y
 - startRadius 动画开始半径
 - endRadius 动画结束半径   
 
 ```
     public static Animator createCircularReveal(View view,
                int centerX,  int centerY, float startRadius, float endRadius) {
            return new RevealAnimator(view, centerX, centerY, startRadius, endRadius);
      }
 ```
 ![动画效果图](https://github.com/AngleLong/MaterialDesign/blob/master/resultPic/animation_bg.gif)
```
final View oval = this.findViewById(R.id.oval);  
oval.setOnClickListener(new View.OnClickListener() {  
    @Override  
    public void onClick(View v) {  
        Animator animator = ViewAnimationUtils.createCircularReveal(  
                oval,  
                oval.getWidth()/2,  
                oval.getHeight()/2,  
                oval.getWidth(),  
                0);  
        animator.setInterpolator(new AccelerateDecelerateInterpolator());  
        animator.setDuration(2000);  
        animator.start();  
    }  
});  
  
final View rect = this.findViewById(R.id.rect);  
rect.setOnClickListener(new View.OnClickListener() {  
    @Override  
    public void onClick(View v) {  
        Animator animator = ViewAnimationUtils.createCircularReveal(rect, 0, 0, 0,  (float) Math.hypot(rect.getWidth(), rect.getHeight()));  
        animator.setInterpolator(new AccelerateInterpolator());  
        animator.setDuration(2000);  
        animator.start();  
    }  
});  
```


##5.ToolBar
> ToolBar其实是一个ActionBar的变体,大大的扩展了ToolBar,我们可以像对待一个独立的控件去使用ToolBar,可以将他放在屏幕的任何位置,还可以将他改变高度或者在ToolBar上使用动画,从SDK看,很多actionBar的方法都已经废弃了,所以问们可以断定,未来ToolBar将完全取代ActonBar

###5.1布局文件
> toolBar可放在任何位置,只要你想...
```
    <android.support.v7.widget.Toolbar
        android:id="@+id/toolBar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="@color/colorPrimary"/>
```
###5.2关联ToolBar
####5.2.1 menu文件的使用
>这里穿插一个内容就是menu文件的使用,因为后面会用到,所以这里面简单的作一下说明:

- 菜单资源文件必须放在res/menu目录中.菜单资源文件必须使用\<menu\>标签作为根节点.除了\<menu\>标签外,还有两外两个标签用于设置菜单像和分组,分别是\<item\>和\<group\>
- \<menu\>标签没有任何属性,但可以嵌套在\<item\>标签中,表示子菜单.不过\<item\>标签中不能才嵌套\<menu\>标签

> \<menu\>标签的属性含义

- android:id 表示菜单项的资源ID
- android:menuCategory 同种菜单的种类 该属性可取4个值
    - container 
    - system
    - secondary
    - alternative
- android:orderInCategory 同类菜单的排列顺序;该属性是一个整数值
- android:title 标题
- android:titleCondensed 菜单的短标题,当菜单标题太长的时候会显示该属性的值
- android:icon 菜单的图片资源ID
- android:alphabeticShortcut 菜单项的字幕快捷键
- android:numericShortcut 菜单的数字快捷键
- android:checkable 表示菜单是否带有复选框,该属性可设计为true/false
- android:checked 如果菜单像带复选框(checkable属性为true),该属性表示复选框默认状态是否被选中
- android:visible 菜单默认状态是否可见
- android:enabled 菜单默认状态是否被激活
- app:showAsAction 
    - ifRoom 如果有空间的话,会显示在ToolBar上,当空间不足的时候会显示在列表上
    - always 一直显示在ToolBar上
    - collapseActionView (一般要配合ifRoom一起使用)声明这个操作视窗应该被折叠到一个按钮中,当用户选择这个按钮时,这个操作视窗展开否则,这个操作视窗在默认的情况下时可见的
    - never 永远不会显示,也不会显示在列表上,但是按menu键的时候会出来
    - withText 菜单项和它的图标一起显示

> \<group\>标签的属性含义

可以实现组合的显示,当组合的时候这里你可以看看实现的效果
```
 <item
        android:id="@+id/Tab3"
        android:title="组合"
        app:showAsAction="never">
        <menu>
            <item
                android:id="@+id/item1"
                android:title="组合1"/>
            <item
                android:id="@+id/item2"
                android:title="组合2"/>
            <item
                android:id="@+id/item3"
                android:title="组合3"/>
            <item
                android:id="@+id/item4"
                android:title="组合4"/>
        </menu>
    </item>
```

- android:checkableBehavior 设置该组件所有菜单上显示的选择组件(CHeckBox或RadioButton).如果该属性值设为all,显示CheckBox组件;如果设置single,显示RadioButton组件;如果设置none,显示正常的菜单项(不显示任何选择组件)

####5.2.2 ToolBar的设置
> 在代码中找到这个控件然后设置给ActionBar(setSupportActionBar(toolBar)) 但是这里有两个前提要注意一下:
- 主题中必须设置没有ActionBar(<item name="windowActionBar">false</item>),否则会出现里面报两个ActionBar的错误
- 当前Activity必须继承自AppCompatActivity

> 这里要注意,其实toolBar和ActionBar可以不联系到一起,如果不联系到一起的话,那么可以不用去setSupportActionBar(),也不用在activity中的onCreateOptionsMenu,你可以直接用(public void inflateMenu(int resId))方法直接设置menu文件 但是这样toolBar就完全变成一个独立于Activity的控件了,需要注意的是,如果你这么定义了,那么Activity的回调方法是不会监听toolBar上的menu的点击时间了,所有的点击时间都要通过toolBar提供那个都得监听其来实现.

- 关联ActionBar的写法
    ```
    setSupportActionBar(mToolBar);
    
    //这里是关联menu文件的
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    
    //设置点击事件的
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case id:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    ```
    
- 不关联ActionBar的写法
    ```
            mToolBar.inflateMenu(R.menu.menu_main);
            /*设置导航图标*/
            mToolBar.setNavigationIcon(R.mipmap.ic_launcher);
            mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "图标的点击事件执行了", Toast.LENGTH_SHORT).show();
                }
            });
            mToolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.name) {
                        Toast.makeText(MainActivity.this, "条目的点击事件", Toast.LENGTH_SHORT).show();
                        return true;
                    } else {
                        return false;
                    }
                }
            });
    ```
####5.2.3 ToolBar详细设置
- 一些简单的设置
    ```
            /*设置导航图标*/
            mToolBar.setNavigationIcon(R.mipmap.ic_launcher);
            /*设置标题*/
            mToolBar.setTitle("标题栏");
            /*设置副标题*/
            mToolBar.setSubtitle("子标题");
            /*设置标题显示颜色*/
            mToolBar.setTitleTextColor(Color.parseColor("#FFFFFF"));
            /*设置副标题的字体颜色*/
            mToolBar.setSubtitleTextColor(Color.parseColor("#FFFFFF"));
            /*设置Logo*/
            mToolBar.setLogo(R.drawable.ic_search_black_24dp);
            /*设置导航按钮*/
            mToolBar.setNavigationIcon(R.drawable.ic_search_black_24dp);
    ```
    这里注意上面这些设置要在setSupportActionBar();之前进行设置否则不会生效;

- 给ToolBar添加字是图

    这里还有一个问题,ToolBar有自己的LayoutParams,干什么用的呢?其实就是添加子视图的
    ```
            /*添加一个子视图*/
            TextView subText = new TextView(this);
            subText.setText("添加的子控件");
            Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
            params.setMargins(3, 3, 4, 4);
            subText.setLayoutParams(params);
            mToolBar.addView(subText);
    ```
    
####5.2.4 添加View在ToolBar上
- 代码添加
    ```
            /*添加一个子视图*/
            TextView subText = new TextView(this);
            subText.setText("添加的子控件");
            Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
            params.setMargins(3, 3, 4, 4);
            subText.setLayoutParams(params);
            mToolBar.addView(subText);
    ```
    
- XML文件中添加
    ```
        <android.support.v7.widget.Toolbar
            android:id="@+id/toolBar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:background="@color/colorPrimary">
    
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Clock"/>
        </android.support.v7.widget.Toolbar>
    ```
####5.2.5 常见问题
- 当在xml中设置一些属性的时候不起作用的问题(这个问题主要是因为toolBar的属性都要自定义属性才好使)
    ```
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:toolbar="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
    
        <android.support.v7.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@color/color_0176da"
            toolbar:navigationIcon="@mipmap/ic_drawer_home"
            toolbar:logo="@mipmap/ic_launcher"
            toolbar:subtitle="456"
            toolbar:title="123">
    
            <!--自定义控件-->
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Clock" />
        </android.support.v7.widget.Toolbar>
    </LinearLayout>
    ```
    
- Menu Item 的文字颜色设置无效 (通过设置**app:popupTheme="@style/Theme.ToolBar.Base"**主题进行替换,这里注意是app开头的,你懂的)
    ```
        <style name="Theme.ToolBar.Base" parent="Theme.AppCompat.Light.NoActionBar">
            <item name="android:textColorPrimary">@color/colorAccent</item>
            <item name="android:textSize">20sp</item>
        </style>
    ```
    
- 最后上一个仿知乎的ToolBar设置(这里就贴出一个主要的主题,其他的上面都涉及到了))
    ```
        <style name="zhiHuToolBar" parent="Theme.ToolBar.Base">
            <item name="actionOverflowButtonStyle">@style/ActionButton.Overflow.ZhiHu</item>
        </style>
    
        <style name="ActionButton.Overflow.ZhiHu" parent="android:style/Widget.Holo.Light.ActionButton.Overflow">
            <item name="android:src">@mipmap/ic_overflow</item>
        </style>
    ```
    
    这里注意一点就是app:theme="@style/Theme.ToolBar.ZhiHu"和app:popupTheme="@style/Theme.ToolBar.Base"的区别
##6.沉浸式状态栏[Translucent System Bar](http://www.jianshu.com/p/0acc12c29c1b)

> 实现沉浸式状态栏有两种办法:

###1.通过style进行设置(类似于中华万年历,这种适合顶部是直接显示图片这种)
> 首先就是要分别设置三个style,这里主要是通过设置**android:windowTranslucentStatus****android:windowTranslucentNavigation****android:statusBarColor**等三个属性进行设置
  
- values/style.xml(这个是正常的主题)
      
        ```
        <style name="ImageTranslucentTheme" parent="AppTheme">
            <!--在Android 4.4之前的版本上运行，直接跟随系统主题-->
        </style>
        ```
- values-v19/style.xml(这个是19版本的时候使用的主题)
    ```
    <style name="ImageTranslucentTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <item name="android:windowTranslucentStatus">true</item>
        <item name="android:windowTranslucentNavigation">true</item>
    </style>
     ```
     
- values-v21/style.xml(这个是21版本的时候使用的主题)     
    ```
    <style name="ImageTranslucentTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <item name="android:windowTranslucentStatus">false</item>
        <item name="android:windowTranslucentNavigation">true</item>
        <!--Android 5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色-->
        <item name="android:statusBarColor">@android:color/transparent</item>
    </style>
     ```
     
> 设置完成之后要在清单文件的Activity中设置主题,然后要在每个页面的跟标签添加一个属性**android:fitsSystemWindows="true"**至此就可以实现第一种沉浸式的状态栏了,但是这里注意一个问题就是如果使用toolBar的话那些属性在其他两个清单文件也要设置
###2.Tab栏和系统导航栏分开设置(类似于QQ音乐,这种适合顶部是纯色的)
> 这种相对于上面那种方式的话简单一点(但是这种实现的话,不变成页面多次绘制的问题)

- values-v21/style(这个是21版本都得时候使用的主题)
    ```
    <style name="ColorTranslucentTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <item name="android:windowTranslucentStatus">false</item>
        <item name="android:windowTranslucentNavigation">true</item>
        <item name="android:statusBarColor">@color/color_31c27c</item>
    </style>
    ```
>这个也需要对 **android:fitsSystemWindows="true"** 这个属性进行设置,然后在设置toolBar的颜色或者是自己实现布局的颜色

###3.一些简单的设置
> 每个布局都需要设置 **android:fitsSystemWindows="true"** 确实很麻烦,所以使用代码设置的话是不是会很好
    ```
            ViewGroup contentFrameLayout = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
            View parentView = contentFrameLayout.getChildAt(0);
            if (parentView != null && Build.VERSION.SDK_INT >= 14) {
                parentView.setFitsSystemWindows(true);
            }
    ```
    通过上面的代码就可以不必在每一个页面都设置 **android:fitsSystemWindows="true"** 这个属性了