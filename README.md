# FingerShow
给你的项目添加手指触摸特效

使用步骤如下

1.引入library

  在项目的根build.gradle中加入   maven { url "https://jitpack.io" }
  
  在需要引用的module的build.gradle中加入
  compile 'com.github.miniminiming:FingerShow:V2.0'

2.在BaseActivity中调用library中的方法

  在BaseActivity中的onResume方法中调用  ViewUtils.addFingerlayout(this);  即可
  
3.如果某个子页面由于某种问题不想使用特效，那么在该页面的onCreate方法中调用   ViewUtils.requestNoFingerShow(this); 即可
