###1.单例与多例

@Component
默认单例

@Component

@Scope("prototype")多例的配置

@Component,@Service,@Controller,@Repository
这 4 个注释是等效的，@Repository，@Service,@Controller这 3 个注释分别和持久层、业务层和控制层（Web 层）相对应。虽然目前这 3 个注释和 @Component 相比没有什么新意，但 Spring 将在以后的版本中为它们添加特殊的功能。所以，如果 Web 应用程序采用了经典的三层分层结构的话，最好在持久层、业务层和控制层分别采用 @Repository、@Service 和 @Controller 对分层中的类进行注释，而用 @Component 对那些比较中立的类进行注释。

@Service("student")相当于 xml配置中得bean  id = student ，不加的话，默认别名就是当前类名，但是首字母小写