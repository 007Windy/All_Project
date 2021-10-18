using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using test.Models;

namespace test.Controllers
{
    public class HomeController : Controller
    {
        managersystemEntities aa = new managersystemEntities();
        DBcontexte a = new DBcontexte();
        public ActionResult Index()
        {
            
            return View();
        }

        public ActionResult About()
        {
            a.add();
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact(HttpPostedFileBase image)
        {
            ViewBag.Message = "Your contact page.";
            
            return View();
        }
    }
}