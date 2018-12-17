// buildscript是项目和项目子项目的公共配置
buildscript {
  repositories {
    //使用本地仓库（就是gradle-user-home配置的文件夹，已经下载过的jar就不会再下载）
    mavenLocal()
    //使用阿里的maven仓库（避免去国外的地址下载，可以加快下载速度）
    maven {url 'http://maven.aliyun.com/nexus/content/groups/public/'}
    //使用官方maven仓库
    mavenCentral()
  }
  //springboot gradle 插件依赖
  dependencies {
    classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.6.RELEASE")
  }
}

//插件配置
//java开发插件
apply plugin: 'java'
//eclipse开发插件（会自动配置eclipse）
apply plugin: 'eclipse'
//springboot插件
apply plugin: 'org.springframework.boot'
//springboot依赖管理插件
apply plugin: 'io.spring.dependency-management'

//源代码的等级
sourceCompatibility = 1.8
//编译等级
targetCompatibility = 1.8
//源代码（src和test）编码格式，和workspace中的配置一致
[compileJava, compileTestJava, javadoc]*.options*.encoding = 'UTF-8'

//项目版本号
version = '1.0.0.0'

//项目的maven仓库
repositories {
  //使用本地仓库（就是gradle-user-home配置的文件夹，已经下载过的jar就不会再下载）
  mavenLocal()
  //使用阿里的maven仓库（避免去国外的地址下载，可以加快下载速度）
  maven {url 'http://maven.aliyun.com/nexus/content/groups/public/'}
  //使用官方maven仓库
  mavenCentral()
}

//项目依赖的第三方库配置
dependencies {
  //springboot依赖
  compile("org.springframework.boot:spring-boot-starter-web")
  //springboot开发工具，可以热部署代码（不要用于生成环境）
  compile group: 'org.springframework.boot', name: 'spring-boot-devtools', version: '2.0.6.RELEASE'
  //springboot整合mybatis
  compile("org.mybatis.spring.boot:mybatis-spring-boot-starter:1.3.2")
  // mysql jdbc驱动
  compile group: 'mysql', name: 'mysql-connector-java', version: '8.0.12'
  // fastjson依赖
  compile 'com.alibaba:fastjson:1.2.49'
  // pagehelper的springboot依赖
  compile group: 'com.github.pagehelper', name: 'pagehelper-spring-boot-starter', version: '1.2.9'
  // springboot的aop依赖
  compile group: 'org.springframework.boot', name: 'spring-boot-starter-aop', version: '2.0.6.RELEASE'
  //springboot测试依赖
  testCompile('org.springframework.boot:spring-boot-starter-test')
}
