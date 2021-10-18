using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Manager.Models;
using System.Runtime.Serialization;
using System.Web.Script.Serialization;
using Utility.Security;

namespace Manager.Controllers
{
    public class HomeController : Controller
    {
        //数据上下文      
        managersystemEntities dbxontext = new managersystemEntities();
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }


        public ActionResult ManagerIndex()
        {

            return View();
        }

        //页面
        public ActionResult Login()
        {
            return View();
        }

        //登录
        [HttpPost]
        public ActionResult Login(string iden,string VCode,manager m )
        {
            //管理员
            if(iden.Equals("1"))
            {
                //查询
                manager m1 = dbxontext.manager.SingleOrDefault(f => f.managername == m.managername ); 
                if(m1==null)
                {//用户不存在
                    return Json(new {code="-1",msg="用户不存在或者密码错误" }, JsonRequestBehavior.AllowGet);
                }else if(! m1.password.Equals(m.password))
                {//
                    return Json(new { code = "-1", msg = "用户不存在或者密码错误" }, JsonRequestBehavior.AllowGet);
                }else
                {
                    //返回Session
                    Session["manager"] = m1;
                    return Json(new { code = "1", msg = "登录成功" ,url="/Home/ManagerIndex"}, JsonRequestBehavior.AllowGet);
                }

            }//用户
            //else if (iden.Equals("2"))
            //{

            //}
            //else
                return Json(new { code="-1",msg="未知错误"});
        }


        public ActionResult article_show()
        {
            return View();
        }

        //返回全部文章  article
        [HttpPost]
        public ActionResult article_show(string author)
        {
            
            //提供序列化的类
            JavaScriptSerializer javaScriptSerializer = new JavaScriptSerializer();
            List<Models.news> v = dbxontext.news.ToList<news>();
            news n = v[0];
            DateTime dateTime=(DateTime) n.createtome;
            string data=dateTime.ToString();
            //序列化对象
            string json = javaScriptSerializer.Serialize(v);
            return Json(json,JsonRequestBehavior.AllowGet);
        }

      

        //搜索新闻
        [HttpPost]
        public ActionResult Search(news n,string method)
        {

            news placee = new news();
            //如果是查看返回session的key为shows
            if (method == "show")
            {
                placee = dbxontext.news.Where<news>(f => f.title == n.title && f.author == n.author).SingleOrDefault();
                Session["shows"] =placee;
                return Json(new { code = "1" ,url="/Home/article_detail"},JsonRequestBehavior.AllowGet);
            }
            else if (method == "change")
            {
                placee = dbxontext.news.Where<news>(f => f.title == n.title && f.author == n.author).SingleOrDefault();
                Session["change"] = placee;
                return Json(new { code = "2" ,url="/Home/article_update"},JsonRequestBehavior.AllowGet);
            }
            else
                return Json(new { code = "-1" },JsonRequestBehavior.AllowGet);
           
        }


        public ActionResult article_detail()
        {
            return View();
        }


        public ActionResult article_update()
        {
            return View();
        }

        //更改数据库数据  id不可更改
        [HttpPost]
        [ValidateInput(false)]
        public ActionResult article_update(news n)
        {
            //使用last确保返回的对象唯一
            news place = dbxontext.news.Where<news>(f => f.title == n.title && f.author == n.author).Last();
            int id = n.id;
            string title = n.title;
            string sql = "update news set"+"id="+place.id+",title="+n.title+",author="+n.author+",source="+n.source+",keyword="+n.keyword+",contents="+n.contents;
            int a=dbxontext.Database.ExecuteSqlCommand(sql);
            return Json(new { code = "1", msg = "数据更新成功" }, JsonRequestBehavior.AllowGet);
        }

        //改变审核状态
        [HttpPost]
        public ActionResult check(news n)
        {
           List <news> place = dbxontext.news.Where<news>(f => f.title == n.title && f.author == n.author).ToList();
            if (place.Count!=1)
            {
                return Json(new { code = "-1", msg = "输入错误" });
            }
            else
            {
                news p = place[0];
                int a = p.id;
                if(n.status.Equals("通过"))
                {
                    string sql = "update news set status="+ " \"未通过\" " +"where id= " + p.id;
                }
                else
                {
                    string sql = "update news set status="+ " \"通过\" " +"yes where id= " + p.id;
                }
                return Json(new { code = "1", msg = "审核状态更改成功" });
            }
            
        }


        //删除
        [HttpPost]
        public ActionResult delete(news n)
        {
            news place= dbxontext.news.Where<news>(f => f.title == n.title && f.author == n.author).SingleOrDefault();
            int count=dbxontext.news.Where<news>(f => f.title == n.title && f.author == n.author).Count();
            if(count==1 && place!=null)
            {

                dbxontext.news.Remove(n);
                return Json(new { code="1",msg="删除成功"});
            }else
            {
                return Json(new { code = "-1", msg = "删除异常" });
            }
            
        }


      
        public ActionResult ADD()
        {
            return View();
        }

        //增加数据
        [HttpPost]
        [ValidateInput(false)]
        public ActionResult ADD(news n)
        {
            //数据检查
            news retu = dbxontext.news.Add(n);
            string co = n.contents.ToString();
            if (retu == null)
            {
                return Json(new { code = "-1", msg = "数据错误" }, JsonRequestBehavior.AllowGet);
            }
            else
            {
                dbxontext.SaveChanges();
                return Redirect("/Home/ADD");
            }
        }


        //public ActionResult ManagerChange(manager m)
        //{
        //    return Json();
        //}

        //退出系统
        public ActionResult LoginOut()
        {
           
                Session.RemoveAll();
                return Redirect("");
            
        }


        //生成验证码
        public FileResult GetVCodeImg()
        {
            ValidateCode validateCode = new ValidateCode();
            string code = validateCode.CreateValidateCode(4);
            Session["VCode"] = code;
            //获得验证码图片
            byte[] bytes = validateCode.CreateValidateGraphic(code);
            //返回图片
            return File(bytes, @"image/gif");
        }

        //获取验证码
        public string GetVCode()
        {
            return Session["VCode"].ToString();
        }


    }
}