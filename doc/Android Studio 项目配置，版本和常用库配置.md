
#项目配置参考：http://blog.csdn.net/caroline_wendy/article/details/50552549

#1. 版本、常用库管理(两种方式)，
> 1. 配置在gradle.properties文件中(配置默认是字符串，所以引用的时候 'as int' 关键字转换一下)，引用：project.配置名 as int
> 2. 配置在项目的build.gradle文件中，引用：rootProject.配置名

#2. 参数管理，配置在gradle.properties里面
### 2.1 modle层级 build.gradle
    android {
      defaultConfig {
            // 设置参数的   类型\          变量名\                位置三个部分
          buildConfigField "String", "MARVEL_PUBLIC_KEY", "\"${marvel_public_key}\""
          buildConfigField "String", "MARVEL_PRIVATE_KEY", "\"${marvel_private_key}\""
          buildConfigField("String", "GOOGLE_URL", "\"https://www.google.com\"")
      }
    }
###  2.2 gradle.properties文件中的配置项
      marvel_public_key   = 74129ef99c9fd5f7692608f17abb88f9
      marvel_private_key  = 281eb4f077e191f7863a11620fa1865f2940ebeb
###  2.3 项目中通过BuildConfig.xxx引用参数
        例如：BuildConfig.MARVEL_PUBLIC_KEY
     
  

#3. 版本管理(配置在build.gradle)
### 3.1 第一种配置方式 ( 
        引用 (1) rootProject.ext.configuration.xxx, rootProject.ext.libraries.xxx
             (2) def cfg = rootProject.ext.configuration
                 def libs = rootProject.ext.librarys 在modlec层级的build.gradle，先定义一个变量)
            
    ext {
        configuration = [// 常用配置
                package          : "hpu.dingyue",
                buildToolsVersion: "23.0.1",
                compileVersion   : 23,
                version_code     : 1,
                ...
        ]
   
       libraries = [// 依赖库
                supportVersion    : "23.1.1",
                rxandroid         : "1.1.0",
                circleimageview   : "2.0.0"
                ...
        ]
    }
### 3.2 第二种配置方式 (引用方式 rootProject.ext.xxx)

    ext {
        targetSdkVersion = 23
        minSdkVersion = 14
        compileSdkVersion = 24
        buildToolsVersion = '24.0.2'
        supportLibVersion = '24.2.1'
        rxandroid = "1.1.0"
    }
    