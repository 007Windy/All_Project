using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using test.Models;

namespace test.Controllers
{
    public class DBcontexte
    {
        managersystemEntities manager= new managersystemEntities();

       public void add()
        {
            int code = 8;
            string password = "56778";
            string tablename = "manager";
            string sql = "update "+tablename+" set managercode="+code+",password="+password+" where id=1";
            manager.Database.ExecuteSqlCommand(sql);
        }

    }
}