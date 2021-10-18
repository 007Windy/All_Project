using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Manager.Models;

namespace Manager.Controllers
{
 
    //单例模式确保实列唯一
    public class Dbcontextw:managersystemEntities
    {
       
     private static Dbcontextw dbcontextw;

       private Dbcontextw()
        {

        }
    
         public static Dbcontextw GetManagersystemEntities()
        {
            if(dbcontextw==null)
            {
                dbcontextw = new Dbcontextw();
            }
            return dbcontextw;
        }

    }
}