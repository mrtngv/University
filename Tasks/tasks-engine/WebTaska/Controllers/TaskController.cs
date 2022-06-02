using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.Extensions.Configuration;
using System.Data.SqlClient;
using System.Data;
using WebTaska.Models;

namespace WebTaska.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class TaskController : ControllerBase
    {
        private readonly IConfiguration _configuration;

        public TaskController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        [HttpGet]
        public JsonResult Get()
        {
            string query = @"select TaskId, TaskName, TaskDescription, TaskDate, TaskDone from dbo.Task order by TaskDate Desc";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("TaskAppCon");
            SqlDataReader myReader;
            using(SqlConnection myCon=new SqlConnection(sqlDataSource))
            {
                myCon.Open();
                using (SqlCommand myCommand = new SqlCommand(query, myCon))
                {
                    myReader = myCommand.ExecuteReader();
                    table.Load(myReader); 

                    myReader.Close();
                    myCon.Close();
                }
            }

            return new JsonResult(table);
        }

        [HttpPost]
        public JsonResult Post(Task task)
        {
            DateTime oDate = Convert.ToDateTime(task.TaskDate);
            if(task.TaskName == "")
            {
                return new JsonResult("Task added successfuly");
            }
            string query = @"insert into dbo.Task values ('" + task.TaskName + "', '" + task.TaskDescription + "', '" + oDate +  "','" + task.TaskDone +@"')";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("TaskAppCon");
            SqlDataReader myReader;
            using (SqlConnection myCon = new SqlConnection(sqlDataSource))
            {
                myCon.Open();
                using (SqlCommand myCommand = new SqlCommand(query, myCon))
                {
                    myReader = myCommand.ExecuteReader();
                    table.Load(myReader);

                    myReader.Close();
                    myCon.Close();
                }
            }
            return new JsonResult("Task added successfuly");
        }

        [HttpPut]
        public JsonResult Put(Ta ta )

        {
            
            string query = "";
            if (ta.TaskOperation == "editNames")
            {
                if (ta.TaskParameterOne != "" && ta.TaskParameterTwo != "")
                {
                    query = @"
                    update dbo.Task set 
                    TaskName = '" + ta.TaskParameterOne + @"'
                    ,TaskDescription = '" + ta.TaskParameterTwo + @"'
                    where TaskId = " + ta.TaskId + @" 
                    ";
                }
                else if (ta.TaskParameterOne != "")
                {
                    query = @"
                    update dbo.Task set 
                    TaskName = '" + ta.TaskParameterOne + @"'
                    where TaskId = " + ta.TaskId + @" 
                    ";
                }
                else if (ta.TaskParameterTwo != "")
                {
                    query = @"
                    update dbo.Task set 
                    TaskDescription = '" + ta.TaskParameterTwo + @"'
                    where TaskId = " + ta.TaskId + @" 
                    ";
                }
                else
                {
                    query = @"select TaskId, TaskName, TaskDescription, TaskDate, TaskDone from dbo.Task";
                }
                
            }
            else if (ta.TaskOperation == "datePlus")
            {
                query = @"
                    update dbo.Task  set TaskDate = DateAdd(DD,+1,TaskDate)" + @"
                    where TaskId = " + ta.TaskId + @" 
                    ";
            }
            else if (ta.TaskOperation == "dateMinus")
            {
                query = @"
                    update dbo.Task  set TaskDate = DateAdd(DD,-1,TaskDate)" + @"
                    where TaskId = " + ta.TaskId + @" 
                    ";
            }
            else if (ta.TaskOperation == "setDone")
            {
                query = @"
                    update dbo.Task set 
                    TaskDone = 'Завършена задача" + @"'
                    where TaskId = " + ta.TaskId + @" 
                    ";
            }
            else if (ta.TaskOperation == "setUndone")
            {
                query = @"
                    update dbo.Task set 
                    TaskDone = 'Да се направи" + @"'
                    where TaskId = " + ta.TaskId + @" 
                    ";
            }

            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("TaskAppCon");
            SqlDataReader myReader;
            using (SqlConnection myCon = new SqlConnection(sqlDataSource))
            {
                myCon.Open();
                using (SqlCommand myCommand = new SqlCommand(query, myCon))
                {
                    myReader = myCommand.ExecuteReader();
                    table.Load(myReader);

                    myReader.Close();
                    myCon.Close();
                }
            }
            return new JsonResult("Updated Successfully");
        }

        [HttpDelete("{id}")]
        public JsonResult Delete(int id)
        {
            string query = @"
                    delete from dbo.Task
                    where TaskId = " + id + @" 
                    ";

            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("TaskAppCon");
            SqlDataReader myReader;
            using (SqlConnection myCon = new SqlConnection(sqlDataSource))
            {
                myCon.Open();
                using (SqlCommand myCommand = new SqlCommand(query, myCon))
                {
                    myReader = myCommand.ExecuteReader();
                    table.Load(myReader);

                    myReader.Close();
                    myCon.Close();
                }
            }
            return new JsonResult("Deleted Successfully");
        }

        [HttpGet("{id}")]
        public JsonResult GetI(int id)
        {
            string query = @"select TaskId, TaskName, TaskDescription, TaskDate, TaskDone from dbo.Task where TaskId = " + id + @"";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("TaskAppCon");
            SqlDataReader myReader;
            using (SqlConnection myCon = new SqlConnection(sqlDataSource))
            {
                myCon.Open();
                using (SqlCommand myCommand = new SqlCommand(query, myCon))
                {
                    myReader = myCommand.ExecuteReader();
                    table.Load(myReader);

                    myReader.Close();
                    myCon.Close();
                }
            }

            return new JsonResult(table);
        }


        [HttpGet]
        [Route("api/dashboard")]
        public JsonResult GetIu()
        {
            string query = @"select (select count(*) from [dbo].[Task] as a where a.TaskDone = 'Завършена задача') as finished,
(select count(*) from [dbo].[Task] as a where a.TaskDone = 'Да се направи') as todo,
(select count(*) from [dbo].[Task] as a where a.TaskDone = 'Да се направи' and a.TaskDate between DateAdd(DD,-7,GETDATE() ) and GETDATE() ) as dateTodo,
(select count(*) from [dbo].[Task] as a where a.TaskDone = 'Завършена задача' and a.TaskDate between DateAdd(DD,-7,GETDATE() ) and GETDATE() ) as dateFinished";
            DataTable table = new DataTable();
            string sqlDataSource = _configuration.GetConnectionString("TaskAppCon");
            SqlDataReader myReader;
            using (SqlConnection myCon = new SqlConnection(sqlDataSource))
            {
                myCon.Open();
                using (SqlCommand myCommand = new SqlCommand(query, myCon))
                {
                    myReader = myCommand.ExecuteReader();
                    table.Load(myReader);

                    myReader.Close();
                    myCon.Close();
                }
            }

            return new JsonResult(table);
        }

    }
}
