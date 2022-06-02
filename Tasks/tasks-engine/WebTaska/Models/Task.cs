using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebTaska.Models
{
    public class Task
    {

        public int TaskId { get; set; }

        public string TaskName { get; set; }

        public string TaskDescription { get; set; }

        public string TaskDate { get; set; }

        public string TaskDone { get; set; }

    }
}
