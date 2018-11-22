# 自定义 activemq 插件

## MessageLogPlugin
需要在 `activemq.xml` 的 `<broker>` 节点中插入以下内容：

```
<plugins>
    <bean xmlns="http://www.springframework.org/schema/beans" id="MessageLogPlugin" class="com.kangxiaoguang.activemq.plugin.MessageLogPlugin"/>
</plugins>
```