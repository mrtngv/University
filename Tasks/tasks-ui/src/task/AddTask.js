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
import "@ui5/webcomponents/dist/Calendar";

class AddTask extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            tasks: [],
            id: "",
            taskId: 0,
            newName: "",
            newComment: "",
            editable: 0,
            koko: ""
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
        this.era = this.era.bind(this);
        this.ooo = this.ooo.bind(this);
    }

    addEventListeners() {
        document.querySelectorAll('.input').forEach(item => {
            item.addEventListener("change", this.handleInputValue);
        })
        document.querySelectorAll('.cal').forEach(item => {
            item.addEventListener("selected-dates-change", this.era);
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

    f() {
        var url = 'http://localhost:5000/api/task/';
        axios.put(url, {
            "TaskOperation": "editNames",
            "TaskParameterOne": this.state.newName,
            "TaskParameterTwo": this.state.newComment,
            "TaskId": this.state.taskId
        }).then(r => {
            this.populate(this.state.taskId);
        }).then(r => {
            this.setState({
                editable: 0
            })
        })
    }

    va() {
        var url = 'http://localhost:5000/api/task/';
        axios.put(url, {
            "TaskOperation": "datePlus",
            "TaskId": this.state.taskId
        }).then(r => {
            this.populate(this.state.taskId);
        })
    }

    sa() {
        var url = 'http://localhost:5000/api/task/';
        axios.put(url, {
            "TaskOperation": "dateMinus",
            "TaskId": this.state.taskId
        }).then(r => {
            this.populate(this.state.taskId);
        })

    }

    lll() {
        var operation = "setDone";
        if (this.state.tasks[0].TaskDone === "Завършена задача") {
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

    era(e) {
        var b = e.detail.timestamp * 1000;
        var date = new Date(b);
        var day = date.getDate();
        var month = date.getMonth() + 1;
        var year = date.getFullYear();

        if (day < 10) {
            day = "0" + day;
        }

        if (month < 10) {
            month = "0" + month;
        }

        var haha = month + "/" + day + "/" + year;
        console.log(haha);
        this.setState({
            koko: haha
        })

    }

    ooo() {
        var url = 'http://localhost:5000/api/task/';
        axios.post(url, {
            "TaskName": this.state.newName,
            "TaskDescription": this.state.newComment,
            "TaskDate": this.state.koko,
            "TaskDone": "Да се направи"
        }).then(r => {
            this.setState({
                newName: "",
                newComment: ""
            })
        })

        

    }


    search() {
        var b = this.state.id;
        var url = 'http://localhost:5000/api/task/' + b;
        axios.get(url).then(r => {
            if (r.data.length > 0) {
                this.setState({
                    tasks: r.data,
                    taskId: b,
                    newComment: r.data[0].TaskDescription,
                    newName: r.data[0].TaskName,
                    editable: 0
                })
            }
            else {
                this.setState({
                    tasks: r.data,
                    taskId: b,
                    editable: 0
                })
            }
        })
    }

    populate(b) {
        var url = 'http://localhost:5000/api/task/' + b;
        axios.get(url).then(r => {
            this.setState({
                tasks: r.data,
                taskId: b
            })
        })
    }
    componentDidUpdate() {
        this.removeEventListeners();
        this.addEventListeners();
    }

    removeEventListeners() {
        document.querySelectorAll('.input').forEach(item => {
            item.removeEventListener("change", this.handleInputValue);
        })
        document.querySelectorAll('.cal').forEach(item => {
            item.removeEventListener("selected-dates-change", this.era);
        })

    }

    componentDidMount() {
        this.addEventListeners();
        var date = new Date();
        var day = date.getDate();
        var month = date.getMonth() + 1;
        var year = date.getFullYear();

        if (day < 10) {
            day = "0" + day;
        }

        if (month < 10) {
            month = "0" + month;
        }

        var haha = month + "/" + day + "/" + year;
        this.setState({
            koko: haha
        })

    }

    handleInputValue(event) {
        console.log("a");
        const { name, value } = event.target;
        this.setState({
            [name]: value
        });
        console.log(this.state.requestDate);
    }

    edit() {
        this.setState({
            editable: 1
        })
    }

    kl() {
        this.setState({
            editable: 0
        })
    }

    render() {
        return (
            <div>
                <div className="jjjj">
                    <div className="brat">
                        <ui5-label for="senderLastNameInput" required>Име на задачата</ui5-label><br />
                        <ui5-input class="input" onChange={this.handleInputValue} id="senderLastNameInput" value={this.state.newName} name="newName" placeholder="" required></ui5-input><br />
                    </div>
                    <div className="brat">
                        <ui5-textarea class="input" change={this.handleInputValue} value={this.state.newComment} placeholder="Добавяне на коментар" maxlength="200" name="newComment"></ui5-textarea>
                    </div>
                    <ui5-calendar class="cal"></ui5-calendar>
                    <div className="lolo">
                        <ui5-button onClick={this.ooo}>Запази Задача</ui5-button>
                    </div>
                </div>
            </div>
        )
    }
}

export default AddTask;