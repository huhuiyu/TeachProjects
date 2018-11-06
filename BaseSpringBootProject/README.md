# springboot基础项目

## 目录说明
- src/main/java 源代码目录
- src/test/java 测试代码目录（只在ide中可以执行，build的jar中会被排除）
- src/main/resources 资源文件目录（非java类型的文件（配置）都在这里面，build后会和编译后的类文件合并）

## package说明
- aop，切面编程相关类
- base，基类类型
- config，全局配置相关类
- controller，控制器类
- converter，数据类型转换相关类
- dao，数据访问接口
- entity，实体对象
- exception，自定义异常类
- model，数据模型类-负责控制器和服务层的数据传递
- service，服务层（接口）
- service.impl，服务层实现
- task，日程计划任务
- utils，工具类
  
## 配置文件说明
- build.gradle，gradle核心配置，更新该文件需要gradle refresh联网更新依赖
- application.yml,application.properties，springboot核心配置文件
- mybatis-config.xml，mybatis核心配置文件，需要在springboot核心配置文件中指定
- resources中dao包里面的xml文件，mybatis的数据映射配置文件，必须和dao接口文件在同一个目录，且必须和dao文件同名，里面的namespace和dao匹配，里面的id和dao的方法匹配，全体mapper文件包定义在mybatis核心配置文件中。

## run目录说明
- 项目打包执行相关脚本
- pathinfo.bat，打包依赖工具目录配置，需要修改为正确的位置，为其它脚本的核心依赖
- versioninfo.bat，查看相关工具的版本信息
- command.bat，启动依赖工具的命令行
- buildapp.bat，项目打包
- runapp.bat，项目执行，需要先执行buildapp.bat，且需要修改文件中jar的名称为项目打包的名称
  
## 开发说明
- 确保build.gradle正确且已经刷新并完成项目依赖
- 确保数据库和相关表已经创建，且修改spring配置文件中的数据源配置
- 确保mybatis相关配置文件路径和包名称正确
- 确保aop中的切面定义包路径正确
- 如果config中有MyConfig类，请确保里面的值注入和application.preporties中的名称一致
- 确保MyWebConfig类中的跨域配置(发布到正式服务器才修改)正确
- 开发entity，一般是和数据表一致的pojo（简单java对象），可能包含表的依赖关系
- 开发dao（类需要mapper注解）以及配对的xml配置（也可以是注解配置），也就是业务逻辑的数据库语句
- 开发model类（必须继承于model基础类），匹配页面提交的数据模型以及业务相关数据模型
- 开发service接口以及相应的实现类（类需要Service注解，还需要Transactional），服务层负责将model数据通过dao持久化到数据库，或者查询出来
- 开发控制器类，该类负责将页面的数据包装成model，然后调用serivce完成业务逻辑，类需要RestController或者Controller注解，通过RequestMapping注解配置url访问地址（全局不能有两个相同的地址配置）
- 如果有计划任务请参考task中的类完成
