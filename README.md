# FingerShow
给你的项目添加手指触摸特效

![image](https://github.com/miniminiming/FingerShow/tree/master/app/wave1.jpg)
![image](https://github.com/miniminiming/FingerShow/tree/master/app/wave2.jpg)

使用步骤如下

#1.引入library

  在项目的根build.gradle中加入   maven { url "https://jitpack.io" }
  
  加在代码块的如下位置
  
  allprojects {  
    repositories {
    
        jcenter()
        
        maven { url "https://jitpack.io" }
        
    }    
  }
  
  在需要引用的module的build.gradle中加入
  compile 'com.github.miniminiming:FingerShow:V2.0'
  

#2.在BaseActivity中调用library中的方法

  在BaseActivity中的onResume方法中调用  ViewUtils.addFingerlayout(this);  即可整个
  项目都具有触摸效果
  
  
#3.如果某个子页面由于某种问题不想使用特效

那么在该子页面的onCreate方法中调用   ViewUtils.requestNoFingerShow(this); 即可
