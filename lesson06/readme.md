# Spring Boot JPA
## 配置
<table cellspacing="0" border="0">
	<colgroup width="161"></colgroup>
	<colgroup width="181"></colgroup>
	<colgroup width="393"></colgroup>
	<tbody><tr>
		<td height="18" align="left" valign="middle"><font face="DejaVu Sans" color="#000000">配置</font></td>
		<td align="left" valign="middle"><font face="DejaVu Sans" color="#000000">值</font></td>
		<td align="left" valign="middle"><font face="DejaVu Sans" color="#000000">说明</font></td>
	</tr>
	<tr>
		<td height="198" align="left" valign="middle"><font color="#000000">spring.jpa.database</font></td>
		<td align="left" valign="middle"><font color="#000000">1.DEFAULT<br>2.DB2<br>3.DERBY<br>4.H2<br>5.HSQL<br>6.INFORMIX<br>7.MYSQL<br>8.ORACLE<br>9.POSTGRESQL<br>10.SQL_SERVER<br>11.SYBASE</font></td>
		<td align="left" valign="middle"><font face="DejaVu Sans" color="#000000">支持数据库种类</font></td>
	</tr>
	<tr>
		<td height="126" align="left" valign="middle"><font color="#000000">spring.jpa.hibernate.ddl-auto</font></td>
		<td align="left" valign="middle"><font color="#000000">1.validate<br>2.create<br>3.create-drop<br>4.update</font></td>
		<td align="left" valign="middle"><font face="DejaVu Sans" color="#000000">1.validate 加载 Hibernate 时，验证创建数据库表结构<br>2.create 每次加载 Hibernate ，重新创建数据库表结构，这就是导致数据库表数据丢失的原因。<br>3.create-drop 加载 Hibernate 时创建，退出是删除表结构<br>4.update 加载 Hibernate 自动更新数据库结构</font></td>
	</tr>
</tbody></table>

## 常用注解 
<table cellspacing="0" border="0">
	<colgroup width="161"></colgroup>
	<colgroup width="181"></colgroup>
	<colgroup width="393"></colgroup>
	<colgroup width="1284"></colgroup>
	<tbody><tr>
		<td height="18" align="left" valign="middle"><font face="DejaVu Sans" color="#000000">注解</font></td>
		<td align="left" valign="middle"><font face="DejaVu Sans" color="#000000">属性</font></td>
		<td align="left" valign="middle"><font face="DejaVu Sans" color="#000000">实例</font></td>
		<td align="left" valign="middle"><font face="DejaVu Sans" color="#000000">说明</font></td>
	</tr>
	<tr>
		<td height="54" align="left" valign="middle"><font color="#000000">@Entity</font></td>
		<td align="left" valign="middle"><font color="#000000">name</font></td>
		<td align="left" valign="middle"><font color="#000000">@Entity(name="table_name")</font></td>
		<td align="left" valign="middle"><font face="DejaVu Sans" color="#000000">1.被Entity标注的实体类将会被JPA管理控制<br>2.若定义name属性所查的表名应是table_name. 如: SELECT * FROM table_name<br>3.置于实体顶部</font></td>
	</tr>
	<tr>
		<td height="36" align="left" valign="middle"><font color="#000000">@Table</font></td>
		<td align="left" valign="middle"><font color="#000000">name</font></td>
		<td align="left" valign="middle"><font color="#000000">@Table("name="tt")</font></td>
		<td align="left" valign="middle"><font face="DejaVu Sans" color="#000000">1.当你想生成的数据库表名与实体类名称不同时，使用 @Table(name="表名")<br>2.与@Entity标注并列使用，置于实体</font></td>
	</tr>
	<tr>
		<td height="18" align="left" valign="middle"><font color="#000000">@Id</font></td>
		<td align="left" valign="middle"><font color="#000000"><br></font></td>
		<td align="left" valign="middle"><font color="#000000">@Id</font></td>
		<td align="left" valign="middle"><font face="DejaVu Sans" color="#000000">1.用于实体类的一个属性或者属性对应的getter方法的标注，被标注的的属性将映射为数据库主键</font></td>
	</tr>
	<tr>
		<td height="18" align="left" valign="middle"><font color="#000000">@GeneratedValue</font></td>
		<td align="left" valign="middle"><font color="#000000"><br></font></td>
		<td align="left" valign="middle"><font color="#000000">@GeneratedValue</font></td>
		<td align="left" valign="middle"><font face="DejaVu Sans" color="#0000FF">1.与'@Id一同使用，用于标注主键的生成策略,JPA 默认方式为AUTO自增长 在javax.persistence.GenerationType可查看不同设置</fount></td>
	</tr>
	<tr>
		<td height="126" align="left" valign="middle"><font color="#000000">@Column</font></td>
		<td align="left" valign="middle"><font color="#000000">name<br>unique<br>nullable<br>insertable<br>updatetable<br>columnDefinition<br>length</font></td>
		<td align="left" valign="middle"><font color="#000000">@Column(name="DESC",<br> nullable=false, <br>length=512)</font></td>
		<td align="left" valign="middle"><font face="DejaVu Sans" color="#000000">1. name: 指定映射到数据库中的字段名<br>2. unique: 是否唯一，默认为false<br>3. nullable: 是否允许为null，默认为true<br>5. insertable: 是否允许插入，默认为true<br>6. updatetable: 是否允许更新，默认为true<br>7. columnDefinition: 指定该属性映射到数据库中的实际类型，通常是自动判断<br>8. length: 指定数据长度，默认255</font></td>
	</tr>
	<tr>
		<td height="72" align="left" valign="middle"><font color="#000000">@Temporal</font></td>
		<td align="left" valign="middle"><font color="#000000">TemporalType.DATE<br>TemporalType.TIME<br>TemporalType.TIMESTAMP</font></td>
		<td align="left" valign="middle"><font color="#000000">@Temporal(TemporalType.DATE)<br>@Temporal(TemporalType.TIME) <br>@Temporal(TemporalType.TIMESTAMP) </font></td>
		<td align="left" valign="middle"><font face="DejaVu Sans" color="#000000">@Temporal(TemporalType.DATE) 表示映射到数据库中的时间类型为 DATE，只有日期<br>@Temporal(TemporalType.TIME) 表示映射到数据库中的时间类型为 TIME，只有时间<br>@Temporal(TemporalType.TIMESTAMP) 表示映射到数据库中的时间类型为 TIMESTAMP,日期和时间都有</font></td>
	</tr>
</tbody></table>
