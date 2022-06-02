import React from 'react';
import axios from 'axios';
import "@ui5/webcomponents/dist/Table.js";
import "@ui5/webcomponents/dist/TableColumn.js";
import "@ui5/webcomponents/dist/TableRow.js";
import "@ui5/webcomponents/dist/TableCell.js";
import "../navbar/Navbar.css";
import "@ui5/webcomponents/dist/Input.js";
import "@ui5/webcomponents/dist/Icon.js";
import "@ui5/webcomponents/dist/TextArea";
import "@ui5/webcomponents/dist/features/InputElementsFormSupport.js";

class TaskId extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            tasks: [],
            id: "",
            taskId: 0,
            newName: "",
            newComment: "",
            editable: 0
        };

        this.handleInputValue = this.handleInputValue.bind(this);
        this.populate = this.populate.bind(this);
        this.delete = this.delete.bind(this);
        this.search = this.search.bind(this);
        this.edit = this.edit.bind(this);
        this.kl = this.kl.bind(this);
        this.f = this.f.bind(this);
        this.va = this.va.bind(this);
        this.sa = this.sa.bind(this);
        this.lll = this.lll.bind(this);
    }

    addEventListeners(){
        document.querySelectorAll('.input').forEach(item => {
            item.addEventListener("change", this.handleInputValue);
          })
    }

    delete() {
        var url = 'http://localhost:5000/api/task/' + this.state.taskId
        axios.delete(url).then(r => {
            this.setState({
                tasks: []
            })
        })
    }

    f(){
        var url = 'http://localhost:5000/api/task/';
        axios.put(url, {
            "TaskOperation": "editNames",
            "TaskParameterOne": this.state.newName,
            "TaskParameterTwo": this.state.newComment,
            "TaskId": this.state.taskId
        }).then(r => {
            this.populate(this.state.taskId);
        }).then( r=> {
            this.setState({
                editable: 0
            })
        })
    }

    va(){
        var url = 'http://localhost:5000/api/task/';
        axios.put(url, {
            "TaskOperation": "datePlus",
            "TaskId": this.state.taskId
        }).then(r => {
            this.populate(this.state.taskId);
        })
    }

    sa(){
        var url = 'http://localhost:5000/api/task/';
        axios.put(url, {
            "TaskOperation": "dateMinus",
            "TaskId": this.state.taskId
        }).then(r => {
            this.populate(this.state.taskId);
        })

    }

    lll(){
        var operation = "setDone";
        if(this.state.tasks[0].TaskDone === "Завършена задача"){
            operation = "setUndone"
        }
        var url = 'http://localhost:5000/api/task/';
        axios.put(url, {
            "TaskOperation": operation,
            "TaskId": this.state.taskId
        }).then(r => {
            this.populate(this.state.taskId);
        })
    }



    search() {
        var b = this.state.id;
        var url = 'http://localhost:5000/api/task/' + b;
        axios.get(url).then(r => {
            if(r.data.length > 0) {
            this.setState({
                tasks: r.data,
                taskId: b,
                newComment: r.data[0].TaskDescription,
                newName: r.data[0].TaskName,
                editable: 0
            })}
            else {
                this.setState({
                    tasks: r.data,
                    taskId: b,
                    editable: 0
                })
            }
        })
    }

    populate (b) {
        var url = 'http://localhost:5000/api/task/' + b;
        axios.get(url).then(r => {
            this.setState({
                tasks: r.data,
                taskId: b
            })
        })
    }
componentDidUpdate(){
    this.removeEventListeners();
    this.addEventListeners();
}

removeEventListeners() {
    document.querySelectorAll('.input').forEach(item => {
        item.removeEventListener("change", this.handleInputValue);
      })
}

    componentDidMount() {
        this.addEventListeners();
        var numberPattern = /\d+/g;
        var b = window.location.href.match( numberPattern );
        if(b[1]) {
        this.populate(b[1]);
        }
    }

    handleInputValue(event) {
        console.log("a");
        const { name, value } = event.target;
        this.setState({
            [name]: value
        });
        console.log(this.state.requestDate);
    }

    edit(){
        this.setState({
            editable: 1
        })
    }

    kl(){
        this.setState({
            editable: 0
        })
    }

    render() {
        return (
            <div>
            <div className="right">
            <div className="go">
                    <ui5-label for="senderLastNameInput" required>Индентификация на Задачата:</ui5-label><br />
                    <ui5-input class="input" id="senderLastNameInput" value= {this.state.id} name="id" placeholder="" required></ui5-input><br />
                </div>

            {this.state.tasks.length !== 0 ? 
                <>
                <div className ="lala"><ui5-button onClick={this.search}>Търси</ui5-button></div>
                <div className ="lala"><ui5-button onClick={this.delete}>Изтрий</ui5-button></div>
                <div className ="lala" ><ui5-button onClick = {this.edit}>Редактирай</ui5-button></div>
                <div className ="lala" ><ui5-button onClick={this.va}>Премести ден напред</ui5-button></div>
                <div className ="lala" ><ui5-button onClick={this.sa}>Премести ден назад</ui5-button></div>
                <div className ="lala" ><ui5-button onClick={this.lll}>Промени Статус</ui5-button></div>
                </> : 
                 <>
                 <div className ="lala"><ui5-button onClick={this.search}>Търси</ui5-button></div>
                 <div className ="lala"><ui5-button onClick={this.delete} disabled>Изтрий</ui5-button></div>
                 <div className ="lala" ><ui5-button disabled >Редактирай</ui5-button></div>
                 <div className ="lala" ><ui5-button disabled>Премести ден назад</ui5-button></div>
                 <div className ="lala" ><ui5-button disabled>Премести ден напред</ui5-button></div>
                 <div className ="lala" ><ui5-button disabled>Промени Статус</ui5-button></div>
                 </>
                }

               
                </div>
                <div className="kaka">
                <ui5-table class="demo-table" id="table">
                    <ui5-table-column slot="columns" >
                        <span>ID</span>
                    </ui5-table-column>

                    <ui5-table-column slot="columns">
                        <span>Задача</span>
                    </ui5-table-column>

                    <ui5-table-column slot="columns">
                        <span>Коментар</span >
                    </ui5-table-column>

                    <ui5-table-column slot="columns">
                        <span>Дата</span>
                    </ui5-table-column> 
                    <ui5-table-column slot="columns">
                        <span>Статус</span>
                    </ui5-table-column>
                  
                    {this.state.tasks && this.state.tasks.map((u) => (
                        <ui5-table-row>
                            <ui5-table-cell>
                                {u.TaskId}
                            </ui5-table-cell>
                            <ui5-table-cell>
                                {u.TaskName}
                            </ui5-table-cell>
                            <ui5-table-cell>
                                {u.TaskDescription}
                            </ui5-table-cell>
                            <ui5-table-cell>
                                {u.TaskDate.substr(0, 10)}
                            </ui5-table-cell>
                            <ui5-table-cell>
                                {u.TaskDone}
                            </ui5-table-cell>
                        </ui5-table-row>
                    ))}
                 
                </ui5-table>
                </div>
                {this.state.tasks.length>0 && this.state.editable!==0?
                <div className="sss">
                    <div className="brat">
                <ui5-input class="input" onChange={this.handleInputValue} id="senderLastNameInput" value= {this.state.tasks[0].TaskName} name="newName" placeholder="" required></ui5-input><br />
              </div>
              <div className="brat">
                <ui5-textarea class="input" change={this.handleInputValue} value={this.state.tasks[0].TaskDescription}placeholder="Редактиране на коментар" maxlength="200" name="newComment"></ui5-textarea>
               </div>
               <>
                <ui5-button onClick={this.f}>Потвърди Редакция</ui5-button>
                <ui5-button onClick={this.kl}>Откажи</ui5-button>
                </>
                </div>:null}
            </div>
        )
    }
}

export default TaskId;