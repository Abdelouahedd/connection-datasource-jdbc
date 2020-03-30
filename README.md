# connection-datasource-jdbc
JDBC : Java Database Connectivity is an API using to access a database.The API use a mechanism for dynamically loading the package 
java passed in the arguemt, the Driver Manager is used as a connection factory for creating JDBC connections.
JDBC support all instruction sql <p><i>(INSERT,UPDATE,DELETE...)</i></p>

![alt text](https://www.javatpoint.com/images/jdbc.JPG)

<h2>You can create you owen class for getting connection</h2>
in this repo I am using two ways to create a connection with a database mysql :
<h4>Methode 1 : DriverManger</h4>
Before using Driver mangerwe create a object that cantain all interface of driver loading dynamiclly
<STRONG> Class.forName("com.mysql.cj.jdbc.Driver")</STRONG> 
   this class use a statis methode called getConnection return a object of type Connection, the methode have 3 args 
        <li>db = url of database --> Exemple: jdbc:mysql://localhost/DataBaseName</li>
        <li>user = "root"</li> 
        <li>passwrd ="yourpass"</li>
<br>
<i style="color:red,color=red">Connection getConnection( String URL, String user, String password) </i>

<h4>Methode 2 : DataSource</h4>
DataSource need to know the JNDI name. The AppServer cares about the details and is not configured by the client application's
vendor, but by an admin where the application is hosted. 
In my case I'm using MYSQL, then I will use the class MysqlDataSource that implement DataSource interface.
   
   MysqlDataSource mysqlDS = new MysqlDataSource()
               <li>mysqlDS.setURL(url)</li>
               <li>mysqlDS.setUser(user)</li>
               <li> mysqlDS.setPassword(passwd)</li>
DATASOURCE has a function called getConnection return object of type Connection

   
