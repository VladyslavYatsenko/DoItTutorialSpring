<html>
    <head>
        <title>Users</title>
    </head>
    <body>
    <#if users?has_content>
     <ul>
          <#list users as user>
            <li>${user.name} ${user.surname} ${user.email}</li>
          </#list>
        </ul>
        <#else>
            <p>No Data Available</p>
    </#if>
    </body>
</html>