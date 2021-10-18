using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Manager.Models;
using System.Runtime.Serialization;
using System.Web.Script.Serialization;

namespace Manager.Controllers
{
    public class USer_Controller : Controller
    {
        Dbcontextw dbcontextw = Dbcontextw.GetManagersystemEntities();
      
        // GET: USer_
        public ActionResult Index()
        {
          
            return View();
        }

        public ActionResult NEW()
        {

            return View();
        }
        public ActionResult NEW2()
        {

            return View();
        }

        public ActionResult PT()
        {

            return View();
        }
        public ActionResult count()
        {

            return View();
        }

        public ActionResult sign()
        {

            return View();
        }
        public ActionResult Viewa()
        {

            return View();
        }

        //用户点击新闻获取新闻内容
        public ActionResult UserGetstory(story s)
        {
            List<story> stories = dbcontextw.story.Where<story>(f => f.title == s.title).ToList();
            if(stories.Count!=1)
            {
                return Json(new {code="-1",msg="错误404" }, JsonRequestBehavior.AllowGet);
            }
            else
            {
                //session
                Session["getstory"] = stories[0];
                return View();
            }
        }


        public ActionResult Search()
        {
            return View();
        }

        //搜索新闻     word搜索词语  type搜索字段类型  sort排序   模糊查询
        [HttpPost]
        public ActionResult Search(string word,string type,string sort)
        {

            List<news> n=new List<news>();

            //根据标题
            if (type.Equals("title"))
            {
                //使用排序 测试
                if(sort.Equals("down"))
                n = dbcontextw.news.Where<news>(f => f.title.Contains(word)).OrderByDescending(f=>f.author).ToList();
                else
                    n = dbcontextw.news.Where<news>(f => f.title.Contains(word)).OrderBy(f => f.author).ToList();
            }
            else if (type.Equals("author"))
            {
                n = dbcontextw.news.Where<news>(f => f.author.Contains(word)).ToList();
            }
            else if (type.Equals("keyword"))
            {
                n = dbcontextw.news.Where<news>(f => f.keyword.Contains(word)).ToList();
            }
            else if (type.Equals("content"))
            {
                n = dbcontextw.news.Where<news>(f => f.contents.Contains(word)).ToList();
            }
            

            if(n.Count==0)
            {
                return Json(new {code="-1",msg="无结果" },JsonRequestBehavior.AllowGet);
            }else
            {
                //序列化
                JavaScriptSerializer javaScriptSerializer = new JavaScriptSerializer();
                string json = javaScriptSerializer.Serialize(n);
                return Json(json, JsonRequestBehavior.AllowGet);
            }
        }

        //刷新新闻排行页面
        //public ActionResult refresh()
        //{
        //    return Json();
        //}


    }
}